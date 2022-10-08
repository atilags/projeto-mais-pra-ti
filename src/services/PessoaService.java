package services;

import java.util.List;

import domain.Pessoa;
import repository.Repository;
import services.excepctions.ObjectAlreadyExistsException;
import services.excepctions.ObjectNotFoundException;

public class PessoaService {

	Repository<Pessoa> repo = new Repository<>();

	public PessoaService() {
	}

	public void insert(Pessoa pessoa) {
		if (this.repo.findAll().contains(pessoa)) {
			Pessoa.geraId--;
			throw new ObjectAlreadyExistsException("Perfil de pessoa já existente.");
		} else {
			this.repo.insert(pessoa.getId(), pessoa);
		}
	}

	public List<Pessoa> findAll() {
		return this.repo.findAll();
	}

	//Foi feito o metodo findById para caso seja necessário, mas como não foi solicitado no projeto, ficará inativado.
	
//	public Pessoa findById(long id) {
//		if (this.repo.findById(id) != null) {
//			return repo.findById(id);
//		} else {
//			throw new ObjectNotFoundException("Perfil de pessoa não localizado.");
//		}
//	}

	public void update(Pessoa pessoa) {
		this.repo.update(pessoa.getId(), pessoa);
	}

	public void delete(Pessoa pessoa) {
		if(findAll().contains(pessoa)) {
			repo.delete(pessoa.getId());
		} else {
			throw new ObjectNotFoundException("Perfil de pessoa não localizado.");
		}
	}
	
	//Feito um método para localizar uma Pessoa pelo nome, porem como não foi solicitado no projeto, ficará inativado.
	
//	public Pessoa findByName(String nome) {
//		List<Pessoa> todosAlunos = findAll();
//		return todosAlunos.stream().filter(n -> n.getNome().equalsIgnoreCase(nome)).findFirst()
//				.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrado."));
//	}
}
