package dev.claudioed;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/credit-policy")
public class CreditPolicyResource {

  private final CreditPolicyService creditPolicyService;

  public CreditPolicyResource(CreditPolicyService creditPolicyService) {
    this.creditPolicyService = creditPolicyService;
  }
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String check(LoanRequest request) {




    return "Hello from Quarkus REST";
  }
}
