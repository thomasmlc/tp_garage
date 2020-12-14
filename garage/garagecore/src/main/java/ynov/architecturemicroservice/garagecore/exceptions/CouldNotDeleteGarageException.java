package ynov.architecturemicroservice.garagecore.exceptions;

public class CouldNotDeleteGarageException extends Exception {
    public CouldNotDeleteGarageException(int id) {super(String.format("Error deleting garage with id %d", id)); }
}
