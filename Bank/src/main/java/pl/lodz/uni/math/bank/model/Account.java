package pl.lodz.uni.math.bank.model;

public class Account {
	private String number;
	private Integer clientId;
	private String description;
	
	public Account(){
		
	}
	
	public Account(Integer clientId, String description){
		this.clientId = clientId;
		this.description = description;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
