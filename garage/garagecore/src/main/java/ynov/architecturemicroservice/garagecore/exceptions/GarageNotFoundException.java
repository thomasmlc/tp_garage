package ynov.architecturemicroservice.garagecore.exceptions;

public class GarageNotFoundException extends Exception {
    public GarageNotFoundException(int id) {super(String.format("Garage with id %d not found.", id)); }
}
