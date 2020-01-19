package com.liferay.university.hello.uppercase.impl;

import com.liferay.university.hello.api.HelloService;

import org.osgi.service.component.annotations.Component;

/**
 * @author BrandConstantin
 */
@Component(
	immediate = true,
	property = {
		"service.ranking:Integer=100"
	},
	service = HelloService.class
)
public class HelloUppercaseService implements HelloService {

	@Override
	public String hello(String parameter) {
		return parameter.toUpperCase();
	}

}