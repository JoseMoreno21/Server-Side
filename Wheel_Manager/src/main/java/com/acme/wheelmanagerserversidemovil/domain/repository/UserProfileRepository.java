package com.acme.wheelmanagerserversidemovil.domain.repository;

import com.acme.wheelmanagerserversidemovil.domain.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

}
