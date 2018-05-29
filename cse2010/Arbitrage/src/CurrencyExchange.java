/*
 * Author:  Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course:  CSE 2010, Section 02, Fall 2015
 * Project: Lab 7
 */

public class CurrencyExchange {
	private int totalCurrencies = 0;
	private Graph graph;
	
	public CurrencyExchange(int totalNumberCurrencies){
		// implement constructor
	}
	
	
	public void addExchange(String currencyFrom, String currencyTo,
			double price){
		// add a weighted edge from the currencyFrom to the currencyTo, 
		// if the edge exists, replace it if new price is larger.
		
	}
	
	public Graph getGraph(){
		return this.graph;
	}

	
	public Arbitrage findArbitrage(){
		// find arbitrage, if more than 1 cycle exists return arbitrage of 
		// the highest cost. If none cycles exist return null.
	}
	
}

