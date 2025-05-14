package com.thetestingacademy.E2EIntegration;

import com.thetestingacademy.POJOs.Request.Booking;
import com.thetestingacademy.POJOs.Response.BookingResponse;
import com.thetestingacademy.endpoint.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;
import static jdk.dynalink.linker.support.Guards.isNotNull;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestIntegrationflow1 extends BaseTest {

    // TestE2EFlow_01
    // Test E2E Scenario 1
    // 1.) create a booking -> bookingID
    // 2.) create token -> token
    //3.) verify that the create booking is working - GET Request to bookingID
    //4.) Update the booking (bookingID, Token) - need to get the token , bookingID
    //5.) Delete the booking - need to get the token , bookingID from above request.

    public class testIntegrationSample {

        // create a booking, create a token
        // verify that get booking
        //update the booking
        //delete the booking

        @Test(groups = "QA", priority = 1)
        @Owner("Sai")
        @Description("TC#1 - Step1.Verify that the Booking can be Created.")
        public void testCreateBooking(ITestContext iTestContext){

        }


        @Test(groups = "QA", priority = 2)
        @Owner("Sai")
        @Description("TC# INT1 - Step2.Verify that the Booking by ID")
        public void testCreateBookingId(ITestContext iTestContext) {

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        String basePathGET = APIConstants.CRATE_UPDATE_URL + "/"+bookingid;
            System.out.println(basePathGET);

            requestSpecification.basePath(basePathGET);
            response = RestAssured
                    .given(requestSpecification)
                    .when().get();
            validateResponse = response.then().log().all();

           // Validatable Assertion
             validatableResponse.statusCode(200);

             Booking booking = payloadManager.getResponseFromJSON(response.asString());
             assertThat(booking.getFirstname()).isNotNull().isNotBlank);
             assertThat(booking.getFirstname()).isEqualTo("Sai");




        }

        @Test(groups = "QA", priority = 3)
        @Owner("sai")
        @Description("TC#1 - Step1.verify updated booking by ID")
        public void testcreateBookingID() {
            Assert.assertTrue(true);
        }






        @Test(groups = "QA", priority = 4)
        @Owner("sai")
        @Description("TC#1 - Step1.Delete booking by ID")
        public void testcreateBookingById() {
            Assert.assertTrue(true);

        }
    }

}
