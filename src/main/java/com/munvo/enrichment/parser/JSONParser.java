package com.munvo.enrichment.parser;

import com.munvo.enrichment.model.Subscriber;

public class JSONParser implements FileReaderParser{
	private int ID;
	private String name, phoneNumber;

	public JSONParser(String subLine) {
		parseSubscriber(subLine);
	}
	
	@Override
	public Subscriber parseSubscriber(String subLine) {
		/*
		 * This method converts the passed line into a subscriber object, it gets the ID, name and phone number of each subscriber
		 * by getting the text between a colon and a comma.
		 */
		int firstColon = subLine.indexOf(':');
		int secondColon = subLine.indexOf(':', firstColon+1);
		int thirdColon = subLine.indexOf(':', secondColon+1);
		int firstComma = subLine.indexOf(',');
		int secondComma = subLine.indexOf(',', firstComma+1);
		int endOfString = subLine.length()-1;
		
		ID = Integer.parseInt(subLine.substring(firstColon+2, firstComma));
		name = subLine.substring(secondColon+2, secondComma).replace("\"", "");
		phoneNumber = subLine.substring(thirdColon+2, endOfString).replace("\"", "");
		
		return new Subscriber(ID,name,phoneNumber);
	}

}
