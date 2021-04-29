package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDeposit extends Deposit {

    public LongDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal monthlyIncome;
        int period = super.getPeriod();
        BigDecimal depositedSum = super.getAmount();
        BigDecimal baseAmount = depositedSum;
        BigDecimal endSum = depositedSum;

        for (int i = 0; i < period; i++){
            if (i > 5){
                BigDecimal interest = new BigDecimal(String.valueOf(0.15));
                monthlyIncome = (baseAmount.multiply(interest)).setScale(2, RoundingMode.HALF_DOWN);
                endSum = baseAmount.add(monthlyIncome);
                baseAmount = endSum;
            }
        }
        BigDecimal totalIncome = endSum.subtract(depositedSum).setScale(2);
        return totalIncome;
    }
}