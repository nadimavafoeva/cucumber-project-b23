package com.cydeo.pages;

import com.cydeo.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleResultPage {
    @FindBy(id="result-stats")
    private WebElement searchResultCount;

    //grab the links with below style
    @FindBy(xpath = "//h3[@class='LC20lb DKV0Md']")
    private List<WebElement> resultLinks;

    public String getResultCountText(){
        return searchResultCount.getText();
    }
    public GoogleResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void printAllSearchResultLinks(){
        System.out.println("resultLinks.size() = " + resultLinks.size());
        for (WebElement eachLink : resultLinks) {
            System.out.println("eachLink.getText() = " + eachLink.getText());
        }
    }
}
