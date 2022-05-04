package com.sidd.todoapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoappApplicationTests {

	@Test
	void contextLoads() 
	{
		System.out.println("Testing..");
	}
	@Test
	void createAndGet() 
	{
		System.out.println("Create & Get");
		TodoItem item1 = new TodoItem("1", "vscode demo", "Siddharth");
		TodoItemInMemoryRepository repository = new TodoItemInMemoryRepository();
		repository.save(item1);
		TodoItem item = repository.findById("1").get();
		Assertions.assertEquals("1", item.getId());
		Assertions.assertEquals("Siddharth", item.getOwner());
	}

}
