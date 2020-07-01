package app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/newsfeed")
public class NewsFeed {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String loadNewsFeed(){
		
		
		return new objects.NewsFeed().fetchNewsFeed().toString();
	}

}
