package com.shinn.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.beans.beancontext.BeanContextServicesSupport;
import java.lang.reflect.InvocationTargetException;


public class FormUtil {
    public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
        T object = null;
        try {
            object = clazz.newInstance();
            BeanUtils.populate(object, request.getParameterMap());
            return object;
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        } catch (InvocationTargetException e1) {
            System.out.println(e1.getMessage());
        }
        return null;
    }
}
