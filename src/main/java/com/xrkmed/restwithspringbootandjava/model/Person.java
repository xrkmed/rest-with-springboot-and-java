package com.xrkmed.restwithspringbootandjava.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String firstName;
	private String lastName;
	private Address address;
	private String gender;
	
	public Person(long id, String firstName, String lastName, Address address, String gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.gender = gender;
	}
	public Person() {
	}
	

	public long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Address getAddress() {
		return address;
	}
	public String getGender() {
		return gender;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
	}
}
