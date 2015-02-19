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
	@Path("/pingactivemq")
	@Produces(MediaType.TEXT_HTML)
	public String pingActiveMQ(){

		String response = createWebResource("http://activemqapp:8081/activemq/rest/activeMQService/activemqOperation");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged ActiveMQ App" + "</body></h1>" + "</html>";
	}
	
	@GET
	@Path("/pingstruts")
	@Produces(MediaType.TEXT_HTML)
	public String pingStrutsApp(){
		
		String response = createWebResource("http://strutsapp:8081/Struts2Example/User/login.action");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Struts App" + "</body></h1>" + "</html>";
	}
	
	
	@GET
	@Path("/pingwicket")
	@Produces(MediaType.TEXT_HTML)
	public String pingWicket(){

		String response = createWebResource("http://wicketapp:8081/EmployerInfoService/EmployerServlet");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Wicket App" + "</body></h1>" + "</html>";
	}	
	
	/*@GET
	@Path("/pingspringrabbitmq")
	@Produces(MediaType.TEXT_HTML)
	public String pingSpringRabbitMQ(){

		String response = createWebResource("http://springrabbitmqapp:8081/SpringRabbitMQ/rest/rabbitmq/rabbitmqOperation");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Spring Rabbit MQ App" + "</body></h1>" + "</html>";
	}*/
	
	@GET
	@Path("/pingdwr")
	@Produces(MediaType.TEXT_HTML)
	public String pingDWR(){

		String response = createWebResource("http://dwrapp:8081/dwrHelloWorld/dwr/");
		String response2 = createWebResource("http://dwrapp:8081/dwrHelloWorld/");
		System.out.println(response);
		System.out.println(response2);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged DWR App" + "</body></h1>" + "</html>";
	}
}
