package com.sina.parkingManagement.model;import com.sina.parkingManagement.common.baseModel.BaseEntity;import lombok.Data;import lombok.EqualsAndHashCode;import lombok.ToString;import javax.persistence.*;import java.util.List;@Entity@Data@Table(name = Parking.PARKING_TBL)public class Parking extends BaseEntity {    public static final String PARKING_TBL = "parking_tbl";    private Long basePrice;    @ToString.Exclude    @EqualsAndHashCode.Exclude    @OneToMany(mappedBy = "parking", fetch = FetchType.LAZY, cascade = CascadeType.ALL)    private List<ParkingDetails> parkingDetails;}