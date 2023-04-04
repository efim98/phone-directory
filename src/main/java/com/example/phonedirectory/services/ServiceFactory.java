package com.example.phonedirectory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public BaseService getService(String name){
        return applicationContext.getBean(name, BaseService.class);
    }
}
