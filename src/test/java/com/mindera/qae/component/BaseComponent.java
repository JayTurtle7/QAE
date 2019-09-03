package com.mindera.qae.component;

import com.codeborne.selenide.SelenideElement;

public abstract class BaseComponent {

    private SelenideElement component;

    BaseComponent(SelenideElement component) {
        this.component = component;
    }

    public abstract void assertIntegrity();

    public SelenideElement getComponent() {
        return component;
    }
}
