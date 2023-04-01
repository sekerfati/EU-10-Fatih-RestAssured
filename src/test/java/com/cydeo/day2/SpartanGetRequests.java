package com.cydeo.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpartanGetRequests {


//    Given Accept type application/json
//    When user send GET request to api/spartans end point
//    Then status code must 200
//    And response Content Type must be application/json
//    And response body should include spartan result

    String baseUrl="http://44.200.16.230:8000";

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl + "/api/spartans");

//printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        //priting response content type from response object
        System.out.println("response.contentType() = " + response.contentType());


        //print whole result body
        response.prettyPrint();


        //how to do API testing then ?
        //verify status code is 200
        Assertions.assertEquals( response.statusCode(), 200 );


        //verify content type is application/json
        Assertions.assertEquals(  response.contentType(), "application/json");







    }






}
