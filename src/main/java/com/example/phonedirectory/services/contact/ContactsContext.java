package com.example.phonedirectory.services.contact;

import com.example.phonedirectory.dto.ContactDto;
import com.example.phonedirectory.dto.ContactShortInfoDto;
import com.example.phonedirectory.services.ActionContext;

import java.util.List;

public class ContactsContext implements ActionContext<List<ContactShortInfoDto>> {
    private List<ContactShortInfoDto> result;
    @Override
    public List<ContactShortInfoDto> getResult() {
        return result;
    }

    @Override
    public void setResult(List<ContactShortInfoDto> contactDtos) {
        this.result=contactDtos;
    }
}
