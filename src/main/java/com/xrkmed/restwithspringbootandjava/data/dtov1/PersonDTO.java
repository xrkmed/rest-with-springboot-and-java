package com.xrkmed.restwithspringbootandjava.data.dtov1;

import java.io.Serializable;
import java.util.Objects;

public class PersonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String firstName;
	private String lastName;
	private String gender;
	
	public PersonDTO() {
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setId(long id) {
		this.id = id;
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
		PersonDTO other = (PersonDTO) obj;
		return id == other.id;
	}
}
