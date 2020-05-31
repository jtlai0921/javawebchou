package com.gjun.domain;

public class GjunCustomers implements java.io.Serializable{
	private Short customer_id;
	private String first_name;
	private String last_name;
	private String email;
	private Byte active;
	public Short getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Short customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String emai) {
		this.email = email;
	}
	public Byte getActive() {
		return active;
	}
	public void setActive(Byte active) {
		this.active = active;
	}
	

}
