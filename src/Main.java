import java.text.ParseException;
import java.util.Scanner;

import configuracaoInicial.Configuracoes;
import menus.Menus;
import services.AlunoService;
import services.PessoaService;

public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		PessoaService pessoas = Configuracoes.geraPessoas();
		AlunoService alunos = Configuracoes.geraAlunos();

		boolean continua = true;

		while (continua) {
			System.out.println("Selecione abaixo opção desejada." + 
		"\n1 - Inserir novo cadastro." + 
		"\n2 - Buscar todos os cadastros." + 
		"\n3 - Bucas todos os cadastros (Simplificado)" +
		"\n4 - Atualizar um cadastro." + 
		"\n5 - Deletar um cadastro." + 
		"\n6 - Encerrar programa.");
			
			int escolha = sc.nextInt();
			sc.nextLine();

			switch (escolha) {
			case 1:
				Menus.opcao1(sc, pessoas, alunos);
				break;
			case 2:
				Menus.opcao2(sc, pessoas, alunos);
				System.out.println();
				break;
			case 3:
				Menus.opcao3(sc, pessoas, alunos);
				System.out.println();
				break;
			case 4:
				Menus.opcao4(sc, pessoas, alunos);
				break;
			case 5:
				Menus.opcao5(sc, pessoas, alunos);
				break;
			case 6:
				continua = false;
				break;
			default:
				System.out.println("Foi digitado uma opção invalida.");
			}
			
			try {
				Thread.sleep(1500l);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Programa encerrado.");

		sc.close();
	}

}
