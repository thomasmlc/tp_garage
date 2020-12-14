package ynov.architecturemicroservice.voiturecore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ynov.architecturemicroservice.voiturecore.entities.Voiture;

import java.util.ArrayList;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Integer> {

    ArrayList<Voiture> findAllByGarageId(Integer garageId);
}
