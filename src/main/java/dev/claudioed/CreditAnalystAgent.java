package dev.claudioed;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;

@RegisterAiService(tools = {CreditPolicyService.class})
public interface CreditAnalystAgent {

  @SystemMessage({
      "You are a credit analyst agent of a credit company named Tune Loan'. The old name of the company was 'Runners' you can use Runners and Tune loan in the same context.",
      "Before providing information about credit analysis, you MUST always check:",
      "check the interest rate at moment of the loan request",
      "loan request data",
      "calculate the collateral amount, it is very important to check the total amount of the loan request",
  })
  String chat(@MemoryId Object id, @UserMessage String userMessage);

}
