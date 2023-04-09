package com.cydeo.day5;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class HamcrestMatchersApiTest {

       /*
       given accept type is Json
       And path param id is 15
       When user sends a get request to spartans/{id}
       Then status code is 200
       And content type is Json
       And json data has following
           "id": 15,
           "name": "Meta",
           "gender": "Female",
           "phone": 1938695106
        */


    @DisplayName("oneSpartan with Hamcrest and chaining ")
    @Test
    public void test1(){

        given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .when()
                .get("http://44.200.16.230:8000/api/spartans/{id}")
                .then()
                       .statusCode(200)
                        .and()
                        .contentType("application/json")
                         .and()
                         . body("id", equalTo(15),
                                 "name", is("Meta")
                                 , "gender", is("Female"),
                                 "phone", is(1938695106));




    }


    @DisplayName("CBTraining Teacher request with chaining and matchers")
    @Test
    public void teacherData(){
//

        given().accept(ContentType.JSON)
                .and()
                .pathParam("id", 2)
                .when()
                .get("https://api.training.cydeo.com/student/{id}")
                .then()
                .statusCode(200)
                .and()
                .contentType("application/json;charset=UTF-8")
                .and()
                .header("server", is("envoy"))
                .and()
                .header("Date", notNullValue())
                .and().assertThat()
                .body("students[0].firstName",is("Mark"))
                .body("students[0].lastName",is("Telesco"))
                .body("students[0].gender",equalTo("Male"));

    }


    @DisplayName("GET request to students/all and chaining")
    @Test
    public void studentsTest(){

        //verify    it has students' first names as Mark, ertret, Mike
               given().log().all()
               .accept(ContentType.JSON)
                .and()
                .when()
                .get("https://api.training.cydeo.com/student/all")
                .then()
                .statusCode(200)
                .and()
                .body("students.firstName",hasItems("Mark", "ertret", "Mike"));



    }





}
