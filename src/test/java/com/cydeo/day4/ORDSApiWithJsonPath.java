package com.cydeo.day4;

import com.cydeo.utilities.HRTestBase;

import com.cydeo.utilities.HRTestBase;

import com.cydeo.utilities.SpartansTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
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


public class ORDSApiWithJsonPath extends HRTestBase {

    @DisplayName("GET request to Countries")
    @Test
    public void test1(){
        Response response = get("/countries");


        //to use jsonpath we assign response to JsonPath
        JsonPath jsonPath= response.jsonPath();



        //get the second country name with JsonPath
        String secondCountryName = jsonPath.getString("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);


        //get all country ids
        //items.country_id
        List<String> allCountryIDs = jsonPath.getList("items.country_id");
        System.out.println("allCountryIDs = " + allCountryIDs);



        //get all country names where their region id is equal to 2
        List<String> countryNameWithRegionID2= jsonPath.getList("items.findAll{it.region_id==2}.country_name");
        System.out.println("countryNameWithRegionID2 = " + countryNameWithRegionID2);


    }




    @DisplayName("GET requesto /employees with query param")
    @Test
    public void test2() {

        Response response = given().queryParam("limit", 107)
                           .when()
                            .get("/employees");


//get me all email of employees who is working as IT_PROG
        JsonPath jsonPath= response.jsonPath();
        List<String> allEmailsAsIT_PROG = jsonPath.getList("items.findAll {it.job_id==\"IT_PROG\"}.email");
        System.out.println("allEmailsAsIT_PROG = " + allEmailsAsIT_PROG);




        //get me first name of employees who is making more than 10000
        List<String> firstNames = jsonPath.getList("items.findAll {it.salary > 10000}.first_name");
        System.out.println("firstNames = " + firstNames);



        //get the max salary first_name
         String maxSalaryFirstName = jsonPath.getString("items.max {it.salary}.first_name");
        System.out.println("maxSalaryFirstName = " + maxSalaryFirstName);



        // get the max salary first_name with path method
        String kingNameWithPathMethod = response.path("items.max {it.salary}.first_name");
        System.out.println("kingNameWithPathMethod = " + kingNameWithPathMethod);







    }



}
