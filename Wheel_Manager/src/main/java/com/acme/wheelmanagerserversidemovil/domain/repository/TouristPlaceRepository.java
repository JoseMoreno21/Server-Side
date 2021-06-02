package com.acme.wheelmanagerserversidemovil.domain.repository;

import com.acme.wheelmanagerserversidemovil.domain.model.TouristPlace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TouristPlaceRepository extends JpaRepository<TouristPlace,Long> {
    Page<TouristPlace> findByDistrictId(Long districtId, Pageable pageable);
    Optional<TouristPlace> findByIdAndDistrictId(Long id, Long districtId);
}