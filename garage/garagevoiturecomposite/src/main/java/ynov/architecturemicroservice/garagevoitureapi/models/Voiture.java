package ynov.architecturemicroservice.garagevoitureapi.models;

import lombok.Data;

@Data
public class Voiture {

    private Integer id;

    private Integer garageId;

    private String year;

    private String model;

}
