package com.example.phonedirectory.services.contact;

import com.example.phonedirectory.dto.convertors.ContactConvertor;
import com.example.phonedirectory.repositories.ContactRepository;
import com.example.phonedirectory.services.BaseService;
import com.example.phonedirectory.services.ServiceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(ServiceNames.GET_CONTACT_BY_ID)
public class GetContactByIdService implements BaseService<ContactContext> {
    @Autowired
    private ContactRepository repository;
    @Autowired
    private ContactConvertor convertor;
    @Override
    public boolean execute(ContactContext context) {
        boolean isExist = repository.existsById(context.getId());
        if (isExist){
            var contact = repository.findById(context.getId()).get();
            var result = convertor.convertToDto(contact);
            context.setResult(result);
            return true;
        }
        else {
            return false;
        }
    }
}
