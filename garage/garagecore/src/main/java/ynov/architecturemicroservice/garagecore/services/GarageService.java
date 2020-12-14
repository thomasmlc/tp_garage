package ynov.architecturemicroservice.garagecore.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ynov.architecturemicroservice.garagecore.entities.Garage;
import ynov.architecturemicroservice.garagecore.exceptions.CouldNotDeleteGarageException;
import ynov.architecturemicroservice.garagecore.exceptions.GarageNotFoundException;
import ynov.architecturemicroservice.garagecore.repostories.GarageRepository;

import java.util.List;


@Service
public class GarageService {

    Logger logger =  LoggerFactory.getLogger(GarageService.class);

    final GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public List<Garage> findAll() {
        return garageRepository.findAll();
    }

    public Garage findOne(int id) throws GarageNotFoundException {
        logger.info(String.format("Fetching garage with id %d", id));
        return garageRepository.findById(id).orElseThrow(() -> new GarageNotFoundException(id));
    }

    public Garage create(Garage newGarage) {
        logger.info("Creating new garage");
        return garageRepository.save(newGarage);
    }

    public Garage update(int id, Garage newGarage) {
        return garageRepository.findById(id)
                .map(garage -> {
                    if(newGarage.getName() != null) { garage.setName(newGarage.getName());}
                    if(newGarage.getCity() != null) { garage.setCity(newGarage.getCity());}
                    logger.info(String.format("Updating garage with id %d", id));
                    return garageRepository.save(garage);
                })
                .orElseGet(() -> {
                    newGarage.setId(id);
                    logger.info(String.format("Creating garage with id %d", id));
                    return garageRepository.save(newGarage);
                });
    }

    public Boolean deleteById(int id) throws CouldNotDeleteGarageException{
        logger.info(String.format("Deleting garage with id %d", id));
        garageRepository.deleteById(id);
        if(garageRepository.existsById(id)) {
           throw new CouldNotDeleteGarageException(id);
        }
        return true;
    }
}
