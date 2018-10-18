package com.munvo.enrichment.parser;

import com.munvo.enrichment.model.Subscriber;

public class CSVParser implements FileReaderParser{
	private int ID;
	private String name, phoneNumber;

	public CSVParser(String subLine) {
		parseSubscriber(subLine);
	}
	
	@Override
	public Subscriber parseSubscriber(String subLine) {
		/*
		 * This method converts the passed line into a subscriber object, it gets the ID, name and phone number of each subscriber
		 * by getting the text between the commas.
		 */
		int firstComma = subLine.indexOf(',');
		int secondComma = subLine.indexOf(',', firstComma+1);
		int endOfString = subLine.length();
		
		ID = Integer.parseInt(subLine.substring(0, firstComma));
		name = subLine.substring(firstComma+1, secondComma).replace("\"", "");
		phoneNumber = subLine.substring(secondComma+1, endOfString).replace("\"", "");
		
		return new Subscriber(ID,name,phoneNumber);
	}

}
