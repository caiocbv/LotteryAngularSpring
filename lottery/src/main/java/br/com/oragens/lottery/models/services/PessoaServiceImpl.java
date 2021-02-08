package br.com.oragens.lottery.models.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import antlr.collections.List;
import br.com.oragens.lottery.models.Pessoa;
import br.com.oragens.lottery.models.repositories.IApostaRepositories;
import br.com.oragens.lottery.models.repositories.IPessoaRepositories;

@Service
public class PessoaServiceImpl implements IPessoaService{
	
	@Autowired
	private IPessoaRepositories pessoaRepositories;
	
	//Create Person by Email
	public Pessoa createPersonByEmail(String email) {
		Pessoa pessoa = findByEmail(email);
		if(pessoa == null) {
			pessoa = new Pessoa(email);
		}
		return pessoa;
	}
	
	//Find by email
	public Pessoa findByEmail(String email) {
		
		Iterable<Pessoa> peopleFound =  this.pessoaRepositories.findByEmail(email);
		if(peopleFound == null) {
			return null;
		}else {
			
			java.util.List<Pessoa> list = new ArrayList();
			for(Pessoa person : peopleFound) {
				list.add(person);
			}
			
			if(list.size() == 0) {
				return null;
			}
			return list.get(0);
		}
		
	}
}
