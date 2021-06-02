package com.acme.wheelmanagerserversidemovil.service;

import com.acme.wheelmanagerserversidemovil.exception.ResourceNotFoundException;
import com.acme.wheelmanagerserversidemovil.domain.model.Publicitie;
import com.acme.wheelmanagerserversidemovil.domain.repository.CorporationRepository;
import com.acme.wheelmanagerserversidemovil.domain.repository.PublicitieRepository;
import com.acme.wheelmanagerserversidemovil.domain.service.PublicitieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PublicitieServiceImpl implements PublicitieService {

    @Autowired
    private CorporationRepository corporationRepository;

    @Autowired
    private PublicitieRepository publicitieRepository;

    @Override
    public Page<Publicitie> getAllPublicitiesByCorporationId(Long corporationId, Pageable pageable) {
        return publicitieRepository.findByCorporationId(corporationId, pageable);
    }

    @Override
    public Publicitie getPublicitiesByIdAndCorporationId(Long corporationId, Long publicitieId) {
        return publicitieRepository.findByIdAndCorporationId(publicitieId, corporationId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Publicitie not found with Id " + publicitieId +
                                " and CorporationId " + corporationId));
    }

    @Override
    public Publicitie createPublicitie(Long corporationId, Publicitie publicitie) {
        return corporationRepository.findById(corporationId).map(corporation -> {
            publicitie.setCorporation(corporation);
            return publicitieRepository.save(publicitie);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Corporation", "Id", corporationId));
    }

    @Override
    public Publicitie updatePublicitie(Long corporationId, Long publicitieId, Publicitie publicitieDetails) {
        if(!publicitieRepository.existsById(corporationId))
            throw new ResourceNotFoundException("Corporation", "Id", corporationId);

        return publicitieRepository.findById(publicitieId).map(publicitie -> {
            publicitie.setTitle(publicitieDetails.getTitle());
            publicitie.setDescription(publicitieDetails.getDescription());
            publicitie.setImage_URL(publicitieDetails.getImage_URL());
            return publicitieRepository.save(publicitie);
        }).orElseThrow(() -> new ResourceNotFoundException("Publicitie", "Id", publicitieId));
    }

    @Override
    public ResponseEntity<?> deletePublicitie(Long corporationId, Long publicitieId) {
        return publicitieRepository.findByIdAndCorporationId(publicitieId, corporationId).map(publicitie -> {
            publicitieRepository.delete(publicitie);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Publicitie not found with Id " + publicitieId + " and CorporationId " + corporationId));
    }
}
