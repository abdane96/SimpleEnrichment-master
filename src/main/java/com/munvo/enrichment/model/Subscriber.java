package com.munvo.enrichment.model;

import com.munvo.enrichment.parser.FileReaderParser;

public class Subscriber implements FileReaderParser{

    private int id;
    private String name;
    private String phone;
    
    public Subscriber(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

	@Override
	public Subscriber parseSubscriber(String subLine) {
		// TODO Auto-generated method stub
		return null;
	}

}