package com.thetestingacademy.E2EIntegration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationFlow2 {


//  CREATE BOOKING   -> DELETE it - verify

    @Test(groups = "QA", priority = 1)
    @Owner("Sai")
    @Description("TC#1INT 1 - Step1. verify that the booking can be Created.")
    public void testCreateBooking(ITestContext iTestContext) {

    }

    @Test(groups = "QA", priority = 4)
    @Owner("Sai")
    @Description("TC#1INT 4 - Step4. verify that the booking can be deleted.")
    public void testDeleteBookingById(ITestContext iTestContext) {

    }

    @Test(groups = "QA", priority = 2)
    @Owner("Sai")
    @Description("TC#1INT 2 - Step2. verify that the booking can be Created.")
    public void testVerifyBookingId(ITestContext iTestContext) {
        Integer bookingId = (Integer) iTestContext.getAttribute("bookingId");

    }


}
