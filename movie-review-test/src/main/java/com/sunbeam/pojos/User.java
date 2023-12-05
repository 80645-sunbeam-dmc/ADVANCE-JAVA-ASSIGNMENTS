package com.sunbeam.pojos;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="users") 
public class User {

	@Id
	private int id; 
	@NotBlank
	@Column(name="first_name")
	private String firstName;
	@NotBlank
	@Column(name="last_name")
	private String lastName;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Pattern(regexp ="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,10}$")
	private String password;
	@NotBlank
	@Size(min =10,max = 10)
	private String mobile;
	@NotNull
	private Date birth;
	public User() {
		super();
	}
	public User(int id, @NotBlank String firstName, @NotBlank String lastName, @NotBlank @Email String email,
			@NotBlank @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,10}$") String password,
			@NotBlank @Size(min = 10, max = 10) String mobile, @NotNull Date birth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.birth = birth;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", mobile=" + mobile + ", birth=" + birth + "]";
	}
	
	
}
