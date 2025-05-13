package com.thetestingacademy.module;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.thetestingacademy.POJOs.Request.Auth;
import com.thetestingacademy.POJOs.Request.Booking;
import com.thetestingacademy.POJOs.Request.Bookingdates;
import com.thetestingacademy.POJOs.Response.BookingResponse;
import com.thetestingacademy.POJOs.Response.TokenResponse;

public class PayloadManager {


    Gson gson;
    Faker faker;

    //convert the java object into the json String to use as payload.
    //Serialization
    public String createPayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Sai");
        booking.setLastname("kumar");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        // java object -> json

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        return jsonStringBooking;


    }
    //Convert the json String to java object so that we can verify response body
    // Deserializetion

    public BookingResponse bookingResponseJava(String responseString) {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponseJava);
        return bookingResponse;

    }

    public String setAuthPayload() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set the ->" + jsonPayloadString);

        return jsonPayloadString;
    }
    // Deser (JSON String -> java object)

    public String getTokenFromJson(String tokenResponse) {
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();

    }

    public String createPayloadBookingFakerJS() {

        faker = new Faker();
        Booking booking = new Booking();
        booking.setFirstname(faker.name().firstName());
        booking.setLastname(faker.name().lastName());
        booking.setTotalprice(faker.random().nextInt(1, 1000));
        booking.setDepositpaid(faker.random().nextBoolean());

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

    }



    }