package com.epam.test.automation.java.practice7;

import org.testng.annotations.Test;

import java.math.BigDecimal;

import static org.testng.Assert.*;

public class SpecialDepositTest {
    BigDecimal baseAmount = new BigDecimal("1000.00");

    @Test
    public void testIncome1() {
        BigDecimal expected = new BigDecimal("10.00");
        SpecialDeposit spDep = new SpecialDeposit (baseAmount, 1);
        BigDecimal income = spDep.income();
        assertEquals(income, expected);
    }

    @Test
    public void testIncome2() {
        BigDecimal expected = new BigDecimal("30.20");
        SpecialDeposit spDep = new SpecialDeposit (baseAmount, 2);
        BigDecimal income = spDep.income();
        assertEquals(income, expected);
    }

    @Test
    public void testIncome3() {
        BigDecimal expected = new BigDecimal("61.11");
        SpecialDeposit spDep = new SpecialDeposit (baseAmount, 3);
        BigDecimal income = spDep.income();
        assertEquals(income, expected);
    }
}