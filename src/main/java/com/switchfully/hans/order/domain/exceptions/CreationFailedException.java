package com.switchfully.hans.order.domain.exceptions;

import com.switchfully.hans.order.domain.instances.ItemGroup;
import org.springframework.util.StringUtils;

public class CreationFailedException extends RuntimeException {
    public CreationFailedException(Class clazz, String... searchParamsMap) {
        super(CreationFailedException.generateMessage(clazz.getSimpleName(), searchParamsMap[0], searchParamsMap[1]));
    }

    private static String generateMessage(String entity, String paramName, String paramValue) {
        return StringUtils.capitalize(entity) +
                " creation failed due to " + paramName + " with value '" + paramValue + "'";
    }
}