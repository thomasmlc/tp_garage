package ynov.architecturemicroservice.garagevoitureapi.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ynov.architecturemicroservice.garagevoitureapi.clients.GarageClient;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;

@Service
public class GarageService {

    Logger logger =  LoggerFactory.getLogger(GarageService.class);

    final
    GarageClient garageClient;

    public GarageService(GarageClient garageClient) {
        this.garageClient = garageClient;
    }

    public Garage[] getAllGarages() {
        return garageClient.getAllGarages();
    }
}
