package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class Spartan_Negative_GetTest {
    // beforeAll  is an annotation equals to @BeforeClass in TestNG, we use with static method name
    @BeforeAll
    public static void init(){
// save the baseURL inside this variable so that we do not need to type each http method
        RestAssured.baseURI="http://44.200.16.230:8000";
    }

/*TASK
    Given Accept type application/xml
    When user send GET request to /api/spartans/10 end point
    Then status code must be 406
    And response Content Type must be application/xml;charset=UTF-8
    */
    
    
    
    @DisplayName("GET request to /api/spartans/10")
    @Test
    public void test1(){
        Response response = given().accept(ContentType.XML)
                .when()
                       .get("/api/spartans/10");

       // verify statusCode is be 406
        assertEquals(406, response.statusCode());



      // verify content type is application/xml;charset=UTF-8
        assertEquals("application/xml;charset=UTF-8", response.contentType());



    }



}
