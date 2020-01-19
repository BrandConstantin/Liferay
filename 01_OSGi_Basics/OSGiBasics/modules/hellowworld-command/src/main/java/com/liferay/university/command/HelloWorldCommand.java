package com.liferay.university.command;

import com.liferay.university.hello.api.HelloService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
/**
 * @author BrandConstantin
 */
@Component(
	immediate = true,
	property = {
		"osgi.command.function=say",
		"osgi.command.scope=custom"
	},
	service = Object.class
)
public class HelloWorldCommand{
	
	public void say (String what) {
		System.out.println(helloService.hello(what));
	}
	
	@Reference 
	private HelloService helloService;
}