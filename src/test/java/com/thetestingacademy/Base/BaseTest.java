package com.thetestingacademy.Base;

import com.thetestingacademy.asserts.AssertActions;
import com.thetestingacademy.endpoint.APIConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {


    // common to all testcase
    // base url , Content-Type -> json common

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeTest
    public void setup() {
        System.out.println("Starting of the Test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        // requestSpecification = RestAssured.given();
        // requestSpecification.baseUri(APIConstants.BASE_URL);
        //requestSpecification.contentType(ContentType.JSON).log().all();

        requestSpecification = new RequestSpecBuilder().setBaseUri(APIConstants.Base_Url)
                .addHeader("Content-Type", "application/json")
                .build().log().all();




    }

    @AfterTest
    public void tearDown() {
        System.out.println("Finished the Test!");

    }


}
