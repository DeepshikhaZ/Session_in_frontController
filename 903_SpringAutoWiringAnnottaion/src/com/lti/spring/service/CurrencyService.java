package com.lti.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyService implements ICrrencyService {
	//dependency which will be taken care by spring ioc
	@Autowired
private IExchangeService exchangeService;

	public CurrencyService() {

}
	public CurrencyService(IExchangeService exchangeService) {
	this.exchangeService = exchangeService;
}
	@Override
	public double dollarToRupee(double dollar) {
		// TODO Auto-generated method stub
		return exchangeService.getExchangeRate()*dollar;
	}
	public IExchangeService getExchangeService() {
		return exchangeService;
	}
	public void setExchangeService(IExchangeService exchangeService) {
		this.exchangeService = exchangeService;
	}
	

	
	

}
