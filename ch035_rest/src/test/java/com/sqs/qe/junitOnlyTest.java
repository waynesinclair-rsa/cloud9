package com.sqs.qe;

import static org.junit.Assert.assertTrue;

import com.google.gson.JsonObject;
import org.jruby.RubyProcess;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/**
 * Unit test for simple App.
 */
public class junitOnlyTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void specificPostReturnsIdAndTitle()
    {
        when()
            .get("http://sandbox-lt:3000/posts/{id}", 4)
            .then().statusCode(200)
            .body(
                    "id", equalTo(4)
                    ,"title", equalTo("Resources")
            );
    }

    @Test
    public void givenAllDataExample(){
        when()
                .get("http://sandbox-lt:3000/db")
        .then().statusCode(200)
                .body(
                        "posts.id", hasItems(1, 2, 3, 4)
                        ,"comments.id", hasItems(1, 2, 3, 4)
                );

    }

    @Test
    public void postProfile(){
        JsonObject newObject = new JsonObject();
        // newObject.addProperty("id", 5);
        newObject.addProperty("name", "John");

        given()
                .contentType("application/json")
                .body(newObject)
        .when()
            .post("http://sandbox-lt:3000/profile")
        .then()
            .statusCode(201)
            .body("name", equalTo("John"));
    }

    @Test
    public void postComment(){
        JsonObject newObject = new JsonObject();
        newObject.addProperty("body", "Some Comment");
        newObject.addProperty("postId", 1);

        given()
                .contentType("application/json")
                // .parameter("id", 5, "body", "Some comment", "postId", 1)
                .body(newObject)
                .when()
                .post("http://sandbox-lt:3000/comments")
                .then()
                .statusCode(201)
                .body("postId", equalTo(1));
    }

    @Test
    public void deleteComment(){
        JsonObject newObject = new JsonObject();
        // newObject.addProperty("id", 5);
        newObject.addProperty("body", "Some Comment");
        newObject.addProperty("postId", 1);

        given()
                .contentType("application/json")
                .body(newObject)
                .when()
                .delete("http://sandbox-lt:3000/comments/{id}", 7)
                .then()
                .statusCode(200);
    }

}
