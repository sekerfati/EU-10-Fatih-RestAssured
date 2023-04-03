package com.cydeo.day3;


import com.cydeo.utilities.SpartansTestBase;
import io.restassured.http.ContentType;
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




public class SpartanTestsWithPath extends SpartansTestBase {


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
    //    assertEquals("10", response.path("id").toString());
        assertEquals(10, id);



//      And response payload value  name is "Lorenza",
        System.out.println(response.path("name").toString());
        //    assertEquals("Lorenza", response.path("name").toString());
        assertEquals("Lorenza", name);



//     And response payload value  gender is "Female",
        System.out.println(response.path("gender").toString());
        //      assertEquals("Female", response.path("gender").toString());
        assertEquals("Female", gender);


//     And response payload value  phone is 3312820936
        System.out.println(response.path("phone").toString());
        //     assertEquals("3312820936", response.path("phone").toString());
        assertEquals(3312820936L, phone);


    }



    @DisplayName("GET all spartan and navigate with Path()")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                             .when()
                              .get("/api/spartans");

        // print all body/payload
      //  response.prettyPrint();


// to retrieve all info one by one
int firstID=response.path("id[0]");
System.out.println("firstID = " + firstID);


String name=response.path("name[0]");
System.out.println("name = " + name);


// last firstname in the query([99])
    //    String lastFirstname=response.path("name[99]");
        String lastFirstname=response.path("name[-1]");

        System.out.println("lastFirstname = " + lastFirstname);



        //save names inside the list of string
        List<String> names = response.path("name");
        System.out.println("names = " + names);
        for (String eachName : names) {
            System.out.println(eachName);
        }






    }












}
