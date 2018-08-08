package com.crossover.app.uielements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by parag.dhoble on 01-07-2018.
 * This class having the elements of Login Page
 **/
public class LoginPageElements {

    public LoginPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "identifierId")
    public WebElement username;

    @FindBy(xpath = "//INPUT[@type='password']")
    public WebElement password;

    @FindBy(id = "identifierNext")
    public WebElement nxt_1;


    @FindBy(id = "passwordNext")
    public WebElement nxt_2;

    @FindBy(xpath = "//a[@class='WaidBe']")
    public WebElement email_image;

    @FindBy(xpath = "//div[@class='a9cric']")
    public WebElement arrow;

    @FindBy(xpath = "//div[@class='vdE7Oc f3GIQ']/p[contains(text(), 'Use another account')]")
    public WebElement use_another_account;

}
