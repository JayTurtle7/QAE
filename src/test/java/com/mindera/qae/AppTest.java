package com.mindera.qae;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.AssertJUnit.assertTrue;


import com.codeborne.selenide.*;

import com.mindera.qae.component.Table;
import com.mindera.qae.page.Homepage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseConfig {
    /**
     * Rigorous Test :-)
     */
    private Homepage homepage;
    private Table table;

    @BeforeMethod(groups = {"smoke", "regression"})
    public void test() {
        this.homepage= Selenide.open("http://localhost:3000/", Homepage.class);
        this.table = this.homepage.getTable();
    }

    @AfterMethod(groups = {"smoke", "regression"})
    public void after(){
        Selenide.close();
    }

    @Test(groups = {"smoke", "regression"})
    public void HomePageTest() {
        homepage.assertIntegrity();
    }

    @Test(groups = {"smoke", "regression"})
    public void TableTest() {
        table.checkPositionBeforeAfter();
        table.checkTextPosAfter();
    }




}
