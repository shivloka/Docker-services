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
	@Produces(MediaType.TEXT_HTML)
	@Path("/pingglassfish")
	public String pingGlassfishApp(){

		String response = createWebResource("http://glassfishapp:8081/GlassFishService/rest/glassfishService/glassfishOperation");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Glassfish App" + "</body></h1>" + "</html>";
	}

	@GET
	@Path("/pingspringbeans")
	@Produces(MediaType.TEXT_HTML)
	public String pingSpringBeans(){

		String response = createWebResource("http://springbeansapp:8081/SpringBeans/rest/springService/studentOperation");
		System.out.println(response);

		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Spring Beans App" + "</body></h1>" + "</html>";

	}

	@GET
	@Path("/pingspringintegration")
	@Produces(MediaType.TEXT_HTML)
	public String pingSpringIntegration(){

		String response = createWebResource("http://springintegrationapp:8081/Springintegration/sample");
		System.out.println(response);

		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Spring Integration App" + "</body></h1>" + "</html>";

	}

	@GET
	@Path("/pingservlet")
	@Produces(MediaType.TEXT_HTML)
	public String pingServlet(){

		WebResource servletResource = client.resource("http://servletapp:8080/BasicSample/inputSubmit.mailservlet");
		String input = "emailId=xyz%40gmail.com&subject=Apple+WebObjects+Framework&content=dsaf&button1=+Send+";
		ClientResponse response = servletResource.accept("application/xml").type("application/xml").post(ClientResponse.class, input);
		System.out.println(response);

		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Servlet App" + "</body></h1>" + "</html>";

	}

	@GET
	@Path("/pingrabbitmq")
	@Produces(MediaType.TEXT_HTML)
	public String pingRabbitMq(){

		String response = createWebResource("http://rabbitmqapp:8081/RabbitMQ/rest/rabbitMQService/rabbitmqOperation");
		System.out.println(response);

		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged Rabbit MQ App" + "</body></h1>" + "</html>";

	}


	@GET
	@Path("/pingjsf")
	@Produces(MediaType.TEXT_HTML)
	public String pingJsfApp(){

		String response = createWebResource("http://jsfapp:8080/JavaServerFaces/");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged JSF App" + "</body></h1>" + "</html>";

	}
	@GET
	@Path("/pingpostgresql")
	@Produces(MediaType.TEXT_HTML)
	public String pingPostgresql(){

		String response = createWebResource("http://postgresqlapp:8081/PostgresSQLService/rest/postgressqlService/postgressqlOperation");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged PostGresql App" + "</body></h1>" + "</html>";

	}
	
	@GET
	@Path("/pingmysql")
	@Produces(MediaType.TEXT_HTML)
	public String pingMysql(){

		String response = createWebResource("http://mysqlapp:8081/MySQLService/rest/mysqlService/mysqlOperation");
		System.out.println(response);
		return "<html> " + "<title>" + "Services Invoked" + "</title>"
		+ "<body><h1>" + "Pinged MySQL App" + "</body></h1>" + "</html>";

	}
	
}
