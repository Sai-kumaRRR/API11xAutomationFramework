package com.thetestingacademy.Base;

import com.thetestingacademy.asserts.AssertActions;
import com.thetestingacademy.endpoint.APIConstants;
import com.thetestingacademy.module.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    // common to all testcase
    // base url , Content-Type -> json common

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeTest
    public void setup() {
        System.out.println("Starting of the Test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        //  requestSpecification = RestAssured.given();
        //  requestSpecification.baseUri(APIConstants.BASE_URL);
        //  requestSpecification.contentType(ContentType.JSON).log().all();

        requestSpecification = new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();


    }


    public String getToken() {
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.BASE_URL)
                .basePath(APIConstants.AUTH_URL);

        //Setting the payload
        String payload = payloadManager.setAuthPayload();
        //get the token
        response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();

        String token = payloadManager.getTokenFromJson(response.asString());
        return token;
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Finished the Test!");

    }


}
