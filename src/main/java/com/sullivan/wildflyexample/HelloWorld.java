package com.sullivan.wildflyexample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/")
@Api(value = "Hello World Resource")
public class HelloWorld
{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "returns the string \"hello world\"")
	public String sayWorld()
	{
		return "hello world";
	}


	/**
	 * This method incorrectly indicates that it *consumes* application/json in the swagger-ui.
	 * It is robably an error in swagger-ui as the swagger.json file does not indicate a consuming media type.
	 * @return
	 */
	@Path("/breaking")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String breaksDeployment()
	{
		return "adding this method breaks deployment with a class not found error";
	}
	
	/*
	 * Uncommenting this method below will cause a deployment error:
	 * 
	 * Caused by: java.lang.NoClassDefFoundError: javax/validation/constraints/Size
      Caused by: java.lang.ClassNotFoundException: javax.validation.constraints.Size from [Module \"io.swagger:main\" from BootModuleLoader@687080dc for finders [BootstrapClasspathModuleFinder, BootstrapModuleFinder(org.wildfly.swarm.bootstrap:main), ClasspathModuleFinder, ApplicationModuleFinder(swarm.application:main)]]"}}
      at org.wildfly.swarm.container.runtime.RuntimeDeployer.deploy(RuntimeDeployer.java:128)
      at org.wildfly.swarm.container.Container.deploy(Container.java:317)
      at org.wildfly.swarm.container.Container.deploy(Container.java:301)
      at org.wildfly.swarm.Swarm.simpleMain(Swarm.java:73)
      at org.wildfly.swarm.Swarm.main(Swarm.java:65)
      ... 7 more
	 */
	/*
	 * @Path("/echo")
	 * 
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String echo(@PathParam("input")
	 * String input) { return input; }
	 */

}