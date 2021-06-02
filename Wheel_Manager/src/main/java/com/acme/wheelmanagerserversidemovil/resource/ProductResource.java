package com.acme.wheelmanagerserversidemovil.resource;

import com.acme.wheelmanagerserversidemovil.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResource extends AuditModel {
    private Long id;
    private int rating;
    private int units_int_stock;
    private String name;
    private String description;
    private String category;
    private Double price;
}
