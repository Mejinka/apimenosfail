package com.bdtest.TestBD.controllers;

import com.bdtest.TestBD.dtos.ParkingSpotDto;
import com.bdtest.TestBD.models.ParkingSpotModel;
import com.bdtest.TestBD.services.ParkingSpotService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin (origins = "*", maxAge = 3600)
@RequestMapping("parking-spot")
public class ParkingSpotController {
    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        if(parkingSpotService.existsByMatriculaCar(parkingSpotDto.getMatriculaCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Matricula Car is already in use");
        }
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }
    @GetMapping
    public ResponseEntity<Page<ParkingSpotModel>> getAllParkingSpots(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ParkingSpotModel getOneParkingSpot(@PathVariable UUID id){
        return parkingSpotService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteParkingSpot(@PathVariable UUID id) {
        parkingSpotService.deleteById(id);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id" ) UUID id,
                                                    @RequestBody @Valid ParkingSpotDto parkingSpotDto){
        Optional<ParkingSpotModel> parkingSpotModelOptional = Optional.ofNullable(parkingSpotService.getById(id));
        if (!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot nao foi encontrado");
        }
        var parkingSpotModel = parkingSpotModelOptional.get();
        parkingSpotModel.setProduto(parkingSpotDto.getProduto());
        parkingSpotModel.setMatriculaCar(parkingSpotDto.getMatriculaCar());
        parkingSpotModel.setReferencia(parkingSpotDto.getReferencia());
        parkingSpotModel.setClienteName(parkingSpotDto.getClienteName());

        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
    }
}
