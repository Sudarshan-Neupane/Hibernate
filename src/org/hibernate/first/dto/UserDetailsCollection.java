package org.hibernate.first.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_details_Collection")
public class UserDetailsCollection {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	@ElementCollection
	@JoinTable(name ="user_address",
	joinColumns=@JoinColumn(name="userId")
			)
//	@GenericGenerator(name="hilo-gen",strategy="hilo")
//	@CollectionId(columns={@Column(name="ADDRESS_ID")},generator="hilo-gen",type=@Type(type="long"))
	private Collection<AddressCollection> listOfAddress = new ArrayList<AddressCollection>();
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
	public Collection<AddressCollection> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(Set<AddressCollection> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

}
