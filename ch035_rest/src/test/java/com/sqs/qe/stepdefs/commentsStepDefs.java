package com.sqs.qe.stepdefs;

import com.google.gson.JsonObject;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class commentsStepDefs {
    RequestSpecification requestSpecification;
    JsonObject newObject;

    @Given("^A local blog$")
    public void aLocalBlog() throws Throwable {
        newObject = new JsonObject();
        requestSpecification = given().contentType("application/json");
    }

    @When("^I post a add request with postid (\\d+) and body \"([^\"]*)\"$")
    public void iPostAAddRequestWithPostidAndBody(int arg0, String arg1) throws Throwable {
        newObject.addProperty("body", arg1);
        newObject.addProperty("postId", arg0);
        requestSpecification = requestSpecification.body(newObject).when();
        requestSpecification.post("http://sandbox-lt:3000/comments");
    }

    @When("^I post a delete request for id (\\d+)$")
    public void iPostADeleteRequestForId(int arg0) throws Throwable {
        requestSpecification.when()
                .delete("http://sandbox-lt:3000/comments/{id}", arg0);
    }

    @Then("^The response should be (\\d+)$")
    public void theResponseShouldBe(int arg0) throws Throwable {
        requestSpecification.then().statusCode(arg0);
    }


}
