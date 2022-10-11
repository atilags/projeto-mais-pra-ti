package configuracaoInicial;

import java.text.ParseException;

import domain.Aluno;
import domain.Pessoa;
import services.AlunoService;
import services.PessoaService;
import util.Auxiliares;

public class Configuracoes {

	public static PessoaService geraPessoas(AlunoService alunos) throws ParseException {
		PessoaService service = new PessoaService();

		Pessoa pessoa1 = new Pessoa("Frederico Pereira", "86241128546", Auxiliares.sdfDiaMesAno.parse("01/12/1992"));

		Pessoa pessoa2 = new Pessoa("Carla Nogueira", "55148955181", Auxiliares.sdfDiaMesAno.parse("08/03/1998"));

		Pessoa pessoa3 = new Pessoa("Roberto de Ribiero", "23184615846", Auxiliares.sdfDiaMesAno.parse("24/07/1986"));

		Pessoa pessoa4 = new Pessoa("Yasmim Kiwani", "21368621559", Auxiliares.sdfDiaMesAno.parse("18/05/1996"));

		service.insert(pessoa1, alunos);
		service.insert(pessoa2, alunos);
		service.insert(pessoa3, alunos);
		service.insert(pessoa4, alunos);

		return service;
	}

	public static AlunoService geraAlunos(PessoaService pessoas) throws ParseException {
		AlunoService service = new AlunoService();

		Aluno aluno1 = new Aluno("Yago Cerqueira", "65465985224", Auxiliares.sdfDiaMesAno.parse("19/10/2004"), 8.3);

		Aluno aluno2 = new Aluno("Danielle Queiroz", "13786537887", Auxiliares.sdfDiaMesAno.parse("02/09/2003"), 7.8);

		Aluno aluno3 = new Aluno("Vanessa Rikus", "35464728157", Auxiliares.sdfDiaMesAno.parse("10/01/2007"), 10.0);

		Aluno aluno4 = new Aluno("Lima da Silva", "26734786184", Auxiliares.sdfDiaMesAno.parse("25/12/2000"), 4.9);

		service.insert(aluno1, pessoas);
		service.insert(aluno2, pessoas);
		service.insert(aluno3, pessoas);
		service.insert(aluno4, pessoas);
		
		return service;
	}
}
