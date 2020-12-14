package ynov.architecturemicroservice.garagecore.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynov.architecturemicroservice.garagecore.entities.Garage;
import ynov.architecturemicroservice.garagecore.exceptions.CouldNotDeleteGarageException;
import ynov.architecturemicroservice.garagecore.exceptions.GarageNotFoundException;
import ynov.architecturemicroservice.garagecore.services.GarageService;

import java.util.List;

@RestController
@RequestMapping(path="/garages")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<Garage> addNewGarage (@RequestBody Garage newGarage) {
        return new ResponseEntity<>(garageService.create(newGarage), HttpStatus.CREATED);
    }

    @GetMapping()
    public @ResponseBody ResponseEntity<List<Garage>> getAllGarages() {
        return new ResponseEntity<>(garageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getOneGarage(@PathVariable Integer id) {
       try {
           return new ResponseEntity<>(garageService.findOne(id), HttpStatus.OK);
       } catch (GarageNotFoundException e) {
           return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<Garage> updateGarage(@PathVariable Integer id, @RequestBody Garage garage) {
        return new ResponseEntity<>(garageService.update(id, garage), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<?> deleteGarage(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(garageService.deleteById(id), HttpStatus.OK);
        } catch (CouldNotDeleteGarageException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
