package services;

import java.util.List;

import domain.Aluno;
import domain.Pessoa;
import repository.Repository;
import services.excepctions.ObjectAlreadyExistsException;
import services.excepctions.ObjectNotFoundException;

public class PessoaService {

	Repository<Pessoa> repo = new Repository<>();

	public PessoaService() {
	}

	public void insert(Pessoa pessoa, AlunoService alunos) {
		boolean existeAluno = alreadyExistsAluno(pessoa, alunos);
		
		if (this.repo.findAll().contains(pessoa) || existeAluno) {
			Pessoa.geraId--;
			throw new ObjectAlreadyExistsException("\nErro, perfil já existente como um Pessoa ou Aluno.");
		} else {
			this.repo.insert(pessoa.getId(), pessoa);
		}
	}
	
	//Metodo que recebe uma pessoa e o service com todos os alunos, para comparar se a pessoa informada já está cadastrada como um Aluno
		public boolean alreadyExistsAluno(Pessoa pessoa, AlunoService alunos) {
			for(Aluno a: alunos.findAll()) {
				if(a.getTelefone().equals(pessoa.getTelefone())) {
					return true;
				}
			}
			
			return false;
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
			throw new ObjectNotFoundException("\nErro, perfil de pessoa não localizado.");
		}
	}
	
	public Pessoa findByTelefone(String telefone) {
		List<Pessoa> todosAlunos = findAll();
		return todosAlunos.stream().filter(n -> n.getTelefone().equals(telefone)).findAny()
				.orElse(null);
	}
}
