package com.liferay.university.hello.impl;

import com.liferay.university.hello.api.HelloService;

import org.osgi.service.component.annotations.Component;

/**
 * @author BrandConstantin
 */
@Component(
	immediate = true,
	property = {
		// TODO enter required service properties
	},
	service = HelloService.class
)
public class HelloServiceImpl implements HelloService {

	@Override
	public String hello(String parameter) {
		return parameter ;
	}

}