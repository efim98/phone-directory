package com.example.phonedirectory.services;

public interface ActionContext <TResult> {
    TResult getResult();
    void setResult(TResult result);
}
