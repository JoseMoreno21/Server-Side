package com.acme.wheelmanagerserversidemovil.resource;

import com.acme.wheelmanagerserversidemovil.domain.model.AuditModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoResource extends AuditModel{
    private Long id;
    private String name;
    private String description;
    private String image_url;
}
