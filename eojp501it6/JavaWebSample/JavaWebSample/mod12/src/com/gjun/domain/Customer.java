package com.gjun.domain;
//Java Bean
public class Customer implements java.io.Serializable {
	//封裝欄位
	private short customerId;
	private String firstName;
	private String lastName;
	private String email;
	public short getCustomerId() {
		return customerId;
	}
	public void setCustomerId(short customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("客戶編號:%s FirstName:%s", customerId,firstName);
	}
	

}
