package com.home.infopolustask.service;

import com.home.infopolustask.db.StaticDatabase;
import com.home.infopolustask.dto.ContactDTO;
import com.home.infopolustask.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactServiceTest {

    private static final ContactDTO contact1 = ContactDTO.builder()
            .id(1)
            .name("John")
            .build();

    @Spy
    private ContactService contactService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetContactHappyPath() {
        // Prepare data
        Integer contactId = contact1.getId();

        // Setup static mock and check
        try (MockedStatic<StaticDatabase> utilities = Mockito.mockStatic(StaticDatabase.class)) {
            utilities.when(() -> StaticDatabase.getContact(contactId))
                    .thenReturn(Optional.of(contact1));

            ContactDTO actualContact = contactService.getContact(contactId);
            Assertions.assertEquals(contact1, actualContact);
        }
    }

    @Test
    void testGetContactThrowsNotFound() {
        // Prepare data
        Integer nonExistingId = 999;

        // Trigger exception
        var exception = assertThrows(
                NotFoundException.class, () -> contactService.getContact(nonExistingId));

        // Check
        assertTrue(exception.getMessage().contains("id=%d not found".formatted(nonExistingId)));
    }

    @Test
    void testGetAllContactsHappyPath() {
        // Prepare data
        var maryContact = ContactDTO.builder()
                .id(2)
                .name("Mary")
                .build();
        var expectedContacts = List.of(contact1, maryContact);

        // Setup static mock and check
        try (MockedStatic<StaticDatabase> utilities = Mockito.mockStatic(StaticDatabase.class)) {
            utilities.when(StaticDatabase::getAll)
                    .thenReturn(expectedContacts);

            List<ContactDTO> actualContacts = contactService.getAllContacts();
            Assertions.assertEquals(actualContacts, expectedContacts);
        }
    }
}
