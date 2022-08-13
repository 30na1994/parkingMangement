package com.sina.parkingManagement.controller;


import com.sina.parkingManagement.common.PagingData;
import com.sina.parkingManagement.dto.request.ParkingRequestDTO;
import com.sina.parkingManagement.dto.response.ParkingResponseDTO;
import com.sina.parkingManagement.mapper.ParkingMapper;
import com.sina.parkingManagement.model.Parking;
import com.sina.parkingManagement.service.IParkingService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parking")
@AllArgsConstructor
public class ParkingController {

    private final IParkingService parkingService;
    private final ParkingMapper parkingMapper;


    @PostMapping
    public ParkingResponseDTO addParking(@RequestBody ParkingRequestDTO parkingRequestDTO) {
        Parking parking = parkingMapper.toParking(parkingRequestDTO);
        Parking saved = parkingService.addParking(parking);
        return parkingMapper.toParkingResponseDTO(saved);
    }

    @GetMapping(value = "/{page}/{size}")
    public PagingData<ParkingResponseDTO> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Parking> parkingPage = parkingService.paging(page, size);
        int totalPage = parkingPage.getTotalPages();
        List<Parking> data = parkingPage.getContent();
        List<ParkingResponseDTO> parkingResponseDTOList = parkingMapper.toParkingResponseDTOList(data);
        return new PagingData<>(totalPage, page, parkingResponseDTOList);
    }

    @GetMapping(value = "/{id}")
    public ParkingResponseDTO findParking(@PathVariable Long id) {
        Parking parking = parkingService.getParking(id);
        return parkingMapper.toParkingResponseDTO(parking);
    }

    @PutMapping
    public ParkingResponseDTO updateParking(@RequestBody ParkingRequestDTO parkingRequestDTO) {
        Parking parking = parkingMapper.toParking(parkingRequestDTO);
        Parking saved = parkingService.updateParking(parking);
        return parkingMapper.toParkingResponseDTO(saved);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteParking(@PathVariable Long id){
        parkingService.deleteParking(id);
    }
}
