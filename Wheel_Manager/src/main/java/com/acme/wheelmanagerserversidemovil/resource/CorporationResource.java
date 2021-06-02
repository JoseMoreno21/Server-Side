package com.acme.wheelmanagerserversidemovil.resource;

import com.acme.wheelmanagerserversidemovil.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorporationResource extends AuditModel{
    private Long id;
    private int ruc;
    private String name;
    private String address;
    private String phone;
}
