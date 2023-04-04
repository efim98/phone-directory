package com.example.phonedirectory.services.contact;

import com.example.phonedirectory.dto.ContactShortInfoDto;
import com.example.phonedirectory.dto.convertors.ContactConvertor;
import com.example.phonedirectory.entities.Contact;
import com.example.phonedirectory.repositories.ContactRepository;
import com.example.phonedirectory.services.BaseService;
import com.example.phonedirectory.services.ServiceNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(ServiceNames.GET_FILTERED_SORTERED)
public class GetFilteredSortedContactsService  implements BaseService<FilteredContactsContext> {
    @Autowired
    private ContactRepository repository;

    @Autowired
    private ContactConvertor convertor;

    @Override
    public boolean execute(FilteredContactsContext context) {
        var contactProbe = new Contact();
        if(context.getFirstName() != null) contactProbe.setFirstName(context.getFirstName());
        if(context.getLastName() != null) contactProbe.setLastName(context.getLastName());
        if(context.getBirthDate() != null) contactProbe.setBirthDate(context.getBirthDate());
        var sortedByFields = Arrays.asList("firstName", "secondName", "birthDate");
        List<Contact> contacts;
        if(context.getSortedBy()!=null){
            String sortedBy =context.getSortedBy();
            if(sortedByFields.stream().anyMatch(s -> s.equals(sortedBy))){
                contacts = repository.findAll(Example.of(contactProbe),Sort.by(sortedBy));
            }
            else {
                throw  new IllegalArgumentException(sortedBy);
            }
        }
        else {
            contacts = repository.findAll(Example.of(contactProbe));
        }
        List<ContactShortInfoDto> result = contacts
                .stream()
                .map(convertor::convertToShortInfoDto)
                .toList();
        context.setResult(result);
        return true;
    }
}
