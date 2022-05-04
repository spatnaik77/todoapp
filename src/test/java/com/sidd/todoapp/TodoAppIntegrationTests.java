
package com.sidd.todoapp;

import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TodoAppIntegrationTests {

    static String baseURI;
    static int port;

    @BeforeAll
    public static void setup() 
    {
        System.out.println("TodoAppIntegrationTests - setup()");
        baseURI = "http://localhost:8080";
        port = 8080;
    }
    /*@Test
    public void givenUrl_whenSuccessOnGetsResponse_thenCorrect() 
    {
        et("/api/todo/tasks").then().statusCode(200)
                .assertThat().body("size()", greaterThan(0));
    }*/
}