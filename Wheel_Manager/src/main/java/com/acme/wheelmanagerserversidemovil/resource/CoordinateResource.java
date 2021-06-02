package com.acme.wheelmanagerserversidemovil.resource;

import com.acme.wheelmanagerserversidemovil.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoordinateResource extends AuditModel {
    private Long id;
    private Double latitude;
    private Double longitude;
}