package model;

import java.time.LocalDate;

public class Employee {
	
	private String firstname; 
	private String lastname;
	private String email; 
	private String occupation; 
	private LocalDate hiringDate;
	
	public Employee(String firstname, String lastname, String email, String occupation, LocalDate hiringDate) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.occupation = occupation;
		this.hiringDate = hiringDate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public LocalDate getHiringDate() {
		return hiringDate;
	}
	public void setHiringDate(LocalDate hiringDate) {
		this.hiringDate = hiringDate;
	}
	
}
