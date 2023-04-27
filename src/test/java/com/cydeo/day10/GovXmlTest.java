package com.cydeo.day10;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class GovXmlTest {

    public void test1() {
        //send a get request to
        //https://data.ct.gov/api/views/qm34-pq7e/rows.xml
        //get all the years
        //get all unknowns
        //get 2005 other
        //get 2007 _address

        Response response = get("https://data.ct.gov/api/views/qm34-pq7e/rows.xml");

        XmlPath xmlPath = response.xmlPath();


        //get all the years
        List<Integer> years = xmlPath.getList("response.row.row.year");
        System.out.println("list = " + years);
        //get all unknowns
        List<Integer> unknowns = xmlPath.getList("response.row.row.unknown");
        System.out.println("unknowns = " + unknowns);
        //get 2005 other
        List<Integer> other2005 = xmlPath.getList("response.row.row[2].other");
        System.out.println("other2005 = " + other2005);
        //get 2007 _address
        String address2007 = xmlPath.getString("response.row.row[4].@_address");
        System.out.println("address2007 = " + address2007);



    }





}
