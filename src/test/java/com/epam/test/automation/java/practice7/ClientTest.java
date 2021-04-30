package com.epam.test.automation.java.practice7;

import org.testng.annotations.Test;
import java.math.BigDecimal;
import static org.testng.Assert.*;

public class ClientTest {
    BaseDeposit bd1 = new BaseDeposit(BigDecimal.valueOf(3000), 1);
    BaseDeposit bd2 = new BaseDeposit(BigDecimal.valueOf(3000), 6);
    BaseDeposit bd3 = new BaseDeposit(BigDecimal.valueOf(1000), 3);
    LongDeposit ld1 = new LongDeposit(BigDecimal.valueOf(1000), 2);
    LongDeposit ld2 = new LongDeposit(BigDecimal.valueOf(1000), 9);
    SpecialDeposit sd1 = new SpecialDeposit(BigDecimal.valueOf(1000), 3);

    Client deposits = new Client();

    @Test
    public void testAddDeposit1() {
        boolean actual = deposits.addDeposit(bd1);
        boolean expected = true;
        assertEquals(actual, expected);

    }
    @Test
    public void testAddDeposit10() {
        deposits.addDeposit(bd1);
        deposits.addDeposit(bd2);
        deposits.addDeposit(bd3);
        deposits.addDeposit(bd1);
        deposits.addDeposit(bd2);
        deposits.addDeposit(bd3);
        deposits.addDeposit(ld1);
        deposits.addDeposit(ld2);
        deposits.addDeposit(sd1);
        boolean actual = deposits.addDeposit(sd1);
        boolean expected = true;
        assertEquals(actual, expected);
    }
    @Test
    public void testAddDeposit11() {
        deposits.addDeposit(bd1);
        deposits.addDeposit(bd2);
        deposits.addDeposit(bd3);
        deposits.addDeposit(bd1);
        deposits.addDeposit(bd2);
        deposits.addDeposit(bd3);
        deposits.addDeposit(ld1);
        deposits.addDeposit(ld2);
        deposits.addDeposit(sd1);
        deposits.addDeposit(sd1);
        boolean addDep11 = deposits.addDeposit(bd1);
        boolean expected = false;
        assertEquals(addDep11, expected);

    }

    @Test
    public void testTotalIncome() {
        deposits.addDeposit(bd1);
        deposits.addDeposit(bd2);
        deposits.addDeposit(bd3);
        deposits.addDeposit(ld1);
        deposits.addDeposit(ld2);
        deposits.addDeposit(sd1);
        BigDecimal actual = deposits.totalIncome();
        BigDecimal expected = new BigDecimal("1909.90");
        assertEquals(actual, expected);
    }

    @Test
    public void testMaxIncome() {
        deposits.addDeposit(bd1);
        deposits.addDeposit(bd2);
        deposits.addDeposit(bd3);
        deposits.addDeposit(ld1);
        deposits.addDeposit(ld2);
        deposits.addDeposit(sd1);
        BigDecimal actual = deposits.maxIncome();
        BigDecimal expected = new BigDecimal("1020.29");
        assertEquals(actual, expected);
    }

    @Test
    public void testGetIncomeByNumber1() {
        deposits.addDeposit(bd1);
        deposits.addDeposit(bd2);
        deposits.addDeposit(bd3);
        deposits.addDeposit(ld1);
        deposits.addDeposit(ld2);
        deposits.addDeposit(sd1);
        BigDecimal actual = deposits.getIncomeByNumber(3);
        BigDecimal expected = new BigDecimal("0");
        assertEquals(actual, expected);
    }

    @Test
    public void testGetIncomeByNumber2() {
        deposits.addDeposit(bd1);
        deposits.addDeposit(bd2);
        deposits.addDeposit(bd3);
        deposits.addDeposit(ld1);
        deposits.addDeposit(ld2);
        deposits.addDeposit(sd1);
        BigDecimal actual = deposits.getIncomeByNumber(4);
        BigDecimal expected = new BigDecimal("520.88");
        assertEquals(actual, expected);
    }

    @Test
    public void testGetIncomeByNumberOutOfReach() {
        deposits.addDeposit(bd1);
        deposits.addDeposit(bd2);
        deposits.addDeposit(bd3);
        deposits.addDeposit(ld1);
        deposits.addDeposit(ld2);
        deposits.addDeposit(sd1);
        BigDecimal actual = deposits.getIncomeByNumber(13);
        BigDecimal expected = new BigDecimal("0");
        assertEquals(actual, expected);
    }

}
