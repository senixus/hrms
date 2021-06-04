package com.hrms.hrms.core.utilities.dtoConverter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public  class DtoConverterManager implements DtoConverterService{

    private ModelMapper modelMapper;

    @Autowired
    public DtoConverterManager(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
   public <S, T> List<T> dtoConverter(List<S> source, Class<T> targetClass){
        return source
                .stream()
                .map(element -> this.modelMapper.map(element, targetClass))
                .collect(Collectors.toList());

    }

    @Override
    public <T> Object dtoClassConverter(Object source,Class<T> baseClass){
        return this.modelMapper.map(source,baseClass);
    }


}
