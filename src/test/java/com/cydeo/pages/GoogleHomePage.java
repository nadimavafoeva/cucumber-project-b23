package com.cydeo.pages;

import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.ConfigReader;
import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name ="btnK")
    private WebElement searchBtn;

    public GoogleHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void goTo(){
       // Driver.getDriver().get("https://www.google.com");
        Driver.getDriver().get(ConfigReader.read("google_url"));
    }
    public void searchKeyword(String keyword){
        this.searchBox.sendKeys(keyword);
        BrowserUtil.waitFor(1);
        this.searchBtn.submit();

    }
    public boolean isAt(){
       return Driver.getDriver().getTitle().equals("Google");
    }
}
