package com.acme.wheelmanagerserversidemovil.domain.repository;

import com.acme.wheelmanagerserversidemovil.domain.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}

