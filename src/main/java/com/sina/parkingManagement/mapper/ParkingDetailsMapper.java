package com.sina.parkingManagement.mapper;import com.sina.parkingManagement.dto.request.ParkingDetailRequestDTO;import com.sina.parkingManagement.dto.response.ParkingDetailResponseDTO;import com.sina.parkingManagement.model.ParkingDetails;import org.mapstruct.Mapper;import org.mapstruct.Mapping;import org.mapstruct.Mappings;import org.mapstruct.Named;import java.util.Date;import java.util.List;@Mapper(componentModel = "spring", uses = {ParkingMapper.class, VehicleMapper.class, PriceRateMapper.class})public interface ParkingDetailsMapper {    @Mappings({            @Mapping(source = "parkingRequestDTO", target = "parking"),            @Mapping(source = "vehicleRequestDTO", target = "vehicle"),            @Mapping(source = "priceRateRequestDTO", target = "priceRate"),            @Mapping(source = "timeIn", target = "timeIn", qualifiedByName = "parkingDetailTimestampToDate"),            @Mapping(source = "timeOut", target = "timeOut", qualifiedByName = "parkingDetailTimestampToDate")    })    ParkingDetails toParkingDetail(ParkingDetailRequestDTO parkingDetailRequestDTO);    List<ParkingDetails> toParkingDetailList(List<ParkingDetailRequestDTO> parkingDetailRequestDTOList);    //---------------------------------------- response ------------------------------------//    @Mappings({            @Mapping(source = "parking", target = "parkingResponseDTO"),            @Mapping(source = "vehicle", target = "vehicleResponseDTO"),            @Mapping(source = "priceRate", target = "priceRateResponseDTO"),            @Mapping(source = "timeIn", target = "timeIn", qualifiedByName = "parkingDetailDateToTimestamp"),            @Mapping(source = "timeOut", target = "timeOut", qualifiedByName = "parkingDetailDateToTimestamp")    })    ParkingDetailResponseDTO toParkingDetailResponseDTO(ParkingDetails parkingDetails);    List<ParkingDetailResponseDTO> toParkingDetailResponseDTOList(List<ParkingDetails> parkingDetailsList);    @Named("parkingDetailTimestampToDate")    default Date toDate(Long timestamp) {        if (timestamp != null)            return new Date(timestamp);        return null;    }    @Named("parkingDetailDateToTimestamp")    default Long toTimestamp(Date date) {        if (date != null)            return date.getTime();        return null;    }}