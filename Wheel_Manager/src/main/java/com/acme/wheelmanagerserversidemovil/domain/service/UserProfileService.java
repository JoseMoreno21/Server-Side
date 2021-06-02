package com.acme.wheelmanagerserversidemovil.domain.service;

import com.acme.wheelmanagerserversidemovil.domain.model.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserProfileService {
    ResponseEntity<?> deleteUserProfile(Long userProfileId);
    UserProfile updateUserProfile(Long userProfileId, UserProfile userProfileRequest);
    UserProfile createUserProfile(UserProfile userProfile);
    UserProfile getUserProfileById(Long userProfileId);
    Page<UserProfile> getAllUsersProfile(Pageable pageable);
}