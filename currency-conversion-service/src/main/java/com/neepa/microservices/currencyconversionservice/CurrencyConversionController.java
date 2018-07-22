package com.neepa.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.neepa.microservices.currencyconversionservice.bean.CurrencyConversionBean;
import com.neepa.microservices.currencyconversionservice.proxy.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currency-convert/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveCurrencyConversionBean(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> forEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}/", CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean response = forEntity.getBody();
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionRate(), quantity, quantity.multiply(response.getConversionRate()), response.getPort());
	}
	
	@GetMapping("/currency-convert-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean retrieveCurrencyConversionBeanFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionRate(), quantity, quantity.multiply(response.getConversionRate()), response.getPort());
	}
}
