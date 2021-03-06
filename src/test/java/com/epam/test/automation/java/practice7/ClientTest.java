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
    public void testGetIncomeByNumber1() {
        BigDecimal actual = deposits.getIncomeByNumber(3);
        BigDecimal expected = new BigDecimal("0");
        assertEquals(actual, expected);
    }
    
    @Test
    public void testGetIncomeByNumberOutOfReach() {
        BigDecimal actual = deposits.getIncomeByNumber(13);
        BigDecimal expected = new BigDecimal("0");
        assertEquals(actual, expected);
    }

}
