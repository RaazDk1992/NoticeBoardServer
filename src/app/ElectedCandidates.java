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

import objects.ElectedCandidate;

@Path("/electedcandidates")

public class ElectedCandidates {

	@Context
	HttpServletRequest req;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String loadElectedCandidates() throws UnknownHostException{
		String response = null;
		String IpAddress = InetAddress.getLocalHost().getHostAddress();
		int Port = req.getServerPort();
		response = new ElectedCandidate().fetchCandidate(IpAddress, Port).toString();
		return response;
	}
}
