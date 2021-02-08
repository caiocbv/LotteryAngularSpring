package br.com.oragens.lottery.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.oragens.lottery.models.Pessoa;

@Repository
public interface IPessoaRepositories extends CrudRepository<Pessoa, String> {
	public Iterable<Pessoa> findByEmail(String email);

}




