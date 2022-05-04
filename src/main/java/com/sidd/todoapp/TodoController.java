package com.sidd.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    private TodoItemInMemoryRepository todoItemRepository;


    public TodoController()
    {

    }
    @GetMapping(value = "/")
    public String hello()
    {

        /*TodoItem item1 = new TodoItem("1", "item1-desc", "sidd");
        todoItemRepository.save(item1);*/
        return "Todo V1 service is up and running \n";
    }

    @GetMapping("/api/items/{id}")
    public ResponseEntity<?> getTodoItem(@PathVariable("id") String id) 
    {
        try 
        {
            return new ResponseEntity<TodoItem>(todoItemRepository.findById(id).get(), HttpStatus.OK);
        } 
        catch (Exception e) 
        {
            return new ResponseEntity<String>(id + " not found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * HTTP GET ALL
     */
    @GetMapping(value = "/api/items")
    public ResponseEntity<?> getAllTodoItems() {
        try 
        {
            return new ResponseEntity<>(todoItemRepository.findAll(), HttpStatus.OK);
        } 
        catch (Exception e) 
        {
            return new ResponseEntity<>("Nothing found", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * HTTP POST NEW ONE
     */
    @PostMapping(value = "/api/items", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TodoItem> addNewTodoItem(@RequestBody TodoItem item)
    {
        try
        {
            todoItemRepository.save(item);
            return new ResponseEntity<TodoItem>(item, HttpStatus.CREATED);
        } catch (Exception e)
        {
            throw e;
        }
    }

    /**
     * HTTP DELETE
     */
    @DeleteMapping(value = "/api/items/{id}")
    public ResponseEntity<String> deleteTodoItem(@PathVariable("id") String id) {
        try {
            todoItemRepository.deleteById(id);
            return new ResponseEntity<String>("Entity deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Entity deletion failed", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Exception
     */
    @GetMapping(value = "/api/exception")
    public ResponseEntity<String> exception() 
    {
        throw new RuntimeException("some exception");
        
    }



}
