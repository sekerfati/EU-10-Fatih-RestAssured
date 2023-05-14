package com.cydeo.day12;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class MockApi {
//https://f0b06645-1d8d-4811-b935-3bccc6074880.mock.pstmn.io


  @Test
  public void test1(){

      given().baseUri("https://f0b06645-1d8d-4811-b935-3bccc6074880.mock.pstmn.io")
              .accept(ContentType.JSON)
              .when()
              .get("/customer")
              .then()
              .statusCode(200)
              .contentType(ContentType.JSON)
              .body("firstName", is("John"))   ;

  }




    @Test
    public void test2(){

        given().baseUri("https://f0b06645-1d8d-4811-b935-3bccc6074880.mock.pstmn.io")
                .accept(ContentType.JSON)
                .when()
                .get("/employees")
                .prettyPrint()  ;

    }


}
