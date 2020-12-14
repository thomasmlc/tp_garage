package ynov.architecturemicroservice.voiturecore.exceptions;

public class CouldNotDeleteVoitureException extends Exception {
    public CouldNotDeleteVoitureException(int id) {super(String.format("Error deleting voiture with id %d", id)); }
}
