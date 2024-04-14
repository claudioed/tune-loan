package dev.claudioed;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;
import java.math.BigDecimal;

@ApplicationScoped
public class CreditPolicyService {

  @Tool("interest value at moment of the loan request")
  public BigDecimal interestRate(){
    return BigDecimal.TEN;
  }

}
