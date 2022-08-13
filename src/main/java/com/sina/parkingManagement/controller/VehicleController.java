package com.sina.parkingManagement.controller;


import com.sina.parkingManagement.common.PagingData;
import com.sina.parkingManagement.dto.request.VehicleRequestDTO;
import com.sina.parkingManagement.dto.response.VehicleResponseDTO;
import com.sina.parkingManagement.mapper.VehicleMapper;
import com.sina.parkingManagement.model.Vehicle;
import com.sina.parkingManagement.service.IVehicleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "vehicle")
@AllArgsConstructor
public class VehicleController {

    private IVehicleService vehicleService;
    private final VehicleMapper vehicleMapper;


    @PostMapping
    public VehicleResponseDTO addVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleRequestDTO);
        Vehicle saved = vehicleService.addVehicle(vehicle);
        return vehicleMapper.toParkingResponseDTO(saved);
    }

    @GetMapping(value = "/{page}/{size}")
    public PagingData<VehicleResponseDTO> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Vehicle> vehiclePage = vehicleService.paging(page, size);
        int totalPage = vehiclePage.getTotalPages();
        List<Vehicle> data = vehiclePage.getContent();
        List<VehicleResponseDTO> vehicleResponseDTOList = vehicleMapper.toVehicleResponseDTOList(data);
        return new PagingData<>(totalPage, page, vehicleResponseDTOList);
    }

    @GetMapping(value = "/{id}")
    public VehicleResponseDTO findVehicle(@PathVariable Long id) {
        Vehicle vehicle = vehicleService.getVehicle(id);
        return vehicleMapper.toParkingResponseDTO(vehicle);
    }

    @PutMapping
    public VehicleResponseDTO updateVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleRequestDTO);
        Vehicle saved = vehicleService.updateVehicle(vehicle);
        return vehicleMapper.toParkingResponseDTO(saved);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }
}
