package ynov.architecturemicroservice.voiturecore.exceptions;

public class VoitureNotFoundException extends Exception {
    public VoitureNotFoundException(int id) {super(String.format("Voiture with id %d not found.", id)); }
}
