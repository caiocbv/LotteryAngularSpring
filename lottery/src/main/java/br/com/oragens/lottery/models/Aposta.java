package br.com.oragens.lottery.models;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cascade;

import com.sun.istack.NotNull;

//Imports...

@Entity
public class Aposta {
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Pessoa pessoa;
	
	@NotEmpty
	@NotNull
	private ArrayList<Integer> jogo;

//Getters and Setters...
	
	public Aposta(Pessoa pessoa2, ArrayList<Integer> jogo) {
		this.pessoa = pessoa2;
		this.jogo = jogo;
	}
	public Aposta() {
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public ArrayList<Integer> getJogo() {
		return jogo;
	}

	public void setJogo(ArrayList<Integer> jogo) {
		this.jogo = jogo;
	}
	
	
}
