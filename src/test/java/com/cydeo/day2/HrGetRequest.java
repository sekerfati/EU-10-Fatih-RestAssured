package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HrGetRequest {


// beforeAll  is an annotation equals to @BeforeClass in TestNG, we use with static method name
@BeforeAll
    public static void init(){
// save the baseURL inside this variable so that we do not need to type each http method
    RestAssured.baseURI="http://44.200.16.230:1000/ords/hr";
}

@DisplayName("GET request to /regions")

@Test
    public void test1(){
    Response response = RestAssured.get("/regions");
// print the statusCode
    System.out.println("response.statusCode() = " + response.statusCode());


}



/*
        Given accept type is application/json
        When user sends get request to /regions/2
        Then response status code must be 200
        and content type equals to application/json
        and response body contains   Americas
     */

   @DisplayName("GET request to /regions/2")
  @Test
    public  void test2(){

       Response response = RestAssured.get("/regions/2");

       // verify statusCode
       Assertions.assertEquals(200, response.statusCode());

       // verify content type
       Assertions.assertEquals("application/json", response.contentType());

       // print the body
       response.prettyPrint();


       // verify body contains Americas
       Assertions.assertTrue(response.body().asString().contains("Americas"));


   }











}
