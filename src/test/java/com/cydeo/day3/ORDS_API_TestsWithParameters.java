package com.cydeo.day3;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;



public class ORDS_API_TestsWithParameters {
    // beforeAll  is an annotation equals to @BeforeClass in TestNG, we use with static method name
    @BeforeAll
    public static void init(){
// save the baseURL inside this variable so that we do not need to type each http method
        baseURI="http://44.200.16.230:1000/ords/hr";
    }


  /*
        Given accept type is Json
        And parameters: q = {"region_id":2}
        When users sends a GET request to "/countries"
        Then status code is 200
        And Content type is application/json
        And Payload should contain "United States of America"
     */


@DisplayName("GET request to /countries with Query Param")
 @Test
 public void test1(){

 Response response = given().accept(ContentType.JSON)
                      .and().queryParam("q", "{\"region_id\":2}")
                              .log().all()
                                   .when()
                                    .get("/countries");


//    Then status code is 200
    assertEquals(200, response.statusCode());


//    And Content type is application/json
 //   assertEquals("application/json", response.contentType());
    assertEquals( "application/json"   ,response.header("Content-Type"));

//    And Payload/body should contain "United States of America"
    assertTrue(response.body().asString().contains("United States of America"));

    // print all the payload/body
    response.prettyPrint();



}


/*
 Send a GET request to employees and get only
 employees who works as a IT_PROG
 */
    @DisplayName("GET request to /employees with Query Param")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("q", "{\"job_id\": \"IT_PROG\"}")
                .log().all()
                .when()
                .get("/employees");

//    Then status code is 200
        assertEquals(200, response.statusCode());


//    And Content type is application/json
        //   assertEquals("application/json", response.contentType());
        assertEquals( "application/json"   ,response.header("Content-Type"));



        //    And Payload/body should contain "IT_PROG"
        assertTrue( response.body().asString().contains("IT_PROG"));



        // print all the payload/body
        response.prettyPrint();




    }









}
