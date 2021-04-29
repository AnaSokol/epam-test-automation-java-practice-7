package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BaseDeposit extends Deposit{

    public BaseDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal depositedSum = super.getAmount();
        int period = super.getPeriod();
        BigDecimal baseAmount = depositedSum;
        BigDecimal endSum = depositedSum;
        BigDecimal monthlyIncome;
        BigDecimal interest = new BigDecimal(String.valueOf(0.05));
        for (int i = 0; i < period; i++){
            monthlyIncome = (baseAmount.multiply(interest)).setScale(2, RoundingMode.HALF_EVEN);
            endSum = baseAmount.add(monthlyIncome);
            baseAmount = endSum;
        }
        BigDecimal totalIncome = endSum.subtract(depositedSum);
        return totalIncome;
    }
}
