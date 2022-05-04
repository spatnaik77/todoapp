package com.sidd.todoapp;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class TodoItemInMemoryRepository {    //implements CrudRepository<TodoItem, String> {

    private Map<String, TodoItem> itemsMap = new HashMap<String, TodoItem>();

    public <S extends TodoItem> S save(S s) {

        itemsMap.put(s.getId(), s);
        return s;
    }

    public <S extends TodoItem> Iterable<S> saveAll(Iterable<S> iterable) {

        for(TodoItem item : iterable) {

            itemsMap.put(item.getId(), item);
        }
        return iterable;
    }


    public Optional<TodoItem> findById(String s) {
        TodoItem item =  itemsMap.get(s);
        if(item != null)
            return Optional.of(item);
        else
            return null;
    }

    public boolean existsById(String s) {
        return itemsMap.containsKey(s);
    }

    public Iterable<TodoItem> findAll() {
        return itemsMap.values();
    }

    public Iterable<TodoItem> findAllById(Iterable<String> iterable) {
        return null;
    }


    public long count() {
        return itemsMap.size();
    }

    public void deleteById(String s) {
        itemsMap.remove(s);
    }

    
    public void delete(TodoItem todoItem) {

        itemsMap.remove(todoItem.getId());
    }

   
    public void deleteAll(Iterable<? extends TodoItem> iterable) {
        for(TodoItem item : iterable) {

            itemsMap.remove(item.getId());
        }

    }


    public void deleteAll() {
        itemsMap.clear();
    }
}
