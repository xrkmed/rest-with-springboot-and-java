package com.xrkmed.restwithspringbootandjava.data.dtov1;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"id", "firstName", "lastName", "gender"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Mapping("id")
	private long key;
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
	public void setKey(long key) {
		this.key = key;
	}
	public long getId() {
		return key;
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
		return Objects.hash(key);
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
		return key == other.key;
	}
}
