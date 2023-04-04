package com.example.phonedirectory.services.contact;

import com.example.phonedirectory.dto.ContactDto;
import com.example.phonedirectory.services.ActionContext;

import java.util.List;

public class ContactContext implements ActionContext<ContactDto> {

    private ContactDto contactDto;
    public ContactContext(Integer id){
        this.id=id;
    }
    public ContactContext(ContactDto contactDto){
        this.contactDto=contactDto;
    }
    private Integer id;
    private ContactDto result;
    @Override
    public ContactDto getResult() {
        return result;
    }

    @Override
    public void setResult(ContactDto contactDto) {
        this.result=contactDto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ContactDto getContactDto() {
        return contactDto;
    }

    public void setContactDto(ContactDto contactDto) {
        this.contactDto = contactDto;
    }
}
