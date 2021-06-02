package com.acme.wheelmanagerserversidemovil.service;

import com.acme.wheelmanagerserversidemovil.exception.ResourceNotFoundException;
import com.acme.wheelmanagerserversidemovil.domain.model.Service;
import com.acme.wheelmanagerserversidemovil.domain.repository.CorporationRepository;
import com.acme.wheelmanagerserversidemovil.domain.repository.ServiceRepository;
import com.acme.wheelmanagerserversidemovil.domain.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService{

    @Autowired
    private CorporationRepository corporationRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<Service> getAllServicesByCorporationId(Long corporationId, Pageable pageable) {
        return serviceRepository.findByCorporationId(corporationId, pageable);
    }

    @Override
    public Service getServiceByIdAndCorporationId(Long corporationId, Long serviceId) {
        return serviceRepository.findByIdAndCorporationId(serviceId, corporationId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Service not found with Id " + serviceId +
                                " and CorporationId " + corporationId));
    }

    @Override
    public Service createService(Long corporationId, Service service) {
        return corporationRepository.findById(corporationId).map(corporation -> {
            service.setCorporation(corporation);
            return serviceRepository.save(service);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Corporation", "Id", corporationId));
    }

    @Override
    public Service updateService(Long corporationId, Long serviceId, Service serviceDetails) {
        if(!serviceRepository.existsById(corporationId))
            throw new ResourceNotFoundException("Corporation", "Id", corporationId);

        return serviceRepository.findById(serviceId).map(service -> {
            service.setName(serviceDetails.getName());
            service.setDescription(serviceDetails.getDescription());
            service.setCategory(serviceDetails.getCategory());
            service.setPrice(serviceDetails.getPrice());
            service.setRating(serviceDetails.getRating());
            return serviceRepository.save(service);
        }).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", serviceId));
    }

    @Override
    public ResponseEntity<?> deleteService(Long corporationId, Long serviceId) {
        return serviceRepository.findByIdAndCorporationId(serviceId, corporationId).map(service -> {
            serviceRepository.delete(service);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Service not found with Id " + serviceId + " and CorporationId " + corporationId));
    }
}