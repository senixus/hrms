package com.hrms.hrms.core.utilities.dtoConverter;

import java.util.List;

public interface DtoConverterService {
    <S, T> List<T> dtoConverter(List<S> source, Class<T> targetClass);

    <T> Object dtoClassConverter(Object source,Class<T> baseClass);
}
