package com.home.infopolustask.service;

import com.home.infopolustask.db.StaticDatabase;
import com.home.infopolustask.dto.ContactDTO;
import com.home.infopolustask.exception.NotFoundException;
import com.home.infopolustask.util.Utils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    public ContactDTO getContact(Integer contactId) {
        Utils.checkNotNull(contactId, "contactId");

        return StaticDatabase.getContact(contactId)
                .orElseThrow(() ->
                        new NotFoundException("Contact with id=%d not found".formatted(contactId)));
    }

    public List<ContactDTO> getAllContacts() {
        return StaticDatabase.getAll();
    }
}
