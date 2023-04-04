package com.example.phonedirectory.services.contact;

import com.example.phonedirectory.dto.convertors.ContactConvertor;
import com.example.phonedirectory.entities.Contact;
import com.example.phonedirectory.repositories.ContactRepository;
import com.example.phonedirectory.services.BaseService;
import com.example.phonedirectory.services.ServiceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(ServiceNames.UPDATE_CONTACT)
public class UpdateContactService implements BaseService<ContactContext> {
    @Autowired
    private ContactRepository repository;

    @Autowired
    private ContactConvertor convertor;


    @Override
    public boolean execute(ContactContext context) {
        Contact contactToUpdate = convertor.convertToEntity(context.getContactDto());
        if(contactToUpdate.getId() != null){
            if(repository.existsById(contactToUpdate.getId())){
                var result = repository.save(contactToUpdate);
                context.setResult(convertor.convertToDto(result));
                return true;
            }
            else {
                throw  new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
