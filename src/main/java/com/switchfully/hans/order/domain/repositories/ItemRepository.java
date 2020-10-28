package com.switchfully.hans.order.domain.repositories;

import com.switchfully.hans.order.domain.instances.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {
    private final Map<String, Item> items = new HashMap<>();

    public ItemRepository() {
        fillRepository();
    }

    private void fillRepository() {
        Item item1 = new Item("Boek", "een mooi boek", 25.0, 100.0);
        items.put(item1.getId(), item1);
        Item item2 = new Item("TV", "een mooie TV", 425.0, 10.0);
        items.put(item2.getId(), item2);
        Item item3 = new Item("GSM", "een mooie GSM", 225.0, 30.0);
        items.put(item3.getId(), item3);
    }

    public Collection<Item> getAll() {
        return new ArrayList<>(items.values());
    }

    public void addBook(Item newItem) {
        items.put(newItem.getId(), newItem);
    }
}
