package com.cydeo.day4;

import com.cydeo.utilities.SpartansTestBase;


import com.cydeo.utilities.HRTestBase;

import com.cydeo.utilities.SpartansTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartansWithJsonPath extends SpartansTestBase {

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

    @DisplayName("GET one spartan with JsonPath")
    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id",10)
                .when().get("/api/spartans/{id}");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());



//print name with path method
        String name1 = response.path("name").toString();
        System.out.println("name1 = " + name1);


//assigning response to jsonpath
        JsonPath jsonPath= response.jsonPath();
        int id= jsonPath.getInt("id");
        String name2 = response.jsonPath().getString("name");
        String gender =response.jsonPath().getString("gender");
        long phone= response.jsonPath().getLong("phone");

        System.out.println("id = " + id);
        System.out.println("name2 = " + name2);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);




    }





}
