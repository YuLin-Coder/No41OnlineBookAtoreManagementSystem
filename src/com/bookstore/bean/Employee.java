package com.bookstore.bean;

import java.util.Date;

public class Employee {
	private int empId;
	private String empName;
	private int empAge;
	private Date empBtd;
	private int empSex;
	private int isDelete;
	public Employee() {
		super();
	}
	public Employee(int empId, String empName, int empAge, Date empBtd,
			int empSex, int isDelete) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empBtd = empBtd;
		this.empSex = empSex;
		this.isDelete = isDelete;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public Date getEmpBtd() {
		return empBtd;
	}
	public void setEmpBtd(Date empBtd) {
		this.empBtd = empBtd;
	}
	public int getEmpSex() {
		return empSex;
	}
	public void setEmpSex(int empSex) {
		this.empSex = empSex;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	@Override
	public String toString() {
		return "Employee [empAge=" + empAge + ", empBtd=" + empBtd + ", empId="
				+ empId + ", empName=" + empName + ", empSex=" + empSex
				+ ", isDelete=" + isDelete + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empAge;
		result = prime * result + ((empBtd == null) ? 0 : empBtd.hashCode());
		result = prime * result + empId;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + empSex;
		result = prime * result + isDelete;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empAge != other.empAge)
			return false;
		if (empBtd == null) {
			if (other.empBtd != null)
				return false;
		} else if (!empBtd.equals(other.empBtd))
			return false;
		if (empId != other.empId)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empSex != other.empSex)
			return false;
		if (isDelete != other.isDelete)
			return false;
		return true;
	}
}
