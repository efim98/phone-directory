package com.example.phonedirectory.services;

public interface BaseService<TContext> {
    boolean execute(TContext context);
}

