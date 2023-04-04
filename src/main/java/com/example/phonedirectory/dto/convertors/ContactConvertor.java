package com.example.phonedirectory.dto.convertors;

import com.example.phonedirectory.dto.ContactDto;
import com.example.phonedirectory.dto.ContactShortInfoDto;
import com.example.phonedirectory.entities.Contact;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ContactConvertor {
    private final ModelMapper modelMapper;

    public ContactConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ContactDto convertToDto(Contact contactEntity){
        return modelMapper.map(contactEntity, ContactDto.class);
    }
    public ContactShortInfoDto convertToShortInfoDto(Contact contactEntity){
        return modelMapper.map(contactEntity,ContactShortInfoDto.class);
    }
    public Contact convertToEntity(ContactDto contactDto){
        return modelMapper.map(contactDto, Contact.class);
    }
}
