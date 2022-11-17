package com.bdtest.TestBD.services;

import com.bdtest.TestBD.models.ParkingSpotModel;
import com.bdtest.TestBD.repositories.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByMatriculaCar(String matriculaCar) {
        return parkingSpotRepository.existsByMatriculaCar(matriculaCar);
    }



    public Page<ParkingSpotModel> findAll(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }

    public ParkingSpotModel findById(UUID id) {
        return getById(id);
    }

    public void deleteById(UUID id) {
        parkingSpotRepository.delete(getById(id));
         throw new ResponseStatusException(HttpStatus.OK, "Deletou");
    }



    public ParkingSpotModel getById(UUID id) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotRepository.findById(id);
        if (parkingSpotModelOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Parking Spot not found.");
        }
        return parkingSpotModelOptional.get();
    }
}
