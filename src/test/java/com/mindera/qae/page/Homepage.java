package com.mindera.qae.page;

import com.mindera.qae.component.Table;
import org.testng.annotations.Test;

public class Homepage extends BasePage {

    private final Table table;

    Homepage() {
          this.table = new Table();
    }

    public Table getTable() {
        return table;
    }

    @Override
    public void assertIntegrity() {
        super.assertIntegrity();
        table.assertIntegrity();
    }

}

