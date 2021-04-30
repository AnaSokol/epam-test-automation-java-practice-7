package com.epam.test.automation.java.practice7;

import org.testng.annotations.Test;
import java.math.BigDecimal;
import static org.testng.Assert.*;

public class BaseDepositTest {

    @org.testng.annotations.Test
    public void testIncome1() {
        BigDecimal baseAmount = new BigDecimal("1000");
        int period = 1;
        BaseDeposit baseDep = new BaseDeposit(baseAmount, period);
        BigDecimal income = baseDep.income();
        BigDecimal expected = new BigDecimal("50.00");
        assertEquals(income, expected);
    }

    @Test
    public void testIncome2() {
        BigDecimal baseAmount = new BigDecimal("1000");
        BaseDeposit baseDep = new BaseDeposit(baseAmount, 2);
        BigDecimal income = baseDep.income();
        BigDecimal expected = new BigDecimal("102.50");
        assertEquals(income, expected);
    }

    @Test
    public void testIncome3() {
        BigDecimal baseAmount = new BigDecimal("1000");
        BaseDeposit baseDep = new BaseDeposit(baseAmount, 3);
        BigDecimal income = baseDep.income();
        BigDecimal expected = new BigDecimal("157.62");
        assertEquals(income, expected);
    }
}