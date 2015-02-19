package com.dockerservices.loadGen;

import java.net.HttpURLConnection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


@Path("/land")
public class AppLoadGenerator {

	HttpURLConnection conn = null;
	Client client = Client.create();
	
	
	public String createWebResource(String url){
		WebResource resource = client.resource(url);
		ClientResponse response = resource.accept("application/xml").get(ClientResponse.class);
		return response.toString();
	}
	
	
	@GET
	@Path("/pingjavamail")
	@Produces(MediaType.TEXT_HTML)
	public String pingJavaMailApp(){

		String response = createWebResource("http://javamailapp:8081/JavaMail/mail");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged JavaMail App" + "</body></h1>" + "</html>";
	}
	
	@GET
	@Path("/pingmongo")
	@Produces(MediaType.TEXT_HTML)
	public String pingMongoApp(){
		
		String response = createWebResource("http://mongodbapp:8081/MongoDBService/rest/mongoDBService/mongoDBOperation");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Mongo App" + "</body></h1>" + "</html>";
	}
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainHello(){
		return "Services Invoked";
	}
	
	@GET
	@Path("/pingangular")
	@Produces(MediaType.TEXT_HTML)
	public String pingAngularJSApp(){
		
		String response = createWebResource("http://angularjsapp:8080/AngularSpringApp/cars/addCar/Tesla");
		System.out.println(response);

		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged AngularJS App" + "</body></h1>" + "</html>";
	}
	
	@GET
	@Path("/pinglucene")
	@Produces(MediaType.TEXT_HTML)
	public String pingLuceneApp(){

		String response = createWebResource("http://luceneapp:8081/LuceneServlet/MainServlet");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Lucene App" + "</body></h1>" + "</html>";
	}	
	
	@GET
	@Path("/pingtomcat")
	@Produces(MediaType.TEXT_HTML)
	public String pingTomcatApp(){

		String response = createWebResource("http://tomcatapp:8081/TomcatService/rest/tomcatService/tomcatOperation");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Tomcat App" + "</body></h1>" + "</html>";
	}	
	
	@GET
	@Path("/pingjboss")
	@Produces(MediaType.TEXT_HTML)
	public String pingJbossApp(){

		String response = createWebResource("http://jbossapp:8081/JbossSample/server/");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Jboss App" + "</body></h1>" + "</html>";
	}
	
}
