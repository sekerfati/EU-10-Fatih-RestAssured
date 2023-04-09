package com.cydeo.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartansTestBase {
    // beforeAll  is an annotation equals to @BeforeClass in TestNG, we use with static method name
    @BeforeAll
    public static void init(){
// save the baseURL inside this variable so that we do not need to type each http method
        baseURI="http://44.200.16.230:8000";

        String dbUrl = "jdbc:oracle:thin:@44.200.16.230:1521:xe";
        String dbUsername = "SP";
        String dbPassword = "SP";

  //   DBUtils.createConnection(dbUrl, dbUsername, dbPassword);

    }



@AfterAll
    public static void tearDown(){
 //       DBUtils.destroy();
}







}
