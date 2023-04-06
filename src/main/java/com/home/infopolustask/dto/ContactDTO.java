package com.home.infopolustask.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class ContactDTO {

    private Integer id;
    private String name;
    private Integer age;
    private LocalDate dateOfBirth;
    private List<CarDTO> cars;
}
