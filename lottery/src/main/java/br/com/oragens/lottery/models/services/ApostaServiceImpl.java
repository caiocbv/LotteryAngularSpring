package br.com.oragens.lottery.models.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.oragens.lottery.models.Aposta;
import br.com.oragens.lottery.models.Pessoa;
import br.com.oragens.lottery.models.repositories.IApostaRepositories;

@Service
public class ApostaServiceImpl implements IApostaService{
	@Autowired
	private IApostaRepositories apostaRepositories;
	@Override
	public ArrayList<Integer> sortearNumeros(){
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		Random random = new Random();
		for(;numeros.size() < 6;) {
			Integer sorteado = random.ints(1,60).findFirst().getAsInt();
			if(!numeros.contains(sorteado)) {
				numeros.add(sorteado);
			}
		}
		 Collections.sort(numeros);
		return numeros;
	}
	@Override
	public void criarAposta(Pessoa pessoa, ArrayList<Integer> numeros) {
		Aposta aposta = new Aposta(pessoa, numeros);
		apostaRepositories.save(aposta);
	}
	@Override
	public ArrayList<Aposta> findByPerson(Pessoa pessoa) {
		Iterable<Aposta> apostasI = this.apostaRepositories.findByPessoa(pessoa);
		 ArrayList apostas = new ArrayList<Aposta>();
		 for(Aposta a : apostasI) {
			 apostas.add(a);
		 }
		return apostas;
	}	
}

