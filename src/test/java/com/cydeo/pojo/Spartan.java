package com.cydeo.pojo;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = "id", allowSetters = true)


/*
{
    "id": 15,
    "name": "Meta",
    "gender": "Female",
    "phone": 1938695106
}
 */
public class Spartan {
    // getter and setter
    // toString

    private int id;
    private String name;
    private String gender;
    private long phone;


}
