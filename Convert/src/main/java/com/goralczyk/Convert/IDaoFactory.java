package com.goralczyk.Convert;

public interface IDaoFactory {
	
	void setSource(EDaoFactory source);
    Person getPersonByID(int id);
}
