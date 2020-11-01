package com.switchfully.hans.order.domain.instances;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class OrderTest {
    @Test
    void givenOrder_GroupItemsContainsItemIdAndAmount() {
        ItemGroup itemGroup1 = new ItemGroup("12345", 120.0);
        ItemGroup itemGroup2 = new ItemGroup("56987", 125.0);
        List<ItemGroup> itemGroupList = new ArrayList<>();
        itemGroupList.add(itemGroup1);
        itemGroupList.add(itemGroup2);
        Order order = new Order("12", itemGroupList, 10.0);

        String expected = "12345";
        String result = order.getItemGroups().get(0).getItemId();
        double expectedDobule = 120.0;
        double resultDouble = order.getItemGroups().get(0).getAmount();

        Assertions.assertEquals(expected, result);
        Assertions.assertEquals(expectedDobule, resultDouble);
    }
}