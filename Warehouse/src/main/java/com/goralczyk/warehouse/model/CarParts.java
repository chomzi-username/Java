package com.goralczyk.warehouse.model;

import java.util.Date;

import com.goralczyk.warehouse.enumType.TypeOfBox;

public class CarParts {
	
	private String description;
	private Date date;
	private int numberOfSwitching;
	private int numberOfBox;
	private int priority;//1-3
	private TypeOfBox typeOfBox = TypeOfBox.CarParts;
	
	public CarParts(){
		
	}
	
	public CarParts(String description, Date date, int numberOfSwitching, int numberOfBox, int priority,
			TypeOfBox typeOfBox) {
		super();
		this.description = description;
		this.date = date;
		this.numberOfSwitching = numberOfSwitching;
		this.numberOfBox = numberOfBox;
		this.priority = priority;
		this.typeOfBox = typeOfBox;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNumberOfSwitching() {
		return numberOfSwitching;
	}
	public void setNumberOfSwitching(int numberOfSwitching) {
		this.numberOfSwitching = numberOfSwitching;
	}
	public int getNumberOfBox() {
		return numberOfBox;
	}
	public void setNumberOfBox(int numberOfBox) {
		this.numberOfBox = numberOfBox;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public TypeOfBox getTypeOfBox() {
		return typeOfBox;
	}
	public void setTypeOfBox(TypeOfBox typeOfBox) {
		this.typeOfBox = typeOfBox;
	}
	
	@Override
	public String toString() {
		return "CarParts [description=" + description + ", date=" + date + ", numberOfSwitching=" + numberOfSwitching
				+ ", numberOfBox=" + numberOfBox + ", priority=" + priority + ", typeOfBox=" + typeOfBox + "]";
	}
	
	

}
