package ynov.architecturemicroservice.garagevoitureapi.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import ynov.architecturemicroservice.garagevoitureapi.models.Voiture;

@Data
@AllArgsConstructor
public class GarageVoituresDTO {

    private Integer id;

    private String name;

    private String city;

    private Voiture[] voitures;

}
