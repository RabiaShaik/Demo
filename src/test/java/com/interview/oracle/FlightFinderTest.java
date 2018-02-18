package com.interview.oracle;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class FlightFinderTest extends LocatorsAndActions {

    @Parameters({"fUsername","fPassword"})
    @Test()

    public void flightFinderPageTitleTest(String fUsername, String fPassword) throws Exception {

        String flights_search_expected_title = "Select a Flight: Mercury Tours";
        userName().sendKeys(fUsername);
        password().sendKeys(fPassword);
        submitButton().click();
        tripType().click();
        passengersCount().selectByIndex(2);
        departingFrom().selectByValue(prop.getProperty("departingFrom"));
        departingMonth().selectByValue(prop.getProperty("departingMonth"));
        departingDate().selectByValue(prop.getProperty("departingDate"));
        arrivingTo().selectByValue(prop.getProperty("arrivingTo"));
        String city = departingFrom().getFirstSelectedOption().getText() + " to " + arrivingTo().getFirstSelectedOption().getText();
        System.out.println("This is city............" + city);
        returningMonth().selectByValue(prop.getProperty("returningMonth"));
        returningDate().selectByValue(prop.getProperty("returningDate"));
        travelClass().click();
        airline().selectByIndex(2);
        continueButton().click();
        Assert.assertEquals(flights_search_expected_title, flightSearchPageTitle());
    }

    @Parameters({"fUsername","fPassword"})
    @Test()

    public void flightFinderFromToCityTest(String fUsername, String fPassword) throws Exception {

        userName().sendKeys(fUsername);
        password().sendKeys(fPassword);
        submitButton().click();
        tripType().click();
        passengersCount().selectByIndex(3);
        departingFrom().selectByValue(prop.getProperty("departingFrom"));
        departingMonth().selectByValue(prop.getProperty("departingMonth"));
        departingDate().selectByValue(prop.getProperty("departingDate"));
        arrivingTo().selectByValue(prop.getProperty("arrivingTo"));
        String city = departingFrom().getFirstSelectedOption().getText() + " to " + arrivingTo().getFirstSelectedOption().getText();
        System.out.println("This is from and to City where User travels............" + city);
        returningMonth().selectByValue(prop.getProperty("returningMonth"));
        returningDate().selectByValue(prop.getProperty("returningDate"));
        travelClass().click();
        airline().selectByIndex(2);
        continueButton().click();
        Assert.assertTrue(page().contains(city));
    }

    @Parameters({"fUsername","fPassword"})
    @Test()

    public void flightValidationTest(String fUsername, String fPassword) throws Exception {

        String flightExpected = "Blue Skies";
        userName().sendKeys(fUsername);
        password().sendKeys(fPassword);
        submitButton().click();
        tripType().click();
        passengersCount().selectByIndex(3);
        departingFrom().selectByValue(prop.getProperty("departingFrom"));
        departingMonth().selectByValue(prop.getProperty("departingMonth"));
        departingDate().selectByValue(prop.getProperty("departingDate"));
        arrivingTo().selectByValue(prop.getProperty("arrivingTo"));
        returningMonth().selectByValue(prop.getProperty("returningMonth"));
        returningDate().selectByValue(prop.getProperty("returningDate"));
        travelClass().click();
        airline().selectByIndex(2);
        continueButton().click();
        Assert.assertTrue(flightActual().contains(flightExpected));
    }

}