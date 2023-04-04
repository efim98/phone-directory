package com.example.phonedirectory.dto.convertors;

import com.example.phonedirectory.dto.PhoneDto;
import com.example.phonedirectory.entities.Phone;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PhoneConvertor {
    private final ModelMapper modelMapper;

    public PhoneConvertor(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public PhoneDto convertToDto(Phone phoneEntity){
        return modelMapper.map(phoneEntity, PhoneDto.class);
    }
    public Phone convertToEntity(PhoneDto phoneDto){
        return modelMapper.map(phoneDto, Phone.class);
    }

}
