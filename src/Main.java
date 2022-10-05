import java.text.ParseException;
import java.text.SimpleDateFormat;

import configuracaoInicial.Configuracoes;
import services.AlunoService;
import services.PessoaService;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		Configuracoes config = new Configuracoes();
		
		PessoaService pessoas = config.getPessoas();
		AlunoService alunos = config.getAlunos();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
	}

}
