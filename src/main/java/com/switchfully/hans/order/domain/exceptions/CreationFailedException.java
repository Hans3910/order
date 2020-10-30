package com.switchfully.hans.order.domain.exceptions;

import com.switchfully.hans.order.domain.instances.ItemGroup;

public class CreationFailedException extends Throwable {
    public CreationFailedException(Class<ItemGroup> itemGroupClass, String amount_not_valid, String s) {
    }
}
