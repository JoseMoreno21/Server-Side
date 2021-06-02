package com.acme.wheelmanagerserversidemovil.service;

import com.acme.wheelmanagerserversidemovil.exception.ResourceNotFoundException;
import com.acme.wheelmanagerserversidemovil.domain.model.Advertising;
import com.acme.wheelmanagerserversidemovil.domain.repository.AdvertisingRepository;
import com.acme.wheelmanagerserversidemovil.domain.service.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    private AdvertisingRepository advertisingRepository;

    @Override
    public Page<Advertising> getAllAdvertisingsByUserId(Long userId, Pageable pageable) {
        return advertisingRepository.findByUserId(userId,pageable);
    }

    @Override
    public Advertising getAdvertisingByIdAndUserId(Long advertisingId, Long userId) {
        return advertisingRepository.findByIdAndUserId(advertisingId, userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Advertising not found with Id " + advertisingId +
                                " and UserId " + userId));
    }


    @Override
    public ResponseEntity<?> deleteAdvertising(Long advertisingId) {
        Advertising advertising = advertisingRepository.findById(advertisingId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Id", advertisingId));
        advertisingRepository.delete(advertising);
        return ResponseEntity.ok().build();
    }

    @Override
    public Advertising updateAdvertising(Long advertisingId, Advertising advertisingRequest) {
        Advertising advertising = advertisingRepository.findById(advertisingId)
                .orElseThrow(() -> new ResourceNotFoundException("Advertising", "Id", advertisingId));
        advertising.setImage_url(advertisingRequest.getImage_url());
        return advertisingRepository.save(advertising);
    }

    @Override
    public Advertising createAdvertising(Advertising advertising) {
        return advertisingRepository.save(advertising);
    }

    @Override
    public Advertising getAdvertisingById(Long advertisingId) {
        return advertisingRepository.findById(advertisingId)
                .orElseThrow(() -> new ResourceNotFoundException("Advertising", "Id", advertisingId));
    }

    @Override
    public List<Advertising> getAllAdvertisings() {
        return advertisingRepository.findAll();
    }
}