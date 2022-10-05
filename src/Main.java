import java.text.ParseException;
import java.text.SimpleDateFormat;

import configuracaoInicial.Configuracoes;
import services.AlunoService;
import services.PessoaService;

public class Main {

	public static void main(String[] args) throws ParseException {

		PessoaService pessoas = Configuracoes.geraPessoas();
		AlunoService alunos = Configuracoes.geraAlunos();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		pessoas.findAll().forEach(n -> System.out.println(n + "\n"));
	}

}
