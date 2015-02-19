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
		String glassfishResponse = null, springbeansResponse = null, springIntegrationResponse = null, servletResponse = null, 
		  jsfResponse = null, mysqlResponse = null, rabbitmqResponse = null, postgresqlResponse = null;
		//jbossHornetQResponse = null,  jbossMqResponse = null, 
		for(int counter = 0; counter < 5; counter++){
		
		glassfishResponse = loadGen.pingGlassfishApp();
		springbeansResponse = loadGen.pingSpringBeans();
		springIntegrationResponse = loadGen.pingSpringIntegration();
		rabbitmqResponse = loadGen.pingRabbitMq();
		jsfResponse = loadGen.pingJsfApp();
		servletResponse = loadGen.pingServlet();
		mysqlResponse = loadGen.pingMysql();
		postgresqlResponse = loadGen.pingPostgresql();
		
		}
		System.out.println(glassfishResponse + springbeansResponse + springIntegrationResponse +
			mysqlResponse  + jsfResponse + servletResponse + rabbitmqResponse + postgresqlResponse);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged All Applications" + "</body></h1>" + "</html>";
	}	
}
