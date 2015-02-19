package com.dockerservices.loadGen;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/do")
public class LoadGenerator {
	
	private AppLoadGenerator loadGen;
	public LoadGenerator(){
		this.loadGen = new AppLoadGenerator();
	}
	
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/generateLoad")
	public String generateLoad(){
		String activeMQResponse = null, strutsResponse = null, springRabbitMQResponse = null, wicketResponse = null, dwrResponse = null;
		for(int counter = 0; counter < 5; counter++){
		
		activeMQResponse = loadGen.pingActiveMQ();
		strutsResponse = loadGen.pingStrutsApp();
		//springRabbitMQResponse = loadGen.pingSpringRabbitMQ();
		//cassandraResponse = loadGen.pingCassandra();
		wicketResponse = loadGen.pingWicket();
		dwrResponse = loadGen.pingDWR();
		}
		System.out.println(activeMQResponse + strutsResponse + springRabbitMQResponse + wicketResponse + dwrResponse );
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged All Applications" + "</body></h1>" + "</html>";
	}	
}
