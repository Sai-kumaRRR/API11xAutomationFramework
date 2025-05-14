package com.thetestingacademy.Crud;

import com.thetestingacademy.Base.BaseTest;
import com.thetestingacademy.endpoint.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test(groups = "reg", priority = 1)

    @Owner("Sai")
    @Description("TC#2 - Create Token and Verify")

    public void testTokenPOST() {

        // Prep of Req
        requestSpecification.basePath(APIConstants.AUTH_URL);

        // making of the request.
        response = RestAssured.given(requestSpecification).when().body(payloadManager.setAuthPayload()).post();

        // Extraction json string response to java object.
        String token = payloadManager.getTokenFromJson(response.asString());
        System.out.println(token);

        // validation of the request.
        assertActions.verifyStringKeyNotNull(token);


    }


}
