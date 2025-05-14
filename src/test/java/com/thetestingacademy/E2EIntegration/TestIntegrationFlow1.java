package com.thetestingacademy.E2EIntegration;

import com.thetestingacademy.Base.BaseTest;
import com.thetestingacademy.POJOs.Request.Booking;
import com.thetestingacademy.POJOs.Response.BookingResponse;
import com.thetestingacademy.endpoint.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestIntegrationFlow1 extends BaseTest {

// TestE2EFlow_01

// Test E2E Scenario 1

// 1.) create a booking -> bookingID

// 2.) create token -> token

//3.) verify that the Create booking is working - GET Request to bookingID

//4.) Update the booking (bookingID, Token) - need to get the token , bookingID

//5.) Delete the booking - need to get the token , bookingID from above request.



    @Test(groups = "QA", priority = 1)
    @Owner("Sai")
    @Description("TC#1 - Step1.Verify that the Booking can be Created.")
    public void testCreateBooking(ITestContext iTestContext) {


        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createPayloadBookingFakerJS()).log().all().post();
        System.out.println(response.asString());


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Sai");
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());

        iTestContext.setAttribute("bookingid",bookingResponse.getBookingid());


    }


    @Test(groups = "QA", priority = 2)
    @Owner("Sai")
    @Description("TC# INT1 - Step2.Verify that the Booking by ID")
    public void testCreateBookingId(ITestContext iTestContext) {

     Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

     String basePathGET = APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePathGET);


        requestSpecification.basePath(basePathGET);
        response = RestAssured.given(requestSpecification).when().get();



        validatableResponse = response.then().log().all();

        //variable Assertion
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertActions.verifyStringKeyNotNull(booking.getFirstname());


    }

    @Test(groups = "QA", priority = 3)
    @Owner("sai")
    @Description("TC#1 - Step1.verify updated booking by ID")
    public void testUpdateBookingByID(ITestContext iTestContext) {

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = getToken();


        String basePATHPUTPATCH = APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePATHPUTPATCH);


    }


    @Test(groups = "QA", priority = 4)
    @Owner("sai")
    @Description("TC#1 - Step1.Delete booking by ID")
    public void testCreateBookingById() {
        Assert.assertTrue(true);

    }
}


