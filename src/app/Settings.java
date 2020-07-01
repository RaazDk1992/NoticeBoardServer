package app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/appsettings")
public class Settings {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String test(){
		
		return new objects.Settings().getSettings().toString();
	}

}
