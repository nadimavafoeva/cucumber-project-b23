package com.cydeo.step_definitions;

import com.cydeo.pages.WAllProductPage;
import com.cydeo.pages.WCommonArea;
import com.cydeo.pages.WOrderPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class WebOrderStepDefs {
    WCommonArea commonArea = new WCommonArea();
    WAllProductPage allProductPage = new WAllProductPage();
    WOrderPage wOrderPage = new WOrderPage();

    @When("we select {string} tab from sidebar")
    public void weSelectTabFromSidebar(String tabName) {

        switch (tabName){
            case "View all orders":
                commonArea.viewAllOrderTab.click();
                break;
            case "View all products":
                commonArea.viewAllProductTab.click();
                break;
            case "Order":
                commonArea.orderTab.click();
                break;
        }

    }

    @Then("we should see below options in Product dropdown list")
    public void weShouldSeeBelowOptionsInProductDropdownList(List<String> expectedOptions) {
        List<String> actualOptions = wOrderPage.getAllProductOptionsFromList();
        assertEquals(expectedOptions, actualOptions);
    }

    @Then("we should see table with below content")
    public void weShouldSeeTableWithBelowContent(List<Map<String,String>> expectedProductMapLst) {
        assertEquals(expectedProductMapLst, allProductPage.getListRowMapFromWebTable());
//
//        // get expected headers :
//        Set<String> headerSet = productMapLst.get(0).keySet() ;
//        System.out.println("headerSet = " + headerSet);
//
//        // get actual header :
//        List<String> actualHeaders = allProductPage.getAllHeaderText();
//        System.out.println("actualHeaders = " + actualHeaders);
//
//        // check the size is the same
//        assertEquals(headerSet.size() , actualHeaders.size() );
//
//        // list to set equality check will not work
//        // so we need to turn the set into list
//        List<String> expectedHeaders = new ArrayList<>( headerSet );
//        assertEquals(expectedHeaders, actualHeaders);
    }
    @Then("we should see three section as below")
    public void we_should_see_three_section_as_below(List<String> expectedSections) {
       List<String> actualSections = BrowserUtil.getAllText(wOrderPage.sections);
       assertEquals("failed",expectedSections,actualSections);
    }

    @Then("select each product from dropdown should change the unit price accordingly")
    public void select_each_product_from_dropdown_should_change_the_unit_price_accordingly(Map<String,String> expectedProductUnitPrice) {
        Map<String,String> actualProductUnitPrice=new LinkedHashMap<>();
        List<String>products =wOrderPage.getAllProductOptionsFromList();
        List<String>prices =wOrderPage.getAllPriceOptions();
        for (int i = 0; i < products.size(); i++) {
            actualProductUnitPrice.put(products.get(i),prices.get(i));
        }
        assertEquals(expectedProductUnitPrice, actualProductUnitPrice);

    }
}
