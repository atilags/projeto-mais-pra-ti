package services;

import java.util.List;

import domain.Aluno;
import domain.Pessoa;
import repository.Repository;
import services.excepctions.ObjectAlreadyExistsException;
import services.excepctions.ObjectNotFoundException;

public class AlunoService {

	Repository<Aluno> repo = new Repository<>();

	public AlunoService() {
	}

	public void insert(Aluno aluno, PessoaService pessoas) {
		boolean existePessoa = alreadyExistsPessoa(aluno, pessoas);
				
		if (this.repo.findAll().contains(aluno) || existePessoa) {
			Aluno.geraId--;
			throw new ObjectAlreadyExistsException("\nErro, perfil já existente como um Aluno ou Pessoa.");
		} else {
			this.repo.insert(aluno.getId(), aluno);
		}
	}
	
	//Metodo que recebe um aluno e o service com todos as pessoas, para comparar se o aluno informado já está cadastrado como uma Pessoa
	public boolean alreadyExistsPessoa(Aluno aluno, PessoaService pessoas) {
		for(Pessoa p: pessoas.findAll()) {
			if(p.getTelefone().equals(aluno.getTelefone())) {
				return true;
			}
		}
		
		return false;
	}

	public List<Aluno> findAll() {
		return this.repo.findAll();
	}
	
	//Foi feito o metodo findById para caso seja necessário, mas como não foi solicitado no projeto, ficará inativado.

//	public Aluno findById(long id) {
//		if (this.repo.findById(id) != null) {
//			return repo.findById(id);
//		} else {
//			throw new ObjectNotFoundException("Perfil de aluno não localizado.");
//		}
//	}

	public void update(Aluno aluno) {
			this.repo.update(aluno.getId(), aluno);
	}

	public void delete(Aluno aluno) {
		if(findAll().contains(aluno)) {
			repo.delete(aluno.getId());
		} else {
			throw new ObjectNotFoundException("\nErro, perfil de aluno não localizado.");
		}
	}

	public Aluno findByTelefone(String telefone) {
		List<Aluno> todosAlunos = findAll();
		return todosAlunos.stream().filter(n -> n.getTelefone().equals(telefone)).findAny()
				.orElse(null);
	}
}
