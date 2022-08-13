package com.sina.parkingManagement.mapper;

import com.sina.parkingManagement.dto.request.VehicleRequestDTO;
import com.sina.parkingManagement.dto.response.VehicleResponseDTO;
import com.sina.parkingManagement.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-13T18:17:05+0430",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public Vehicle toVehicle(VehicleRequestDTO vehicleRequestDTO) {
        if ( vehicleRequestDTO == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setId( vehicleRequestDTO.getId() );
        vehicle.setPlateNumber( vehicleRequestDTO.getPlateNumber() );
        vehicle.setVehicleType( vehicleRequestDTO.getVehicleType() );

        return vehicle;
    }

    @Override
    public List<Vehicle> toVehicleList(List<VehicleRequestDTO> vehicleRequestDTOList) {
        if ( vehicleRequestDTOList == null ) {
            return null;
        }

        List<Vehicle> list = new ArrayList<Vehicle>( vehicleRequestDTOList.size() );
        for ( VehicleRequestDTO vehicleRequestDTO : vehicleRequestDTOList ) {
            list.add( toVehicle( vehicleRequestDTO ) );
        }

        return list;
    }

    @Override
    public VehicleResponseDTO toParkingResponseDTO(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleResponseDTO vehicleResponseDTO = new VehicleResponseDTO();

        vehicleResponseDTO.setId( vehicle.getId() );
        vehicleResponseDTO.setVersion( vehicle.getVersion() );
        vehicleResponseDTO.setCreatedDate( vehicle.getCreatedDate() );
        vehicleResponseDTO.setLastModifiedDate( vehicle.getLastModifiedDate() );
        vehicleResponseDTO.setPlateNumber( vehicle.getPlateNumber() );
        vehicleResponseDTO.setVehicleType( vehicle.getVehicleType() );

        return vehicleResponseDTO;
    }

    @Override
    public List<VehicleResponseDTO> toVehicleResponseDTOList(List<Vehicle> vehicleList) {
        if ( vehicleList == null ) {
            return null;
        }

        List<VehicleResponseDTO> list = new ArrayList<VehicleResponseDTO>( vehicleList.size() );
        for ( Vehicle vehicle : vehicleList ) {
            list.add( toParkingResponseDTO( vehicle ) );
        }

        return list;
    }
}
