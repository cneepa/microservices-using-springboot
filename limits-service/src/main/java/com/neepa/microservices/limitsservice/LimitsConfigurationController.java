package com.neepa.microservices.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neepa.microservices.limitsservice.bean.LimitsConfiguration;
import com.neepa.microservices.limitsservice.config.Configuration;

@RestController
public class LimitsConfigurationController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfiguration() {
		return new LimitsConfiguration(config.getMaximum(), config.getMinimum());
	}

}
