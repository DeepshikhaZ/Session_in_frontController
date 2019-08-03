package com.lti.spring.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component(value="exchangeService")
public class ExchangeService implements IExchangeService {
	@Value(value="69.06")
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
