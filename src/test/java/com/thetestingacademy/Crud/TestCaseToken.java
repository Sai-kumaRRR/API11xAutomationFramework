package com.thetestingacademy.Crud;

import com.thetestingacademy.endpoint.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLinks;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;
import static org.testng.TestRunner.PriorityWeight.priority;

public class TestCaseToken {

    @Test(groups = "reg", priority = 1)
    @TmsLinks("https://bugz.atlassian.net/browse/TS-1")
    @Owner("Sai")
    @Description("TC#2 - Create Token and Verify")

    public void testTokenPOST(){

        // Prep of Req
        requestSpecification.basePath(APIConstants.AUTH_URL);

        // making of the request.
        response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthPayload()).post();

        // Extraction json string response to java object.
        String token = payloadManager.getTokenJSON(response.asString());

        // validation of the request.
        assertActions.verifyStringKeyNotNull(token);


    }


}
