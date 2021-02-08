package br.com.oragens.lottery.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

//Imports...

@Entity
public class Pessoa {
	
	@Id	
	@Email(message = "Email should be valid", regexp = ".+@.+\\..+")
	@NotEmpty(message = "Please enter email")
	String email;

	public Pessoa(String email) {
		this.email = email;
	}
	public Pessoa() {}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	};
	
	
	
	
}
