package com.example.phonedirectory.controllers;

import com.example.phonedirectory.services.ActionContext;
import com.example.phonedirectory.services.BaseService;
import com.example.phonedirectory.services.ServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public abstract class BaseController {

    @Autowired
    private ServiceFactory serviceFactory;

    protected <TResult, TContext extends ActionContext<TResult>>ResponseEntity getAction(TContext context,BaseService service){
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        try {
            if(!service.execute(context)){
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else {
                httpStatus = HttpStatus.OK;
                return ResponseEntity.ok(context.getResult());
            }
        } catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
    protected BaseService getService(String serviceName){
        return serviceFactory.getService(serviceName);
    }
}
