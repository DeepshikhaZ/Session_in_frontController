package com.lti.spring.service;

public class CurrencyService implements ICrrencyService {
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
