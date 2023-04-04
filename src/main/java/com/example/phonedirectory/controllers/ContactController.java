package com.example.phonedirectory.controllers;

import com.example.phonedirectory.dto.ContactDto;
import com.example.phonedirectory.dto.ContactShortInfoDto;
import com.example.phonedirectory.services.ServiceNames;
import com.example.phonedirectory.services.contact.ContactContext;
import com.example.phonedirectory.services.contact.ContactsContext;
import com.example.phonedirectory.services.contact.FilteredContactsContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contacts")
public class ContactController extends BaseController {

    /**
     * Список всех контактов
     * @return все контакты, неотсортированные
     */
    @GetMapping
    public ResponseEntity<List<ContactShortInfoDto>> getAllContacts(){
        return getAction(new ContactsContext(), getService(ServiceNames.GET_ALL_CONTACTS));
    }
    /**
     * Контакт по id
     * @param id id контакта
     * @return контакт с указанным id
     */
    @GetMapping("{id}")
    public ResponseEntity<ContactDto> getContactById(@PathVariable Integer id){
        return getAction(new ContactContext(id), getService(ServiceNames.GET_CONTACT_BY_ID));
    }
    /**
     * Отсортированные и отфильтрованные контакты
     * @param firstName Имя
     * @param lastName Фамилия
     * @param birthDate дата рождения
     * @param sortedBy поле для сортировки
     * @return список контактов
     */
    @GetMapping
    public ResponseEntity<List<ContactShortInfoDto>> getFilteredContacts(
            @RequestParam Optional<String> firstName,
            @RequestParam Optional<String> lastName,
            @RequestParam Optional<Date> birthDate,
            @RequestParam Optional<String> sortedBy
            ){
        var context = new FilteredContactsContext();
        firstName.ifPresent(context::setFirstName);
        lastName.ifPresent(context::setLastName);
        birthDate.ifPresent(context::setBirthDate);
        sortedBy.ifPresent(context::setSortedBy);
        return getAction(context,getService(ServiceNames.GET_FILTERED_SORTERED));
    }
    /**
     * Создание нового контакта
     * @param contact контакт
     * @return созданный контакт
     */
    @PostMapping
    public ResponseEntity<ContactDto> createContact(@RequestBody ContactDto contact){
        var context = new ContactContext(contact);
        return getAction(context, getService(ServiceNames.CREATE_CONTACT));
    }
    /**
     * Изменение существуюшего
     * @param contact контакт
     * @return измененный контакт
     */
    @PatchMapping
    public ResponseEntity<ContactDto> updateContact(@RequestBody ContactDto contact){
        var context = new ContactContext(contact);
        return getAction(context, getService(ServiceNames.UPDATE_CONTACT));
    }
}
