package com.xrkmed.restwithspringbootandjava.model;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String street;
	private String district;
	private String city;
	private String state;
	private Long zipCode;
	
	public Address(String street, String district, String city, String state, Long zipCode) {
		this.street = street;
		this.district = district;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public Address() {
	}

	public String getStreet() {
		return street;
	}
	public String getDistrict() {
		return district;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public Long getZipCode() {
		return zipCode;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(city, district, state, street, zipCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(district, other.district)
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street)
				&& Objects.equals(zipCode, other.zipCode);
	}
}
