package app;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriBuilder;

import objects.Budget;

@Path("/budgetandplans")
public class BudgetAndPlan {
	
	@Context
	HttpServletRequest req;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String budget() throws UnknownHostException{
		
		String IPAddress =  InetAddress.getLocalHost().getHostAddress();
		int Port = req.getServerPort();
		return new Budget().fetchBudget(IPAddress, Port).toString();
		
	}

}
