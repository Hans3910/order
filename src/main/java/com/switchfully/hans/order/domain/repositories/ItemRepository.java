package com.switchfully.hans.order.domain.repositories;

import com.switchfully.hans.order.domain.exceptions.EntityNotFoundException;
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

    public void addNewItem(Item newItemToAdd){
        items.put(newItemToAdd.getId(), newItemToAdd);
    }

    public Item getItemById(String itemId){
        return items.get(itemId);
    }

    public double getPrice(String itemID, int amount) {
        return (items.get(itemID).getPrice() * amount);
    }

    public double getStock(String itemID) {
        return items.get(itemID).getAmountInStock();
    }

    public double getItemAmountInStock(String itemId){
        return items.get(itemId).getAmountInStock();
    }

    public void checkItemId(String itemID) {
        if(!items.containsKey(itemID)) throw new EntityNotFoundException(Item.class, "Item id does not exist", itemID);
    }
}
