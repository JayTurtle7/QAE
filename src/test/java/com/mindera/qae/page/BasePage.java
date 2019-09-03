package com.mindera.qae.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage {

    @FindBy(tagName = "head")
    private SelenideElement head;

    @FindBy(tagName = "body")
    private SelenideElement body;

    public SelenideElement getBody() {
        return body;
    }

    public SelenideElement getHead() {
        return head;
    }

    public void assertIntegrity() {
        this.getBody().should(Condition.exist);
        this.getHead().should(Condition.exist);
    }
}