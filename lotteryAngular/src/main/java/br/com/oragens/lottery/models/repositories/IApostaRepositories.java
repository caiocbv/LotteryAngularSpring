package br.com.oragens.lottery.models.repositories;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.oragens.lottery.models.Aposta;
import br.com.oragens.lottery.models.Pessoa;

@Repository
public interface IApostaRepositories extends CrudRepository<Aposta, Integer>{
	public ArrayList<Aposta> findByPessoa(Pessoa pessoa);

}


