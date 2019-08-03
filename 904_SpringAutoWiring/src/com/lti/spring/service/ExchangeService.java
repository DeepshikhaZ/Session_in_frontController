package com.lti.spring.service;

public class ExchangeService implements IExchangeService {
public double exchangeRates;
	@Override
	public double getExchangeRate() {
		// TODO Auto-generated method stub
		return this.exchangeRates;
	}
	public double getExchangeRates() {
		return exchangeRates;
	}
	public void setExchangeRates(double exchangeRates) {
		this.exchangeRates = exchangeRates;
	}

}
