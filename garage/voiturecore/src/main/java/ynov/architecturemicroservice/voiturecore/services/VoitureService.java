package ynov.architecturemicroservice.voiturecore.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ynov.architecturemicroservice.voiturecore.entities.Voiture;
import ynov.architecturemicroservice.voiturecore.exceptions.CouldNotDeleteVoitureException;
import ynov.architecturemicroservice.voiturecore.exceptions.VoitureNotFoundException;
import ynov.architecturemicroservice.voiturecore.repositories.VoitureRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class VoitureService {

    Logger logger =  LoggerFactory.getLogger(VoitureService.class);

    final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public List<Voiture> findAll() {
        return voitureRepository.findAll();
    }

    public Voiture findOne(int id) throws VoitureNotFoundException {
        logger.info(String.format("Fetching voiture with id %d", id));
        return voitureRepository.findById(id).orElseThrow(() -> new VoitureNotFoundException(id));
    }

    public Voiture create(Voiture newVoiture) {
        logger.info("Creating new voiture");
        return voitureRepository.save(newVoiture);
    }

    public Voiture update(int id, Voiture newVoiture) {
        return voitureRepository.findById(id)
                .map(voiture -> {
                    if(newVoiture.getYear() != null) { voiture.setYear(newVoiture.getYear());}
                    if(newVoiture.getModel() != null) { voiture.setModel(newVoiture.getModel());}
                    logger.info(String.format("Updating voiture with id %d", id));
                    return voitureRepository.save(voiture);
                })
                .orElseGet(() -> {
                    newVoiture.setId(id);
                    logger.info(String.format("Creating voiture with id %d", id));
                    return voitureRepository.save(newVoiture);
                });
    }

    public Boolean deleteById(int id) throws CouldNotDeleteVoitureException {
        logger.info(String.format("Deleting voiture with id %d", id));
        voitureRepository.deleteById(id);
        if(voitureRepository.existsById(id)) {
           throw new CouldNotDeleteVoitureException(id);
        }
        return true;
    }

    public ArrayList<Voiture> findAllByGarageId(Integer id){
        logger.info(String.format("Deleting voiture of garage with id %d", id));
        return voitureRepository.findAllByGarageId(id);
    }
}
