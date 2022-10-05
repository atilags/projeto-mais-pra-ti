package configuracaoInicial;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import domain.Aluno;
import domain.Pessoa;
import services.AlunoService;
import services.PessoaService;

public class Configuracoes {

	private PessoaService pessoas;
	private AlunoService alunos;

	SimpleDateFormat sdfIdade = new SimpleDateFormat("dd/MM/yyyy");

	public Configuracoes() throws ParseException {
		geraPessoas();
		geraAlunos();
	}

	public PessoaService getPessoas() {
		return pessoas;
	}

	public AlunoService getAlunos() {
		return alunos;
	}

	public void geraPessoas() throws ParseException {
		PessoaService service = new PessoaService();

		Pessoa pessoa1 = new Pessoa("Frederico Pereira", "862411285", sdfIdade.parse("01/12/1992"));

		Pessoa pessoa2 = new Pessoa("Carla Nogueira", "5514895518", sdfIdade.parse("08/03/1998"));

		Pessoa pessoa3 = new Pessoa("Roberto de Ribiero", "231846158", sdfIdade.parse("24/07/1986"));

		Pessoa pessoa4 = new Pessoa("Yasmim Kiwani", "213686215", sdfIdade.parse("18/05/1996"));

		service.insert(pessoa1);
		service.insert(pessoa2);
		service.insert(pessoa3);
		service.insert(pessoa4);
		this.pessoas = service;
	}

	public void geraAlunos() throws ParseException {
		AlunoService service = new AlunoService();

		Aluno aluno1 = new Aluno("Yago Cerqueira", "654659852", sdfIdade.parse("19/10/2004"), 8.3);

		Aluno aluno2 = new Aluno("Danielle Queiroz", "137865378", sdfIdade.parse("02/09/2003"), 7.8);

		Aluno aluno3 = new Aluno("Vanessa Rikus", "35464728", sdfIdade.parse("10/01/2007"), 10.0);

		Aluno aluno4 = new Aluno("Lima da Silva", "26734786", sdfIdade.parse("25/12/2000"), 4.9);

		service.insert(aluno1);
		service.insert(aluno2);
		service.insert(aluno3);
		service.insert(aluno4);
		this.alunos = service;
	}
}
