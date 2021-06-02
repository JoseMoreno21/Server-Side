package com.acme.wheelmanagerserversidemovil.resource;

import com.acme.wheelmanagerserversidemovil.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictResource extends AuditModel {
    private Long id;
    private String name;
}
