package com.learning.app.shared;

import org.modelmapper.ModelMapper;

public class GenericModelMapper {

    private static ModelMapper modelMapper;

    public static Object map(Object source, Object target) {
        if(modelMapper == null)
            modelMapper = new ModelMapper();

        modelMapper.map(source, target);
        return target;
    }

    public static <T> T map(Object source, Class<T> target) {
        if(modelMapper == null)
            modelMapper = new ModelMapper();

        return modelMapper.map(source, target);
    }

}
