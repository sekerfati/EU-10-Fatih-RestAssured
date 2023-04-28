package com.cydeo.day12;

import com.cydeo.utilities.SpartanNewBase;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class OldRestAssuredTest extends SpartanNewBase {
   @Test
   public void  getAllSpartans(){

       given()
               .accept(ContentType.JSON)
               .and()
               .auth().basic("admin","admin")
               .log().all()
               .when()
               .get("/spartans")
               .then()
               .statusCode(200)
               .contentType(ContentType.JSON)
               .body("id[0]",is(2))
               .body("id[1]",is(3))
               .log().all();

   }


    @Test
    public void  test2(){

       /*
            in previous version of Restassured, the given when then style
            was actually written in given expect when format.
            it will assert all the result and give one answer and does not fail whole thing
            if first one fail unlike new structure.

         */


        given()
                .accept(ContentType.JSON)
                .and()
                .auth().basic("admin","admin")
                .log().all()
                .expect()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id[0]",is(2))
                .body("id[1]",is(3))
                .logDetail(LogDetail.ALL)// log way using expect()
                .when()
                .get("/spartans");

    }



}
