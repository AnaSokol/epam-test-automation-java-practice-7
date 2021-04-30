package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit{

    public BaseDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

     @Override
    public BigDecimal income() {
        BigDecimal monthlyIncome;
        BigDecimal totalIncome = BigDecimal.ZERO;
        BigDecimal baseAmount = getAmount();
        int period = getPeriod();
        BigDecimal interest = BigDecimal.valueOf(0.05);
        for (int i = 0; i < period; i++){
            monthlyIncome = (baseAmount.multiply(interest));
            baseAmount = baseAmount.add(monthlyIncome);
            totalIncome = totalIncome.add(monthlyIncome);
        }
        return totalIncome.setScale(2, RoundingMode.HALF_EVEN);
    }
}
