package ynov.architecturemicroservice.garagevoitureapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;
import ynov.architecturemicroservice.garagevoitureapi.services.VoitureService;

@RestController
@RequestMapping(path="/api")
public class VoitureController {

    private final VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @GetMapping("/voitures")
    public @ResponseBody
    ResponseEntity<Voiture[]> getAllGarage() {
        return new ResponseEntity<>(voitureService.getAllVoitures(), HttpStatus.OK);
    }
}
