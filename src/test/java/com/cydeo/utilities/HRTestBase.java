package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class HRTestBase {
    // beforeAll  is an annotation equals to @BeforeClass in TestNG, we use with static method name
    @BeforeAll
    public static void init(){
// save the baseURL inside this variable so that we do not need to type each http method
        baseURI="http://44.200.16.230:1000/ords/hr";
    }
}
