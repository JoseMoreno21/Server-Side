package com.acme.wheelmanagerserversidemovil.domain.service;

import com.acme.wheelmanagerserversidemovil.domain.model.Coordinate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CoordinateService {
    Page<Coordinate> getAllCoordinatesByDistrictId(Long districtId, Pageable pageable);
    Coordinate getCoordinateByIdAndDistrictId(Long coordinateId, Long districtId);
    ResponseEntity<?> deleteCoordinate(Long coordinateId);
    Coordinate updateCoordinate(Long coordinateId, Coordinate coordinateRequest);
    Coordinate createCoordinate(Coordinate coordinateRequest);
    Coordinate getCoordinateById(Long coordinateId);
    Page<Coordinate> getAllCoordinates(Pageable pageable);
}
