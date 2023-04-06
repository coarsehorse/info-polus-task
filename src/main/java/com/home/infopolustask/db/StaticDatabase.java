package com.home.infopolustask.db;

import com.home.infopolustask.dto.BodyType;
import com.home.infopolustask.dto.CarDTO;
import com.home.infopolustask.dto.ContactDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Static contacts data repository.
 */
public class StaticDatabase {

    private final static List<ContactDTO> CONTACTS = List.of(
            ContactDTO.builder()
                    .id(1)
                    .name("Petro Kartohin")
                    .age(18)
                    .dateOfBirth(LocalDate.of(2005, 5, 18))
                    .cars(List.of(
                            CarDTO.builder()
                                    .manufacturer("VAZ")
                                    .model("2106")
                                    .releaseDate(LocalDate.of(1976, 10, 15))
                                    .bodyType(BodyType.SEDAN)
                                    .build()
                    ))
                    .build(),
            ContactDTO.builder()
                    .id(2)
                    .name("Dmytro Inomarkin")
                    .age(25)
                    .dateOfBirth(LocalDate.of(1997, 7, 7))
                    .cars(List.of(
                            CarDTO.builder()
                                    .manufacturer("Toyota")
                                    .model("Camry")
                                    .releaseDate(LocalDate.of(2015, 1, 18))
                                    .bodyType(BodyType.SEDAN)
                                    .build()
                    ))
                    .build(),
            ContactDTO.builder()
                    .id(3)
                    .name("Ivan Deputatenko")
                    .age(40)
                    .dateOfBirth(LocalDate.of(1983, 1, 28))
                    .cars(List.of(
                            CarDTO.builder()
                                    .manufacturer("Toyota")
                                    .model("Cruzak")
                                    .releaseDate(LocalDate.of(2023, 1, 1))
                                    .bodyType(BodyType.SUV)
                                    .build(),
                            CarDTO.builder()
                                    .manufacturer("Mercedes-Benz")
                                    .model("W223")
                                    .releaseDate(LocalDate.of(2021, 1, 21))
                                    .bodyType(BodyType.SEDAN)
                                    .build()
                    ))
                    .build()
    );

    public static Optional<ContactDTO> getContact(Integer contactId) {
        return CONTACTS.stream()
                .filter(c -> c.getId().equals(contactId))
                .findFirst();
    }

    public static List<ContactDTO> getAll() {
        return CONTACTS;
    }
}
