package com.example.phonedirectory.services.contact;

import com.example.phonedirectory.dto.ContactShortInfoDto;
import com.example.phonedirectory.services.ActionContext;

import java.util.Date;
import java.util.List;

public class FilteredContactsContext  implements ActionContext<List<ContactShortInfoDto>> {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String sortedBy;


    @Override
    public List<ContactShortInfoDto> getResult() {
        return null;
    }

    @Override
    public void setResult(List<ContactShortInfoDto> contactShortInfoDtos) {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSortedBy() {
        return sortedBy;
    }

    public void setSortedBy(String sortedBy) {
        this.sortedBy = sortedBy;
    }
}
