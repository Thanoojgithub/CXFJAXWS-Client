package com.cxfjaxws.vo;

import java.math.BigInteger;

public class EmployeeVo {

	protected BigInteger id;
	protected String firstname;
	protected String lastname;

	public EmployeeVo(BigInteger id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "EmployeeVo [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}

}
