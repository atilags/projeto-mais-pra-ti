package configuracaoInicial;

import java.text.ParseException;

import domain.Aluno;
import domain.Pessoa;
import services.AlunoService;
import services.PessoaService;
import util.Auxiliares;

public class Configuracoes {

	public static PessoaService geraPessoas() throws ParseException {
		PessoaService service = new PessoaService();

		Pessoa pessoa1 = new Pessoa("Frederico Pereira", "862411285", Auxiliares.sdfDiaMesAno.parse("01/12/1992"));

		Pessoa pessoa2 = new Pessoa("Carla Nogueira", "5514895518", Auxiliares.sdfDiaMesAno.parse("08/03/1998"));

		Pessoa pessoa3 = new Pessoa("Roberto de Ribiero", "231846158", Auxiliares.sdfDiaMesAno.parse("24/07/1986"));

		Pessoa pessoa4 = new Pessoa("Yasmim Kiwani", "213686215", Auxiliares.sdfDiaMesAno.parse("18/05/1996"));

		service.insert(pessoa1);
		service.insert(pessoa2);
		service.insert(pessoa3);
		service.insert(pessoa4);

		return service;
	}

	public static AlunoService geraAlunos() throws ParseException {
		AlunoService service = new AlunoService();

		Aluno aluno1 = new Aluno("Yago Cerqueira", "654659852", Auxiliares.sdfDiaMesAno.parse("19/10/2004"), 8.3);

		Aluno aluno2 = new Aluno("Danielle Queiroz", "137865378", Auxiliares.sdfDiaMesAno.parse("02/09/2003"), 7.8);

		Aluno aluno3 = new Aluno("Vanessa Rikus", "35464728", Auxiliares.sdfDiaMesAno.parse("10/01/2007"), 10.0);

		Aluno aluno4 = new Aluno("Lima da Silva", "26734786", Auxiliares.sdfDiaMesAno.parse("25/12/2000"), 4.9);

		service.insert(aluno1);
		service.insert(aluno2);
		service.insert(aluno3);
		service.insert(aluno4);
		
		return service;
	}
}
