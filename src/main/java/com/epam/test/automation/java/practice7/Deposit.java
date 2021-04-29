package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;

public abstract class Deposit {
    public BigDecimal amount;
    public int period;

    public Deposit (BigDecimal depositAmount,int depositPeriod){
        amount = depositAmount;
        period = depositPeriod;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public abstract BigDecimal income ();
}