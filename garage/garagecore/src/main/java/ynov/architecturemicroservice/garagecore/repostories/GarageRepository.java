package ynov.architecturemicroservice.garagecore.repostories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ynov.architecturemicroservice.garagecore.entities.Garage;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Integer> {

}
