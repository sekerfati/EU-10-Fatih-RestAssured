package com.cydeo.day6;
import com.cydeo.pojo.Link;
import com.cydeo.pojo.Region;
import com.cydeo.utilities.HRTestBase;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class ORDSPojoGetRequestTest extends HRTestBase {

    @Test
    public void regionTest(){
        JsonPath jsonPath = get("/regions").then().statusCode(200)
                         .extract().jsonPath();

        Region region1 = jsonPath.getObject("items[0]", Region.class);
        System.out.println("region1 = " + region1);

        System.out.println("region1.getRegion_name() = " + region1.getRegion_name());
        System.out.println("region1.getRegion_id() = " + region1.getRegion_id());
        System.out.println(region1.getLinks().get(0).getHref());





    }




}
