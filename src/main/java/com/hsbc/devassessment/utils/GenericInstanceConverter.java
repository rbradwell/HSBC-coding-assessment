package com.hsbc.devassessment.utils;

import com.hsbc.devassessment.exception.TechnicalException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GenericInstanceConverter<X,Y> {

    public List<X> convertList(List<Y> fromConvertList, String fromClassName,String toClazzName){
        List<X> result = new ArrayList<>();
        for (Y fromConvert : fromConvertList) {
            result.add(convert(fromConvert, fromClassName, toClazzName));
        }
        return result;
    }

    public X convert(Y from, String fromClassName,String toClazzName) {
        try {
            Class<?> toClass = Class.forName(toClazzName);
            Class<?> fromClass = Class.forName(fromClassName);
            Constructor<?> cons = toClass.getConstructor(fromClass);
            return (X) cons.newInstance(from);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new TechnicalException(e.getMessage());
        }

    }
}
