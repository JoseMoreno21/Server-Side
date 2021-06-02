package com.acme.wheelmanagerserversidemovil.domain.repository;

import com.acme.wheelmanagerserversidemovil.domain.model.Alert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlertRepository extends JpaRepository<Alert,Long> {
    Page<Alert> findByCoordinateId(Long coordinateId, Pageable pageable);
    Optional<Alert> findByIdAndCoordinateId(Long id, Long coordinateId);
}