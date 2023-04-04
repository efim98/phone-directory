package com.example.phonedirectory.repositories;

import com.example.phonedirectory.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
