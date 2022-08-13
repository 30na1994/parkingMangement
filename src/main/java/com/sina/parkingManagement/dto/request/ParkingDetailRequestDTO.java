package com.sina.parkingManagement.dto.request;import com.sina.parkingManagement.common.baseModel.BaseRequestDTO;import io.swagger.annotations.ApiModelProperty;import lombok.Data;@Datapublic class ParkingDetailRequestDTO extends BaseRequestDTO {    @ApiModelProperty(required = true)    private Long timeIn;    @ApiModelProperty(required = true)    private Long timeOut;    @ApiModelProperty(required = true)    private ParkingRequestDTO parkingRequestDTO;    @ApiModelProperty(required = true)    private VehicleRequestDTO vehicleRequestDTO;    @ApiModelProperty(required = true)    private PriceRateRequestDTO priceRateRequestDTO;}