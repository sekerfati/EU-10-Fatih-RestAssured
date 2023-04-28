package com.cydeo.day11;
import com.cydeo.utilities.ExcelUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MethodSourceParameterizedTest {

   @ParameterizedTest
   @MethodSource("getNames")
   public void testPrintNames(String name){
       System.out.println(name);
   }

public static List<String> getNames(){
    //you can get value from anywhere almost anytype and return to your test
    //DB
    //Excel
    //other APIs

    List<String> nameList= Arrays.asList("Parvin","Nasim","mohamad","Nadir","Saim","Gurhan","Murodil");
    return nameList;
}


public static List<Map<String, String>> getExcelData(){
     // get your file object
    ExcelUtil vytrackFile= new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");

    // return sheet as a list of map
    return vytrackFile.getDataList();
}

    @ParameterizedTest
    @MethodSource("getExcelData")
    public void excelParamTest(Map<String, String> userInfo){

        System.out.println("firstname: " + userInfo.get("firstname"));
        System.out.println("lastname: " + userInfo.get("lastname"));

    }






}
