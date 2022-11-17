package com.bdtest.TestBD.repositories;

import com.bdtest.TestBD.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository <ParkingSpotModel, UUID>{

    boolean existsByMatriculaCar(String matriculaCar);
}
