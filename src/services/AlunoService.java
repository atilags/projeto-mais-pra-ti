package services;

import java.util.List;

import domain.Aluno;
import repository.Repository;
import services.excepctions.ObjectAlreadyExistsException;
import services.excepctions.ObjectNotFoundException;

public class AlunoService {

	Repository<Aluno> repo = new Repository<>();

	public AlunoService() {
	}

	public void insert(Aluno aluno) {
		if (this.repo.findAll().contains(aluno)) {
			Aluno.geraId--;
			throw new ObjectAlreadyExistsException("Perfil de aluno já existente.");
		} else {
			this.repo.insert(aluno.getId(), aluno);
		}
	}

	public List<Aluno> findAll() {
		return this.repo.findAll();
	}

	public Aluno findById(long id) {
		if (this.repo.findById(id) != null) {
			return repo.findById(id);
		} else {
			throw new ObjectNotFoundException("Perfil de aluno não localizado.");
		}
	}

	public void update(Aluno aluno) {
		this.repo.update(aluno.getId(), aluno);

	}

	public void delete(long id) {
		Aluno aluno = findById(id);
		repo.delete(aluno.getId());
	}

	public Aluno findByName(String nome) {
		List<Aluno> todosAlunos = findAll();
		return todosAlunos.stream().filter(n -> n.getNome().equalsIgnoreCase(nome)).findFirst()
				.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado."));
	}
}
