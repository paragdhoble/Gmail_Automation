package com.crossover.app.uielements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by parag.dhoble on 01-07-2018.
 * This class having the elements of Compose Email Page
 */
public class ComposeEmailElements {

    public ComposeEmailElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='T-I J-J5-Ji T-I-KE L3']")
    public WebElement compose_email_button;


    @FindBy(xpath = "//td//img[2]")
    public WebElement compose_email_maximise;

    @FindBy(className = "vO")
    public WebElement to_email_address;

    @FindBy(className = "aoT")
    public WebElement email_subject;

    @FindBy(xpath = "//div[text()='Send']")
    public WebElement send_email;

    @FindBy(xpath = "//span[@id=':3i']/b")
    public WebElement email_send_subject;

    @FindBy(xpath= "(.//*[@aria-label='Message Body'])[2]")
    public WebElement email_body ;

    @FindBy(xpath= "//div[@class='a1 aaA aMZ']")
    public WebElement attach_icon ;

    @FindBy(xpath= "//span[@id=':3i']/b")
    public WebElement recive_email ;














}
