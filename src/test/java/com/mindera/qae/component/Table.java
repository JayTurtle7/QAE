package com.mindera.qae.component;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.interactions.Coordinates;
import org.testng.Assert;
import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;


public class Table extends BaseComponent {

    public Table() {
        super($(byId("app")));
    }

    private SelenideElement getItemByPosition(int number) {
        SelenideElement element = (this.getComponent().$$("li").get(number));
        return element;
    }

    private Coordinates getCoordinatesItem(int number) {
        SelenideElement element = getItemByPosition(number);
        return element.getCoordinates();
    }

    private boolean areCoordinatesEquals(Coordinates before, Coordinates after) {
        return before.onPage().x == after.onPage().x && before.onPage().y == after.onPage().y;
    }

    private SelenideElement getItemByNumber(int number) {
        SelenideElement element = (this.getComponent().$$("li").findBy(Condition.text("" + number)));
        return element;
    }

    private void moveElem(int number) {
        getItemByNumber(number).dragAndDropTo(getItemByPosition(number));
    }

    private void moveAllElem() {
        for (int i = 0; i < this.getComponent().$$("li").size(); i++) {
            moveElem(i);
        }
    }

    private String getTextPos(int number) {
        SelenideElement element = getItemByPosition(number);
        return element.getText();
    }

    private boolean checkTextPos() {
        for (int i = 0; i < this.getComponent().$$("li").size(); i++) {
            if (!getTextPos(i).equals("Item " + i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRelativePos() {
        ArrayList<Coordinates> before = new ArrayList<>();
        ArrayList<Coordinates> after = new ArrayList<>();
        for (int i = 0; i < this.getComponent().$$("li").size(); i++) {
            before.add(getCoordinatesItem(i));
        }
        moveAllElem();
        for (int i = 0; i < this.getComponent().$$("li").size(); i++) {
            after.add(getCoordinatesItem(i));
        }
        for (int i = 0; i < this.getComponent().$$("li").size(); i++) {
            if (!areCoordinatesEquals(before.get(i), after.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void checkTextPosAfter() {
        moveAllElem();
        Assert.assertEquals(checkTextPos(), true);
    }

    public void checkPositionBeforeAfter() {
        Assert.assertEquals(checkRelativePos(), true);
    }

    @Override
    public void assertIntegrity() {
        this.getComponent().should(Condition.exist);
        Assert.assertEquals(this.getComponent().$$("li").size(), 6);
    }

}
