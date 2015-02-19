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
		String angularJSResponse = null, javaMailResponse = null, jbossResponse = null, mongoResponse = null, tomcatResponse = null
				, luceneResponse = null;
		for(int counter = 0; counter < 5; counter++){
		
		angularJSResponse = loadGen.pingAngularJSApp();
		javaMailResponse = loadGen.pingJavaMailApp();
		jbossResponse = loadGen.pingJbossApp();
		mongoResponse = loadGen.pingMongoApp();
		tomcatResponse = loadGen.pingTomcatApp();
		luceneResponse = loadGen.pingLuceneApp();
		}
		System.out.println(angularJSResponse + javaMailResponse + jbossResponse + mongoResponse + tomcatResponse + luceneResponse );
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged All Applications" + "</body></h1>" + "</html>";
	}	
}
