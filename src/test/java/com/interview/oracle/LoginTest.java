package com.interview.oracle;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends LocatorsAndActions {

    @Test(priority = 1, dataProvider = "validAuthentication")

    public void checkValidLogin(String sUsername, String sPassword) throws Exception{

        String expectedTitle = "Find a Flight: Mercury Tours:";

        userName().sendKeys(sUsername);

        password().sendKeys(sPassword);

        submitButton().click();

        Assert.assertEquals(pageTitle(),expectedTitle);
    }

    @Parameters({"nUsername","nPassword"})
    @Test(priority = 2)

    public void checkInvalidLogin(String nUsername, String nPassword) throws Exception{

        String expectedTitle = "Find a Flight: Mercury Tours:";

        userName().sendKeys(nUsername);

        password().sendKeys(nPassword);

        submitButton().click();

        Assert.assertNotEquals(pageTitle(),expectedTitle);
    }
}
