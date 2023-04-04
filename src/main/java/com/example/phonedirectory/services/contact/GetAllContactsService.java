package com.example.phonedirectory.services.contact;

import com.example.phonedirectory.dto.convertors.ContactConvertor;
import com.example.phonedirectory.repositories.ContactRepository;
import com.example.phonedirectory.services.BaseService;
import com.example.phonedirectory.services.ServiceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(ServiceNames.GET_ALL_CONTACTS)
public class GetAllContactsService implements BaseService<ContactsContext> {

    @Autowired
    private ContactRepository repository;

    @Autowired
    private ContactConvertor convertor;

    @Override
    public boolean execute(ContactsContext context) {
        var result = repository.findAll()
                .stream()
                .map(convertor::convertToShortInfoDto)
                .toList();
        context.setResult(result);
        return true;
    }
}
