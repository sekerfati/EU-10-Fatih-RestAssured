package com.cydeo.day5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

    @DisplayName("Assertion with numbers")
    @Test
    public void simpleTest() {

        // actual 5+5
        assertThat(5 + 5, is(10));
        assertThat(5 + 5, equalTo(10));

//matchers has 2 overloaded version
        //first that accept actual value
        //second taht accept another matchers
        //below examples is method is accepting another matchers equal to make it readable
        assertThat(5 + 5, is(equalTo(10)));

        // negative comparison
        assertThat(5 + 5, not(9));
        assertThat(5 + 5, is(not(9)));
        assertThat(5 + 5, is(not(equalTo(9))));


//number comparison
        //greaterThan()
        //greaterThanOrEqualTo()
        //lessThan()
        //lessThanOrEqualTo()

        assertThat(5 + 5, is(greaterThan(9)));

    }


    @DisplayName("Assertion with numbers")
    @Test

   public void stringHamcrest(){
   String text="B22 is learning Hamcrest" ;


//checking for equality is same as numbers
        assertThat(text, is("B22 is learning Hamcrest"));
        assertThat(text, equalTo("B22 is learning Hamcrest"));
        assertThat(text, is(equalTo("B22 is learning Hamcrest")));

// check if this text starts with B22
        assertThat(text, startsWith("B22"));

 //now do it in case-insensitive manner
assertThat(text, startsWithIgnoringCase("b22"));

//ends-with
        assertThat(text, endsWith("Hamcrest"));

  //now do it in case-insensitive manner
        assertThat(text, endsWithIgnoringCase("hamcrest"));

 // checks is the text contains String learning
 assertThat(text, containsString("learning"));
 assertThat(text, containsStringIgnoringCase("LEARNING"));

 String str="   ";

 // check if above str is blank
        assertThat(str, blankString());


// check if trimmed  str is empty String
        assertThat(str.trim(), emptyString());




    }






}

