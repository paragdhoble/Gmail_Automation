package com.crossover.app.uielements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class having the elements of Logout page
 * Created by parag.dhoble on 01-07-2018.
 */
public class LogOutElements {

    public LogOutElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='gb_Sc gb_mb gb_Pg gb_R']")
    public WebElement setting_icon;


    @FindBy(id = "gb_71")
    public WebElement logout_button;

}
