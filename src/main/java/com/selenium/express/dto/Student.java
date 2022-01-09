package com.selenium.express.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stuId;
	private String stuName;
	private String stuLastName;
	private String stuAddress;

   public Student(){
	
    }
	
	public Student(int stuId, String stuName, String stuLastName, String stuAddress) {

		this.stuId = stuId;
		this.stuName = stuName;
		this.stuLastName = stuLastName;
		this.stuAddress = stuAddress;
	}
	
	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuLastName() {
		return stuLastName;
	}

	public void setStuLastName(String stuLastName) {
		this.stuLastName = stuLastName;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuLastName=" + stuLastName + ", stuAddress="
				+ stuAddress + "]";
	}
}
