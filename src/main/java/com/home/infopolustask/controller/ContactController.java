package com.home.infopolustask.controller;

import com.home.infopolustask.dto.ContactDTO;
import com.home.infopolustask.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping("get/{contactId}")
    public ContactDTO getById(@PathVariable Integer contactId) {
        return contactService.getContact(contactId);
    }

    @GetMapping("get")
    public List<ContactDTO> get() {
        return contactService.getAll();
    }
}
