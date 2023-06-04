package stepDefs.apiStepDefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.ConfigurationReader;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

public class GetStepDefs {

    Response response;

    @Given("user send a GET Request to the url")
    public void user_send_a_get_request_to_the_url() {

        spec.pathParams("first","booking", "second", 5);

        response = given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();




        //How to print 'Status Code' on the console?
        System.out.println("Status Code: " + response.getStatusCode());

        //How to print 'Content Type' on the console?
        System.out.println("Content Type: " + response.getContentType());

        //How to print 'Status Line' on the console?
        System.out.println("Status Line: " + response.getStatusLine());

        //How to print 'Header' on the console?
        System.out.println(response.getHeader("Connection"));

        //How to print 'Headers' on the console?
        System.out.println(response.getHeaders());

        //How to print 'Time' on the console?
        System.out.println("Time: " + response.getTime());
    }
    @Then("HTTP Status Code should be {int}")
    public void http_status_code_should_be(Integer statusCode) {

        int expectedStatusCode=statusCode;
        int actualStatusCode=response.statusCode();

        Assert.assertEquals(actualStatusCode,expectedStatusCode);

    }

    @Then("Content Type should be JSON")
    public void content_type_should_be_json() {

        response.then().assertThat().
                contentType("application/json");

    }


}
