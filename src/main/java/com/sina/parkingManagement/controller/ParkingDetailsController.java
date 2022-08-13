package com.sina.parkingManagement.controller;


import com.sina.parkingManagement.common.PagingData;
import com.sina.parkingManagement.common.SearchCriteria;
import com.sina.parkingManagement.dto.request.ParkingDetailRequestDTO;
import com.sina.parkingManagement.dto.response.ParkingDetailResponseDTO;
import com.sina.parkingManagement.mapper.ParkingDetailsMapper;
import com.sina.parkingManagement.model.ParkingDetails;
import com.sina.parkingManagement.service.IParkingDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "parkingDetail")
@AllArgsConstructor
public class ParkingDetailsController {

    private final IParkingDetailsService parkingDetailService;
    private final ParkingDetailsMapper parkingDetailsMapper;

    @PostMapping(value = "/enterRequest")
    public ParkingDetailResponseDTO addParkingDetail(@RequestBody ParkingDetailRequestDTO parkingDetailRequestDTO) {
        ParkingDetails parkingDetails = parkingDetailsMapper.toParkingDetail(parkingDetailRequestDTO);
        ParkingDetails saved = parkingDetailService.registerRequest(parkingDetails);
        return parkingDetailsMapper.toParkingDetailResponseDTO(saved);
    }

    @GetMapping(value = "/{page}/{size}")
    public PagingData<ParkingDetailResponseDTO> findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<ParkingDetails> parkingDetailPage = parkingDetailService.paging(page, size);
        int totalPage = parkingDetailPage.getTotalPages();
        List<ParkingDetails> data = parkingDetailPage.getContent();
        List<ParkingDetailResponseDTO> parkingDetailResponseDTOList = parkingDetailsMapper.toParkingDetailResponseDTOList(data);
        return new PagingData<>(totalPage, page, parkingDetailResponseDTOList);
    }

    @GetMapping(value = "/{plateNumber}/{page}/{size}")
    public PagingData<ParkingDetailResponseDTO> findAllByVehicleId(@PathVariable String plateNumber, @PathVariable Integer page, @PathVariable Integer size) {
        Page<ParkingDetails> parkingDetailPage = parkingDetailService.reportVehicleTraffic(plateNumber, page, size);
        int totalPage = parkingDetailPage.getTotalPages();
        List<ParkingDetails> data = parkingDetailPage.getContent();
        List<ParkingDetailResponseDTO> parkingDetailResponseDTOList = parkingDetailsMapper.toParkingDetailResponseDTOList(data);
        return new PagingData<>(totalPage, page, parkingDetailResponseDTOList);
    }

    @GetMapping(value = "/{id}")
    public ParkingDetailResponseDTO findParkingDetail(@PathVariable Long id) {
        ParkingDetails parkingDetails = parkingDetailService.getParkingDetail(id);
        return parkingDetailsMapper.toParkingDetailResponseDTO(parkingDetails);
    }

    @PutMapping("/exitRequest")
    public ParkingDetailResponseDTO updateParkingDetail(@RequestBody ParkingDetailRequestDTO parkingDetailRequestDTO) {
        ParkingDetails parkingDetails = parkingDetailsMapper.toParkingDetail(parkingDetailRequestDTO);
        ParkingDetails saved = parkingDetailService.exitRequest(parkingDetails);
        return parkingDetailsMapper.toParkingDetailResponseDTO(saved);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteParkingDetail(@PathVariable Long id) {
        parkingDetailService.deleteParkingDetail(id);
    }

    @PostMapping("/search")
    public List<ParkingDetailResponseDTO> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<ParkingDetails> parkingDetailsList = parkingDetailService.search(searchCriteria);
        return parkingDetailsMapper.toParkingDetailResponseDTOList(parkingDetailsList);
    }
}
