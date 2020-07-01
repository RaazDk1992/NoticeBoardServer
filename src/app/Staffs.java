package app;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriBuilder;

import objects.Staff;
@Path("/staffs")

public class Staffs {
	@Context
	HttpServletRequest req;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String  loadStaffs() throws UnknownHostException{
		String Ip = InetAddress.getLocalHost().getHostAddress();
		int Port = req.getServerPort();
		return new Staff().fetchStaff(Ip, Port).toString();
	}
}
