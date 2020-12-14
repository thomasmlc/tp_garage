package ynov.architecturemicroservice.voiturecore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynov.architecturemicroservice.voiturecore.entities.Voiture;
import ynov.architecturemicroservice.voiturecore.exceptions.CouldNotDeleteVoitureException;
import ynov.architecturemicroservice.voiturecore.exceptions.VoitureNotFoundException;
import ynov.architecturemicroservice.voiturecore.services.VoitureService;

import java.util.List;

@RestController
@RequestMapping(path="/voitures")
public class VoitureController {

    private final VoitureService voitureService;

    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<Voiture> addNewVoiture (@RequestBody Voiture newVoiture) {
        return new ResponseEntity<>(voitureService.create(newVoiture), HttpStatus.CREATED);
    }

    @GetMapping()
    public @ResponseBody ResponseEntity<List<Voiture>> getAllVoitures(@RequestParam(value = "garageId", required = false) Integer garageId) {
        if(garageId != null) return new ResponseEntity<>(voitureService.findAllByGarageId(garageId), HttpStatus.OK);
        return new ResponseEntity<>(voitureService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getOneVoiture(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(voitureService.findOne(id), HttpStatus.OK);
        } catch (VoitureNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Voiture> updateVoiture(@PathVariable Integer id, @RequestBody Voiture voiture) {
        return new ResponseEntity<>(voitureService.update(id, voiture), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<?> deleteVoiture(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(voitureService.deleteById(id), HttpStatus.OK);
        } catch (CouldNotDeleteVoitureException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
