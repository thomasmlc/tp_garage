package ynov.architecturemicroservice.garagevoitureapi.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;

import java.util.Optional;

@Component
public class GarageClient {

    private static final String BASE_URL = "http://localhost:8081/garages/";

    private final RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(GarageClient.class);

    public GarageClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Garage[] getAllGarages() {
        logger.info(String.format("Fetching all garages from url : %s", BASE_URL));
        try {
            return restTemplate.getForObject(BASE_URL, Garage[].class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    public Garage getOneGarage(int id) {
        logger.info(String.format("Fetching garage with id %d from url : %s", id, BASE_URL+id));
        try {
            return restTemplate.getForObject(BASE_URL+id, Garage.class);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }


}
