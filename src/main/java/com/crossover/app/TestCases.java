package com.crossover.app;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.crossover.app.common.Constant;
import com.crossover.app.common.Reuseable;
import com.crossover.app.uielements.ComposeEmailElements;
import com.crossover.app.uielements.LoginPageElements;
import com.crossover.app.utils.EmailApi;
import com.crossover.app.utils.ReportGenrator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;


import static com.crossover.app.common.Reuseable.*;


/**
 * All the Test Cases
 * Created by parag.dhoble on 30-06-2018.
 */
public class TestCases {
    public static WebDriver driver;
    Reuseable reuseable;
    ExtentTest extest ;
    ExtentReports exReport ;

    ReportGenrator r = new ReportGenrator ();

    Logger log;





    @BeforeMethod
    public void setUp() throws Exception {
        log = Logger.getLogger("Web_Automation");
    }

    /**
     * This test is used to Launch the browser
     *
     */
    @Test(priority = 1)
    public void browserLaunch() throws IOException {

        try {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            log.debug("Window Maximaize");
            driver.get(Constant.URL);
            log.debug("URL launch");
            ReportGenrator.testResultDetails.put("1" , new Object[]{"TC_1" ,"Launch browser","PASS" });

        }catch (Exception e){
            log.error(e);
            ReportGenrator.testResultDetails.put("1" , new Object[]{"TC_1" ,"Launch browser","Fail" });
            log.debug("Unable to launch URL");
        }



    }

    /**
     * This test is use to Login gmail
     * @throws InterruptedException
     */

    @Test(priority = 2)
    public void loginTest() throws InterruptedException {
        try {
            LoginPageElements loginPageElements = new LoginPageElements(driver);
            login(Constant.Sender, Constant.Password);
            log.debug("Enter user name "+Constant.Sender);
            log.debug("Enter Password"+Constant.Password);
            Thread.sleep(5000);
            clickOnElement(loginPageElements.email_image);
            log.debug("login successfully");
            ReportGenrator.testResultDetails.put("2" , new Object[]{"TC_2" ,"User is able to Login ","PASS" });
        }catch (Exception e){
            log.error(e);
            log.debug("Unable to login");
            ReportGenrator.testResultDetails.put("2" , new Object[]{"TC_2" ,"Login","FAIL" });
        }

    }


    @AfterTest
    public  void updateReport() throws IOException {
        r.writeDataInExcel();
        log.debug("Excel Updated");
        EmailApi email = new EmailApi();
        email.SendEmail();
        log.debug("Email Send successfully");
    }

    /**
     * This Test is use to compose Email
     */
    //@Test(priority = 3)
    public void composeMail() throws InterruptedException {
        ComposeEmailElements composeEmailElements = new ComposeEmailElements(driver);
        implicitWait(10000);
        clickOnElement(composeEmailElements.compose_email_button);
        clickOnElement(composeEmailElements.compose_email_maximise);
        sendKeys(composeEmailElements.to_email_address, Constant.Recipient);
        Date dNow = new Date();
        SimpleDateFormat subjectdate = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm a zzz");
        String emailsubject = "Current time " + subjectdate.format(dNow).toString();
        sendKeys(composeEmailElements.email_subject, emailsubject);
        implicitWait(2000);
        clickOnElement(composeEmailElements.email_body);
        sendKeys(composeEmailElements.email_body ,Constant.Email_Body);

        clickOnElement(composeEmailElements.attach_icon);
        try {
            Thread.sleep(10000);
            Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\attach.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(9000);
        clickOnElement(composeEmailElements.send_email);
        Thread.sleep(9000);
        logout();
        driver.close();


    }

    /**
     * This test cases is used to login in into another account
     * @throws InterruptedException
     */
  /*  @Test(priority = 4)
    public void login_2() throws InterruptedException {
        LoginPageElements loginPageElements = new LoginPageElements(driver);
        driver.navigate().refresh();
        implicitWait(5000);
        clickOnElement(loginPageElements.arrow);
        Thread.sleep(9000);
        clickOnElement(loginPageElements.use_another_account);
        login(Constant.Recipient, Constant.Password);

    }

    *//**
     * This Test Case is use to validate subject , body , attachment.
     * @throws InterruptedException
     *//*
    @Test(priority = 5)
    public void email_validation() throws InterruptedException {
        ComposeEmailElements composeEmailElements = new ComposeEmailElements(driver);
        Thread.sleep(9000);
        clickOnElement(composeEmailElements.recive_email);
        Thread.sleep(5000);
          *//*  String subject=driver.findElement(By.xpath("//h2[@id=':bp']")).getText();
            if(subject.startsWith("Current time"))
            {
                System.out.println("mail received");
            }else{
                System.out.println("mail not received");
            }*//*
        String subject1 = driver.findElement(By.xpath("//div[@dir='ltr'][text()='Dear Mail Crawler,']")).getText();
        if (subject1.equals(Constant.Email_Body)) {
            System.out.println("True");
        } else {
            System.out.println("false");
        }
        String attach = driver.findElement(By.xpath("//div[@class='aQA']//span")).getText();
        if (attach.contains("Text.txt")) {
            System.out.println("True");
        } else {
            System.out.println("false");
        }
        driver.close();
    }*/
}



