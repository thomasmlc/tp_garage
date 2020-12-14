package ynov.architecturemicroservice.garagevoitureapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ynov.architecturemicroservice.garagevoitureapi.clients.VoitureClient;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;

@Service
public class VoitureService {

    Logger logger =  LoggerFactory.getLogger(VoitureService.class);

    final
    VoitureClient voitureClient;

    public VoitureService(VoitureClient voitureClient) {
        this.voitureClient = voitureClient;
    }

    public Voiture[] getAllVoitures() {
        return voitureClient.getAllVoiture();
    }
}
