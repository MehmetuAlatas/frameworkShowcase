package stepDefs.apiStepDefs;


import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class PostStepDefs {

    /*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 }
                 "additionalneeds": "Breakfast with white tea, Dragon juice"
             }
        When
          I send POST Request to the URL
       Then
          Status code is 200
      And
          Response body is like {
                                  "bookingid": 16,
                                  "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        }
                                        "additionalneeds": "Breakfast with white tea, Dragon juice"
                                     }
                                  }
     */

    Response response;
    BookingPojo bookingPojo;
    BookingResponseBodyPojo actualPojo;
    BookingDatesPojo bookingDates;

    @Given("user send a post request to the url")
    public void userSendAPostRequestToTheUrl() {
        //1.Step: Set the URL
        spec.pathParam("first", "booking");

    }


    @And("user sets the expected data")
    public void userSetsTheExpectedData() {
        //2.Step: Set the Expected Data
        bookingDates = new BookingDatesPojo("2021-09-21", "2021-12-21");
        bookingPojo = new BookingPojo("Ali", "Can", 999, true, bookingDates, "Breakfast with white tea, Dragon juice");

    }


    @And("verifies that user should be created")
    public void verifiesThatUserShouldBeCreated() {

        //3.Step:Send POST Request and get the Response
        response = given().spec(spec).contentType(ContentType.JSON).body(bookingPojo).when().post("/{first}");
        response.prettyPrint();

        //4.Step: Do Assertions
         actualPojo = response.as(BookingResponseBodyPojo.class);

        assertEquals(bookingPojo.getFirstname(), actualPojo.getBooking().getFirstname());
        assertEquals(bookingPojo.getLastname(), actualPojo.getBooking().getLastname());
        assertEquals(bookingPojo.getTotalprice(), actualPojo.getBooking().getTotalprice());
        assertEquals(bookingPojo.getDepositpaid(), actualPojo.getBooking().getDepositpaid());

        //1.Way: Can be used
        assertEquals(bookingPojo.getBookingdates().getCheckin(), actualPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingPojo.getBookingdates().getCheckout(), actualPojo.getBooking().getBookingdates().getCheckout());

        //2.Way: Recommended
        assertEquals(bookingDates.getCheckin(), actualPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDates.getCheckout(), actualPojo.getBooking().getBookingdates().getCheckout());
    }


}