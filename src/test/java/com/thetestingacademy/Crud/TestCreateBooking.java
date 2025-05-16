package com.thetestingacademy.Crud;

import com.thetestingacademy.Base.BaseTest;
import com.thetestingacademy.POJOs.Response.BookingResponse;
import com.thetestingacademy.endpoint.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Sai")
    @Description("Tc#1 - Verify that the booking be Created")
    public void testCreateBookingPOST_Positive() {


        // setup and making a Request.
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingAsString()).log().all().post();
               System.out.println(response.asString());
        //Extraction
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());


        // Verification part
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Sai");


    }

    @Test(groups = "reg", priority = 1)
    @Owner("Sai")
    @Description("Tc#1 - Verify that the booking be created when payload is null")
    public void testCreateBookingPOST_NEGATIVE() {

        //setup and making a request.
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body("{}").log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);

    }
    @Test(groups = "reg", priority = 1)
    @Owner("Sai")
    @Description("TC#1 - Verify that the Booking be Created, When Payload is RANDOM")
    public void testCreateBookingPOST_POSITIVE_RANDOM_DATA() {

        //Setup and making a request.
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingFakerJS()).log().all().post();
        System.out.println(response.asString());

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }

}