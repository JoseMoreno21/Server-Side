package com.acme.wheelmanagerserversidemovil.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SaveTouristPlaceResource {

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(unique = true)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 255)
    @Column(unique = true)
    private String address;
}
