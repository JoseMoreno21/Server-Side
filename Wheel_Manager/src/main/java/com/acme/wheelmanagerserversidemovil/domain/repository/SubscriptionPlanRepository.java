package com.acme.wheelmanagerserversidemovil.domain.repository;

import com.acme.wheelmanagerserversidemovil.domain.model.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan,Long> {
}


