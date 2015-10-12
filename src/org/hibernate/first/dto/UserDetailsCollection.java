package org.hibernate.first.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details_Collection")
public class UserDetailsCollection {
	@Id
	private int userId;
	private String userName;
	@ElementCollection
	private Set<AddressCollection> listOfAddress = new HashSet<AddressCollection>();
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
	public Set<AddressCollection> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<AddressCollection> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

}
