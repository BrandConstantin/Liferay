package com.liferay.university.command;

import com.liferay.university.hello.api.HelloService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;
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
	
	@Reference(policy=ReferencePolicy.DYNAMIC, 
			policyOption=ReferencePolicyOption.GREEDY,
			cardinality=ReferenceCardinality.MANDATORY) 
	protected void setHelloService(HelloService helloService) {
		System.out.println("Setting helloService " + helloService.getClass().getName());
		this.helloService = helloService;
	}
	
	protected void unsetHelloService(HelloService helloService) {
		System.out.println("Unsetting helloService " + helloService.getClass().getName());
		if(helloService == this.helloService) {
			this.helloService = null;
		}
	}
	
	private HelloService helloService;
}