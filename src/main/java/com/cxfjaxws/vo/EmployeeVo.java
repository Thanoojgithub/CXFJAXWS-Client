package com.cxfjaxws.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class EmployeeVo implements Serializable {

	private static final long serialVersionUID = 1L;

	protected BigInteger id;
	protected String firstName;
	protected String lastName;

	public EmployeeVo(BigInteger id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "EmployeeVo [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}
}