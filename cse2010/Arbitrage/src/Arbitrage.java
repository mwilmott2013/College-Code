/*
 * Author:  Matthew Wilmott, mwilmott2013@my.fit.edu
 * Course:  CSE 2010, Section 02, Fall 2015
 * Project: Lab 7
 */

import java.util.LinkedList;

public class Arbitrage {
	
	private String currencyFrom;
	private double cost;
	private LinkedList<String> links; // has to start with currencyFrom, path 
									  // through currencyTo and end in currencyFrom
	
	
	public double getCost(){
		return cost;
	}
	
	public LinkedList<String> getLinks(){
		return links;
	}
	
	public Arbitrage(String currencyFrom_, double cost_){
		currencyFrom = currencyFrom_;
		cost = cost_;
		links = new LinkedList<String>();
	}
	
	public void addLink(String link) {
		links.add(link);
	}
	
	
	public boolean isRealArbitrage(){
		boolean isArbitrage = (links.getFirst()==currencyFrom) &&
					(links.getLast() == currencyFrom);
		
		
		isArbitrage = isArbitrage && (cost >1);
		isArbitrage = isArbitrage && (links.size() > 2);
		
		return isArbitrage;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("Arbitrage from : " + currencyFrom );
		sb.append(" Cost: " + cost+"\n");
		sb.append(links.toString());
		
		
		return new String(sb);
	}

}

