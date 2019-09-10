package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.validation.Email;

//import com.luv2code.springdemo.mvc.validation.Email;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="is require")//we add (message="is require") in video 150 not from the begining
	@Size(min=1, message="is require")
	@Column(name="first_name")
	private String firstName;
	
	@NotNull(message="is require")//we add (message="is require") in video 150 not from the begining
	@Size(min=1, message="is require")
	@Column(name="last_name")
	private String lastName;
	
	@Email(value="@", message="must start with @")
	@Column(name="email")
	private String email;
	
	public Customer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
		
}





