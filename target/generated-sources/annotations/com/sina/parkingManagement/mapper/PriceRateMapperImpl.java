package com.sina.parkingManagement.mapper;

import com.sina.parkingManagement.dto.request.PriceRateRequestDTO;
import com.sina.parkingManagement.dto.response.PriceRateResponseDTO;
import com.sina.parkingManagement.model.PriceRate;
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
public class PriceRateMapperImpl implements PriceRateMapper {

    @Override
    public PriceRate toPriceRate(PriceRateRequestDTO priceRateRequestDTO) {
        if ( priceRateRequestDTO == null ) {
            return null;
        }

        PriceRate priceRate = new PriceRate();

        priceRate.setId( priceRateRequestDTO.getId() );
        priceRate.setHourlyRate( priceRateRequestDTO.getHourlyRate() );
        priceRate.setDailyRate( priceRateRequestDTO.getDailyRate() );
        priceRate.setMonthlyRate( priceRateRequestDTO.getMonthlyRate() );

        return priceRate;
    }

    @Override
    public List<PriceRate> toPriceRateList(List<PriceRateRequestDTO> priceRateRequestDTOList) {
        if ( priceRateRequestDTOList == null ) {
            return null;
        }

        List<PriceRate> list = new ArrayList<PriceRate>( priceRateRequestDTOList.size() );
        for ( PriceRateRequestDTO priceRateRequestDTO : priceRateRequestDTOList ) {
            list.add( toPriceRate( priceRateRequestDTO ) );
        }

        return list;
    }

    @Override
    public PriceRateResponseDTO toPriceRateResponseDTO(PriceRate priceRate) {
        if ( priceRate == null ) {
            return null;
        }

        PriceRateResponseDTO priceRateResponseDTO = new PriceRateResponseDTO();

        priceRateResponseDTO.setId( priceRate.getId() );
        priceRateResponseDTO.setVersion( priceRate.getVersion() );
        priceRateResponseDTO.setCreatedDate( priceRate.getCreatedDate() );
        priceRateResponseDTO.setLastModifiedDate( priceRate.getLastModifiedDate() );
        priceRateResponseDTO.setHourlyRate( priceRate.getHourlyRate() );
        priceRateResponseDTO.setDailyRate( priceRate.getDailyRate() );
        priceRateResponseDTO.setMonthlyRate( priceRate.getMonthlyRate() );

        return priceRateResponseDTO;
    }

    @Override
    public List<PriceRateResponseDTO> toPriceRateResponseDTOList(List<PriceRate> priceRateList) {
        if ( priceRateList == null ) {
            return null;
        }

        List<PriceRateResponseDTO> list = new ArrayList<PriceRateResponseDTO>( priceRateList.size() );
        for ( PriceRate priceRate : priceRateList ) {
            list.add( toPriceRateResponseDTO( priceRate ) );
        }

        return list;
    }
}
