package com.thetestingacademy.testssample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

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
    @Description("TC#1 - Step3.verify updated booking by ID")
    public void testUpdateBookingID() {

        Assert.assertTrue(true);
    }

    @Test(groups = "QA", priority = 4)
    @Owner("sai")
    @Description("TC#1 - Step4.Delete booking by ID")
    public void testDeleteBookingById() {
        Assert.assertTrue(true);

    }
}