package com.sina.parkingManagement.repository;import com.sina.parkingManagement.model.Vehicle;import org.springframework.data.repository.PagingAndSortingRepository;public interface VehicleInterface extends PagingAndSortingRepository<Vehicle, Long> {}