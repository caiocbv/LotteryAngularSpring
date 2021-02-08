package br.com.oragens.lottery.models.services;

import br.com.oragens.lottery.models.Pessoa;

public interface IPessoaService {
	public Pessoa createPersonByEmail(String email);
	public Pessoa findByEmail(String email);
}


