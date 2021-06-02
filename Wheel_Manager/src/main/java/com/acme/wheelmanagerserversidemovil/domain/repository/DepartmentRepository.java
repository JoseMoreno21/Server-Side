package com.acme.wheelmanagerserversidemovil.domain.repository;

import com.acme.wheelmanagerserversidemovil.domain.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Page<Department> findByCountryId(Long countryId, Pageable pageable);
    Optional<Department> findByIdAndCountryId(Long id, Long countryId);
}
