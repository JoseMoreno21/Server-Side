package com.acme.wheelmanagerserversidemovil.domain.service;

import com.acme.wheelmanagerserversidemovil.domain.model.SubscriptionPlan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface SubscriptionPlanService {
    ResponseEntity<?> deleteSubscriptionPlan(Long subscriptionPlanId);
    SubscriptionPlan updateSubscriptionPlan(Long subscriptionPlanId, SubscriptionPlan subscriptionPlanRequest);
    SubscriptionPlan createSubscriptionPlan(SubscriptionPlan subscriptionPlan);
    SubscriptionPlan getSubscriptionPlanById(Long subscriptionPlanId);
    Page<SubscriptionPlan> getAllSubscriptionPlans(Pageable pageable);
}
