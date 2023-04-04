package com.example.phonedirectory.services.contact;

import com.example.phonedirectory.dto.convertors.ContactConvertor;
import com.example.phonedirectory.entities.Contact;
import com.example.phonedirectory.repositories.ContactRepository;
import com.example.phonedirectory.services.BaseService;
import com.example.phonedirectory.services.ServiceNames;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(ServiceNames.CREATE_CONTACT)
public class CreateContactService implements BaseService<ContactContext> {

    @Autowired
    private ContactRepository repository;

    @Autowired
    private ContactConvertor convertor;

    @Override
    @Transactional
    public boolean execute(ContactContext context) {
        Contact contactToSave = convertor.convertToEntity(context.getContactDto());
        var savedContact = repository.save(contactToSave);
        context.setResult(convertor.convertToDto(savedContact));
        return true;
    }
}
