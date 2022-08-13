package com.sina.parkingManagement.mapper;

import com.sina.parkingManagement.dto.request.ParkingDetailRequestDTO;
import com.sina.parkingManagement.dto.response.ParkingDetailResponseDTO;
import com.sina.parkingManagement.model.ParkingDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-13T18:17:05+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class ParkingDetailsMapperImpl implements ParkingDetailsMapper {

    @Autowired
    private ParkingMapper parkingMapper;
    @Autowired
    private VehicleMapper vehicleMapper;
    @Autowired
    private PriceRateMapper priceRateMapper;

    @Override
    public ParkingDetails toParkingDetail(ParkingDetailRequestDTO parkingDetailRequestDTO) {
        if ( parkingDetailRequestDTO == null ) {
            return null;
        }

        ParkingDetails parkingDetails = new ParkingDetails();

        parkingDetails.setParking( parkingMapper.toParking( parkingDetailRequestDTO.getParkingRequestDTO() ) );
        parkingDetails.setVehicle( vehicleMapper.toVehicle( parkingDetailRequestDTO.getVehicleRequestDTO() ) );
        parkingDetails.setPriceRate( priceRateMapper.toPriceRate( parkingDetailRequestDTO.getPriceRateRequestDTO() ) );
        parkingDetails.setTimeIn( toDate( parkingDetailRequestDTO.getTimeIn() ) );
        parkingDetails.setTimeOut( toDate( parkingDetailRequestDTO.getTimeOut() ) );
        parkingDetails.setId( parkingDetailRequestDTO.getId() );

        return parkingDetails;
    }

    @Override
    public List<ParkingDetails> toParkingDetailList(List<ParkingDetailRequestDTO> parkingDetailRequestDTOList) {
        if ( parkingDetailRequestDTOList == null ) {
            return null;
        }

        List<ParkingDetails> list = new ArrayList<ParkingDetails>( parkingDetailRequestDTOList.size() );
        for ( ParkingDetailRequestDTO parkingDetailRequestDTO : parkingDetailRequestDTOList ) {
            list.add( toParkingDetail( parkingDetailRequestDTO ) );
        }

        return list;
    }

    @Override
    public ParkingDetailResponseDTO toParkingDetailResponseDTO(ParkingDetails parkingDetails) {
        if ( parkingDetails == null ) {
            return null;
        }

        ParkingDetailResponseDTO parkingDetailResponseDTO = new ParkingDetailResponseDTO();

        parkingDetailResponseDTO.setParkingResponseDTO( parkingMapper.toParkingResponseDTO( parkingDetails.getParking() ) );
        parkingDetailResponseDTO.setVehicleResponseDTO( vehicleMapper.toParkingResponseDTO( parkingDetails.getVehicle() ) );
        parkingDetailResponseDTO.setPriceRateResponseDTO( priceRateMapper.toPriceRateResponseDTO( parkingDetails.getPriceRate() ) );
        parkingDetailResponseDTO.setTimeIn( toTimestamp( parkingDetails.getTimeIn() ) );
        parkingDetailResponseDTO.setTimeOut( toTimestamp( parkingDetails.getTimeOut() ) );
        parkingDetailResponseDTO.setId( parkingDetails.getId() );
        parkingDetailResponseDTO.setVersion( parkingDetails.getVersion() );
        parkingDetailResponseDTO.setCreatedDate( parkingDetails.getCreatedDate() );
        parkingDetailResponseDTO.setLastModifiedDate( parkingDetails.getLastModifiedDate() );

        return parkingDetailResponseDTO;
    }

    @Override
    public List<ParkingDetailResponseDTO> toParkingDetailResponseDTOList(List<ParkingDetails> parkingDetailsList) {
        if ( parkingDetailsList == null ) {
            return null;
        }

        List<ParkingDetailResponseDTO> list = new ArrayList<ParkingDetailResponseDTO>( parkingDetailsList.size() );
        for ( ParkingDetails parkingDetails : parkingDetailsList ) {
            list.add( toParkingDetailResponseDTO( parkingDetails ) );
        }

        return list;
    }
}
