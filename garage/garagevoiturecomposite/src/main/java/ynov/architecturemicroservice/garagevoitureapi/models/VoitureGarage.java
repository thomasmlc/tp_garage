package ynov.architecturemicroservice.garagevoitureapi.models;

import lombok.Data;

@Data
public class VoitureGarage {

    public Voiture voiture;
    public Garage garage;

    public VoitureGarage(Voiture voiture, Garage garage) {
        this.garage = garage;
        this.voiture = voiture;
    }
}
