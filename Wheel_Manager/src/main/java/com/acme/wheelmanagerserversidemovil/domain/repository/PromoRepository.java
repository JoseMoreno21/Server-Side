package com.acme.wheelmanagerserversidemovil.domain.repository;

import com.acme.wheelmanagerserversidemovil.domain.model.Promo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PromoRepository  extends JpaRepository<Promo,Long> {
    Page<Promo> findByCorporationId(Long corporationId, Pageable pageable);
    Optional<Promo> findByIdAndCorporationId(Long id, Long corporationId);
}
