package ynov.architecturemicroservice.garagevoitureapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ynov.architecturemicroservice.garagevoitureapi.clients.GarageClient;
import ynov.architecturemicroservice.garagevoitureapi.clients.VoitureClient;
import ynov.architecturemicroservice.garagevoitureapi.exceptions.GarageNotFoundException;
import ynov.architecturemicroservice.garagevoitureapi.models.DTO.GarageVoituresDTO;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;
import ynov.architecturemicroservice.garagevoitureapi.models.VoitureGarage;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class GarageVoitureService {

    Logger logger =  LoggerFactory.getLogger(GarageVoitureService.class);

    final
    GarageClient garageClient;

    final
    VoitureClient voitureClient;

    public GarageVoitureService(GarageClient garageClient, VoitureClient voitureClient) {
        this.garageClient = garageClient;
        this.voitureClient = voitureClient;
    }

    public ArrayList<GarageVoituresDTO> getAllGaragesVoitures(){
        ArrayList<GarageVoituresDTO> garagesVoitures = new ArrayList<>();
        Garage[] garages = garageClient.getAllGarages();
        for (Garage garage : garages) {
            garagesVoitures.add(
                    new GarageVoituresDTO (
                            garage.getId(),
                            garage.getName(),
                            garage.getCity(),
                            voitureClient.getAllVoituresForGarage(garage.getId())
                    )
            );
        }
        return garagesVoitures;
    }

    public ArrayList<GarageVoituresDTO> getGarageVoitures(int id){
        ArrayList<GarageVoituresDTO> garagesVoitures = new ArrayList<>();
        Garage[] garages = garageClient.getAllGarages();
        try{
            for (Garage garage : garages){
                if(garage.getId() == id) {
                    garagesVoitures.add(
                            new GarageVoituresDTO(
                                    garage.getId(),
                                    garage.getName(),
                                    garage.getCity(),
                                    voitureClient.getAllVoituresForGarage(garage.getId())
                            )
                    );
                }
            }
        }catch (Exception e){
            return null;
        }
        return garagesVoitures;
    }

    public ArrayList<GarageVoituresDTO> getGarages4() {

        ArrayList<GarageVoituresDTO> garagesVoitures = new ArrayList<>();
        Garage[] garages = garageClient.getAllGarages();
        for (Garage garage : garages){
            if(voitureClient.getAllVoituresForGarage(garage.getId()).length > 4) {
                garagesVoitures.add(
                        new GarageVoituresDTO(
                                garage.getId(),
                                garage.getName(),
                                garage.getCity(),
                                voitureClient.getAllVoituresForGarage(garage.getId())
                        )
                );

            }
        }
        return garagesVoitures;
    }

    public ArrayList<Garage> getMercedes() {

        ArrayList<Garage> garagesMercedes = new ArrayList<>();
        ArrayList<GarageVoituresDTO> garagesVoitures = new ArrayList<>();
        Garage[] garages = garageClient.getAllGarages();

        for (Garage garage : garages){
            Voiture[] voitures = voitureClient.getAllVoituresForGarage(garage.getId());
            for(Voiture voiture : voitures){
                if (voiture.getModel().equals("mercedes")){
                    garagesMercedes.add(
                            garage
                    );
                    break;
                }
            }
        }
        return garagesMercedes;
    }

    public VoitureGarage getVoitureGarage(int voitureId) {

        try {
            Voiture voiture = voitureClient.getOneVoiture(voitureId);
            Garage garage = garageClient.getOneGarage(voiture.getGarageId());
            return new VoitureGarage(voiture, garage);
        }catch (Exception e){
            return null;
        }

    }


}
