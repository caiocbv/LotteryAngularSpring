package br.com.oragens.lottery.models.services;

import java.util.ArrayList;

import br.com.oragens.lottery.models.Aposta;
import br.com.oragens.lottery.models.Pessoa;

public interface IApostaService {
	public ArrayList<Integer> sortearNumeros();
	public void criarAposta(Pessoa pessoa, ArrayList<Integer> numeros);
	public ArrayList<Aposta> findByPerson(Pessoa pessoa);
}

