package com.sullivan.wildflyexample;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.annotations.Api;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
@Api(value = "hello world")
public class MyApplication extends Application
{

	@Override
	public Set<Class<?>> getClasses()
	{
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.0");
		beanConfig.setBasePath("api");
		beanConfig.setResourcePackage("com.sullivan.wildflyexample");
		beanConfig.setScan(true);

		Set<Class<?>> resources = new HashSet<>();

		return resources;
	}

}