package org.hibernate.first.dto;

import javax.annotation.Generated;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="userDetails8")
public class UserDetails8 {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@Embedded
	@AttributeOverrides({ 
	@AttributeOverride(name="street",column=@Column(name="home_street")),
			@AttributeOverride(name="city",column=@Column(name="home_city")),
			@AttributeOverride(name="state",column=@Column(name="home_state")),
			@AttributeOverride(name="pincode",column=@Column(name="home_pincode"))
	})
	private Address address;
	
	@Embedded
	private Address officeAddress;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
}
