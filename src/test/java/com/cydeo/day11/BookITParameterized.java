package com.cydeo.day11;

import com.cydeo.utilities.ExcelUtil;
import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.List;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BookITParameterized {
    public static List<Map<String, String>> getExcelData(){

        ExcelUtil bookItFile= new ExcelUtil("src/test/resources/BookItQa3.xlsx", "QA3");

   return bookItFile.getDataList();
    }


    @ParameterizedTest
    @MethodSource("getExcelData")
    public void bookItTest(Map<String, String> user){
        System.out.println("email = " + user.get("email"));
        System.out.println("password = " + user.get("password"));

           given()
                   .baseUri("http://api.qa3.bookit.cydeo.com")
                   .accept(ContentType.JSON)
                   .queryParams(user)// I pass map directly beacuse query param keys and map keys are equal
                   .when()
                   .get("/sign")
                   .then()
                   .statusCode(200)
                   .log().body();


    }



}
