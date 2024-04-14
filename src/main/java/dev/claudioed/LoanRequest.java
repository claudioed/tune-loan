package dev.claudioed;

import java.util.List;

public class LoanRequest {

  public Applicant applicant;

  public MonetaryAmount amount;

  public List<Collateral> collaterals;

  private int termInYears;

  private double annualInterestRate;

}
