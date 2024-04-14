package dev.claudioed;

import java.math.BigDecimal;

public class Collateral {

  public String type;

  public MonetaryAmount value;

  public String name;

  public BigDecimal amount(){
    return new BigDecimal(this.value.value);
  }

}
