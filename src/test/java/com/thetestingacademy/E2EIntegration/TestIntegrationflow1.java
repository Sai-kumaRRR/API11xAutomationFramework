package com.thetestingacademy.E2EIntegration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationflow1 {

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
        @Owner("sai")
        @Description("TC#1 - Step1.verify that the booking can be created.")
        public void testcreateBooking() {
            Assert.assertTrue(true);


        }

        @Test(groups = "QA", priority = 2)
        @Owner("sai")
        @Description("TC#1 - Step2.verify that the booking by ID")
        public void testcreateBookingId() {
            Assert.assertTrue(true);

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
