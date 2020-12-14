package ynov.architecturemicroservice.garagevoitureapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;
import ynov.architecturemicroservice.garagevoitureapi.services.GarageService;

@RestController
@RequestMapping(path="/api")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping("/garages")
    public @ResponseBody ResponseEntity<Garage[]> getAllGarage() {
        return new ResponseEntity<>(garageService.getAllGarages(), HttpStatus.OK);
    }


}
