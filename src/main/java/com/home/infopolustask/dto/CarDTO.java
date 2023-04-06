package com.home.infopolustask.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CarDTO {

    private String manufacturer;
    private String model;
    private LocalDate releaseDate;
    private BodyType bodyType;
}
