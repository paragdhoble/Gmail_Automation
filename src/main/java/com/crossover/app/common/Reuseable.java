package com.crossover.app.common;

import com.crossover.app.uielements.LogOutElements;
import com.crossover.app.uielements.LoginPageElements;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.apache.commons.io.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.crossover.app.TestCases.driver;


/**
 * Created by parag.dhoble on 01-07-2018.
 */
public class Reuseable {

    static LoginPageElements loginPageElements = new LoginPageElements(driver);
    static LogOutElements logOutElements = new LogOutElements(driver);

    /**
     * This method is use to Click on element
     *
     * @param element
     */
    public static void clickOnElement(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is use to send value to element
     *
     * @param element
     * @param text
     */
    public static void sendKeys(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));

        try {
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is use to wait
     *
     * @param time
     */
    public static void implicitWait(long time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }


    /**
     * This method is used to Login Gmail account
     *
     * @param username
     * @param password
     */
    public static void login(String username, String password) {
        try {
            implicitWait(1000);
            sendKeys(loginPageElements.username, username);
            clickOnElement(loginPageElements.nxt_1);
            sendKeys(loginPageElements.password, password);
            clickOnElement(loginPageElements.nxt_2);
           /* if((loginPageElements.email_image).isDisplayed()){
                clickOnElement(loginPageElements.email_image);
            }*/
            System.out.println("User is able to login successfully");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("User is not able to Login");
        }
    }

    /**
     * This method is use to logout gmail account
     */
    public static void logout() {
        clickOnElement(logOutElements.setting_icon);
        clickOnElement(logOutElements.logout_button);
        System.out.println("User is able to logout successfully");

    }

}
