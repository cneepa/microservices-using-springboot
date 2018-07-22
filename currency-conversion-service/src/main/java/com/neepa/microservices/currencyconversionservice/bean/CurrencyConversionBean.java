package com.neepa.microservices.currencyconversionservice.bean;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionRate;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedmount;
	private int port;
	
	protected CurrencyConversionBean(){
		
	}
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionRate, BigDecimal quantity,
			BigDecimal totalCalculatedmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionRate = conversionRate;
		this.quantity = quantity;
		this.totalCalculatedmount = totalCalculatedmount;
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}	
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedmount() {
		return totalCalculatedmount;
	}
	public int getPort() {
		return port;
	}
	
	

}
