package com.sina.parkingManagement.dto.response;import com.sina.parkingManagement.common.baseModel.BaseResponseDTO;import io.swagger.annotations.ApiModelProperty;import lombok.Data;@Datapublic class ParkingResponseDTO extends BaseResponseDTO {    @ApiModelProperty(required = true)    private Long basePrice;}