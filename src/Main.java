import java.text.ParseException;
import java.util.Scanner;

import configuracaoInicial.Configuracoes;
import menus.Menus;
import services.AlunoService;
import services.PessoaService;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			PessoaService pessoas = new PessoaService();
			AlunoService alunos = new AlunoService();
			pessoas = Configuracoes.geraPessoas(alunos);
			alunos = Configuracoes.geraAlunos(pessoas);

			boolean continua = true;

			while (continua) {
				System.out.println("Selecione abaixo a opção desejada." + "\n1 - Inserir novo cadastro."
						+ "\n2 - Buscar todos os cadastros." + "\n3 - Atualizar um cadastro."
						+ "\n4 - Deletar um cadastro." + "\n5 - Encerrar programa.");

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
					break;
				case 4:
					Menus.opcao4(sc, pessoas, alunos);
					break;
				case 5:
					continua = false;
					break;
				default:
					System.out.println("Foi digitado uma opção invalida.");
				}

				Thread.sleep(1500l);
			}

			System.out.println("Programa encerrado.");
		} catch (InterruptedException e) {
			System.out.println("Erro na Thread.sleep: " + e.getMessage());
		} catch (ParseException e) {
			System.out.println("Uma data foi inserida incorretamente nas configurações.");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Não foi possivel inserir o celular, tamanho incorreto.");
		} finally {
			sc.close();
		}
	}
}
