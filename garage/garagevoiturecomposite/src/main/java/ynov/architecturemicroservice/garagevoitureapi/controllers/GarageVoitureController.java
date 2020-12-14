package ynov.architecturemicroservice.garagevoitureapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynov.architecturemicroservice.garagevoitureapi.models.DTO.GarageVoituresDTO;
import ynov.architecturemicroservice.garagevoitureapi.models.Garage;
import ynov.architecturemicroservice.garagevoitureapi.models.VoitureGarage;
import ynov.architecturemicroservice.garagevoitureapi.services.GarageService;
import ynov.architecturemicroservice.garagevoitureapi.services.GarageVoitureService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api")
public class GarageVoitureController {

    private final GarageVoitureService garageVoitureService;

    public GarageVoitureController(GarageVoitureService garageVoitureService) {
        this.garageVoitureService = garageVoitureService;
    }

    @GetMapping("/garagevoitures")
    public @ResponseBody ResponseEntity<List<GarageVoituresDTO>> getAllGaragesVoitures() {
        return new ResponseEntity<>(garageVoitureService.getAllGaragesVoitures(), HttpStatus.OK);
    }

    @GetMapping("/garagevoitures{id}")
    public @ResponseBody ResponseEntity<GarageVoituresDTO> getGarageVoitures(@PathVariable Integer id) {
        return new ResponseEntity(garageVoitureService.getGarageVoitures(id), HttpStatus.OK);
    }

    @GetMapping("/garages4")
    public @ResponseBody ResponseEntity<List<GarageVoituresDTO>> getGarages4() {
        return new ResponseEntity(garageVoitureService.getGarages4(), HttpStatus.OK);
    }

    @GetMapping("/mercedes")
    public @ResponseBody ResponseEntity<List<Garage>> getMercedes() {
        return new ResponseEntity(garageVoitureService.getMercedes(), HttpStatus.OK);
    }

    @GetMapping("/voituregarage{id}")
    public @ResponseBody ResponseEntity<VoitureGarage> getVoitureGarage(@PathVariable Integer id) {
        return new ResponseEntity(garageVoitureService.getVoitureGarage(id), HttpStatus.OK);
    }

}
