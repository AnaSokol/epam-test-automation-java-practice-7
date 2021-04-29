package com.epam.test.automation.java.practice7;

import java.math.BigDecimal;

public class Client {
    public Deposit[] deposits;
    private int count;

    public Client (){
        this.deposits = new Deposit[10];
        count = 0;
    }
    public boolean addDeposit(Deposit deposit) {
        if (count < deposits.length && deposits[count] == null) {
            deposits[count] = deposit;
            count++;
            return true;
        }
        return false; //the deposits array is full
    }
    public BigDecimal totalIncome(){
        BigDecimal totalIncome = new BigDecimal("0");
        for (int i = 0; i < deposits.length; i++){
            if (deposits[i] == null) break;
            BigDecimal iDepositIncome = deposits[i].income();
            totalIncome = totalIncome.add(iDepositIncome);
        }
        return totalIncome;
    }
    public BigDecimal maxIncome (){
        BigDecimal maxIncome = deposits[0].income();
        for (int i = 1; i < deposits.length; i++) {
            if (deposits[i] == null) break;
            if (maxIncome.compareTo(deposits[i].income()) < 0) {
                maxIncome = deposits[i].income();
            }
        }
        return maxIncome;
    }
    public BigDecimal getIncomeByNumber (int number){
        if (number >= deposits.length || deposits[number] == null){
            return new BigDecimal("0");
        }
        return deposits[number].income();
    }

    public void print() {
        for (int i = 0; i < deposits.length; i++) {
            System.out.println("Deposit "+(i+1)+":"+
                    deposits[i]);
        }
    }
}
