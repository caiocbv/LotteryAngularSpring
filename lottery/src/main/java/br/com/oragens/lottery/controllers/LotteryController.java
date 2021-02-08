package br.com.oragens.lottery.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.oragens.lottery.models.Aposta;
import br.com.oragens.lottery.models.Pessoa;
import br.com.oragens.lottery.models.services.IApostaService;
import br.com.oragens.lottery.models.services.IPessoaService;
//Imports..
@CrossOrigin
@RestController
public class LotteryController {

	@Autowired
	private IApostaService apostaService;
	@Autowired
	private IPessoaService pessoaService;
	  
	@PostMapping
	public ArrayList<Integer> sortearNumeros(@RequestBody  String email) {
		ArrayList<Integer> numeros = apostaService.sortearNumeros();
		Pessoa pessoa = pessoaService.findByEmail(email);
		if(pessoa == null) {				
			pessoa = pessoaService.createPersonByEmail(email);
		}
		apostaService.criarAposta(pessoa, numeros);
		return numeros;
	}
	@GetMapping
	public ArrayList<ArrayList<Integer>> findByEmail( String email){
		Pessoa pessoa = this.pessoaService.findByEmail(email);
		ArrayList<Aposta> apostas = this.apostaService.findByPerson(pessoa);
		ArrayList<ArrayList<Integer>> jogos = new ArrayList<ArrayList<Integer>>();
		
		for(Aposta aposta : apostas) {
			jogos.add(aposta.getJogo());
		}
		
		return jogos;
	}
}



//
