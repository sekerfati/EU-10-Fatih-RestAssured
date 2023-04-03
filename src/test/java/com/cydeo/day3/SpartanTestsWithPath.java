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




public class SpartanTestsWithPath {
    // beforeAll  is an annotation equals to @BeforeClass in TestNG, we use with static method name
    @BeforeAll
    public static void init(){
// save the baseURL inside this variable so that we do not need to type each http method
        baseURI="http://44.200.16.230:8000";
    }

  /*
     Given accept type is json
     And path param id is 10
     When user sends a get request to "api/spartans/{id}"
     Then status code is 200
     And content-type is "application/json"
     And response payload values match the following:
          id is 10,
          name is "Lorenza",
          gender is "Female",
          phone is 3312820936
   */
    @DisplayName("GET one spartan with Path Method")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 10)
                .log().all()
                .when()
                .get("/api/spartans/{id}");


//        Then status code is 200
       assertEquals(200, response.statusCode());


//        And content-type is "application/json"
        assertEquals("application/json", response.contentType());


// response.path() method returns generic Type(T) so that you do not need to convert it
        int id=response.path("id");
        String name=response.path("name");
        String gender=response.path("gender");
        long phone=response.path("phone");



//      And response payload/body values  id is 10,
        System.out.println(response.path("id").toString());
        assertEquals("10", response.path("id").toString());



//      And response payload value  name is "Lorenza",
        System.out.println(response.path("name").toString());
        assertEquals("Lorenza", response.path("name").toString());



//     And response payload value  gender is "Female",
        System.out.println(response.path("gender").toString());
        assertEquals("Female", response.path("gender").toString());


//     And response payload value  phone is 3312820936
        System.out.println(response.path("phone").toString());
        assertEquals("3312820936", response.path("phone").toString());


    }





}
