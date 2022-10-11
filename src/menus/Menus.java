package menus;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import domain.Aluno;
import domain.Pessoa;
import menus.excepctions.ObjectIsBlankException;
import services.AlunoService;
import services.PessoaService;
import services.excepctions.ObjectAlreadyExistsException;
import services.excepctions.ObjectNotFoundException;
import util.Auxiliares;

public class Menus {

	public static void opcao1(Scanner sc, PessoaService pessoas, AlunoService alunos) {
		System.out.println("\n=============================================");
		try {
			System.out.println("\n----- Sistema de cadastro -----");
			System.out.print("\nNome: ");
			String nome = sc.nextLine();
			
			if(nome.isBlank()) {
				throw new ObjectIsBlankException("Erro, o nome não foi inserido.");
			}
			
			System.out.print("Celular de contato, com DDD, (21xxxxxxxxx): ");
			String telefone = sc.nextLine();
			System.out.print("Informe sua data de nascimento no padrão dia/mês/ano: ");
			String nascimento = sc.nextLine();
			

			System.out.print("O usuario em questão terá uma nota? Digita 1 para sim e 2 para não: ");
			int escolha = sc.nextInt();
			sc.nextLine();

			if (escolha == 1) {
				System.out.print("Informe a nota final do Aluno (separado com virgula): ");
				double nota = sc.nextDouble();
				Aluno aluno = new Aluno(nome, telefone, Auxiliares.sdfDiaMesAno.parse(nascimento), nota);

				alunos.insert(aluno, pessoas);
				System.out.println("\nAluno criado com sucesso.");
			} else {
				Pessoa pessoa = new Pessoa(nome, telefone, Auxiliares.sdfDiaMesAno.parse(nascimento));

				pessoas.insert(pessoa, alunos);
				System.out.println("\nPessoa criada com sucesso.");
			}

			System.out.println("\n=============================================\n");
		} catch (ParseException e) {
			System.out.println("A data de nascimento foi digitada incorretamente.");
			System.out.println("\n=============================================\n");
		} catch (InputMismatchException e) {
			System.out.println("Algo foi digitado incorretamente.");
			sc.next();
			System.out.println("\n=============================================\n");
		} catch (ObjectAlreadyExistsException e) {
			System.out.println(e.getMessage());
			System.out.println("\n=============================================\n");
		} catch (NumberFormatException e) {
			System.out.println("O número de celular foi digitado incorretamente.");
			System.out.println("\n=============================================\n");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Não foi possivel inserir o celular, tamanho incorreto.");
		} catch (ObjectIsBlankException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void opcao2(Scanner sc, PessoaService pessoas, AlunoService alunos) {
		System.out.println("\n=============================================");

		System.out.println("\n----- Pessoas -----");
		if(pessoas.findAll().isEmpty()) {
			System.out.println("Nenhuma pessoa cadastrada no sistema.");
		} else {
			for (Pessoa p : pessoas.findAll()) {
				System.out.println(p);
			}			
		}

		System.out.println("\n----- Alunos -----");
		if(alunos.findAll().isEmpty()) {
			System.out.println("Nenhum aluno cadastrado no sistema.");
		} else {
			for (Aluno p : alunos.findAll()) {
				System.out.println(p);
			}			
		}

		System.out.println("\n=============================================");
	}

	public static void opcao3(Scanner sc, PessoaService pessoas, AlunoService alunos) {
		System.out.println("\n=============================================\n");

		try {
			System.out.print("Informe o telefone completo do perfil que deseja alterar: ");
			String telefone = sc.nextLine();

			Pessoa pessoa = pessoas.findByTelefone(telefone);
			Aluno aluno = alunos.findByTelefone(telefone);

			if (pessoa != null) {
				System.out.println(pessoa);
				System.out.println();

				boolean continua = true;

				while (continua) {
					System.out.println("----- Selecione a opção que deseja ser alterada -----" + "\n1 - Nome"
							+ "\n2 - Telefone" + "\n3 - Data de Nascimento" + "\n4 - Voltar ao menu principal");
					int escolha = sc.nextInt();
					sc.nextLine();

					switch (escolha) {
					case 1:
						System.out.print("Informe o novo nome da Pessoa: ");
						String newNome = sc.nextLine();
						
						if(newNome.isBlank()) {
							throw new ObjectIsBlankException("Erro, o nome não foi inserido.");
						}
						
						pessoa.setNome(newNome);
						pessoa.setUltimaAlteracaoPerfil(new Date());
						pessoas.update(pessoa);
						System.out.println("Atualização realizada com sucesso. \n");
						break;
					case 2:
						System.out.print("Informe o novo número de celular da Pessoa, com DDD, (21xxxxxxxxx): ");
						String newTelefone = sc.nextLine();

						if (pessoas.findByTelefone(newTelefone) == null && alunos.findByTelefone(newTelefone) == null) {
							pessoa.setTelefone(newTelefone);
							pessoa.setUltimaAlteracaoPerfil(new Date());
							pessoas.update(pessoa);
							System.out.println("Atualização realizada com sucesso. \n");
						} else {
							throw new ObjectAlreadyExistsException("Erro, celular já existente para outro perfil.");
						}
						break;
					case 3:
						System.out.print("Informe a nova data de nascimento no padrão dia/mês/ano (29/05/1995): ");
						String newNascimento = sc.nextLine();
						pessoa.setNascimento(Auxiliares.sdfDiaMesAno.parse(newNascimento));
						pessoa.setUltimaAlteracaoPerfil(new Date());
						pessoas.update(pessoa);
						System.out.println("Atualização realizada com sucesso. \n");
						break;
					case 4:
						continua = false;
						break;
					default:
						System.out.println("Foi digitado uma opção invalida, voltando ao menu principal.");
						System.out.println();
					}
				}

			} else if (aluno != null) {
				System.out.println(aluno);
				System.out.println();
				boolean continua = true;

				while (continua) {

					System.out.println("----- Selecione a opção que deseja ser alterada -----" + "\n1 - Nome"
							+ "\n2 - Telefone" + "\n3 - Data de Nascimento" + "\n4 - Nota Final"
							+ "\n5 - Voltar ao menu principal");
					int escolha = sc.nextInt();
					sc.nextLine();

					switch (escolha) {
					case 1:
						System.out.print("Informe o novo nome do Aluno: ");
						String newNome = sc.nextLine();
						
						if(newNome.isBlank()) {
							throw new ObjectIsBlankException("Erro, o nome não foi inserido.");
						}
						
						aluno.setNome(newNome);
						aluno.setUltimaAlteracaoPerfil(new Date());
						alunos.update(aluno);
						System.out.println("Atualização realizada com sucesso. \n");
						break;
					case 2:
						System.out.print("Informe o novo número de telefone do Aluno, com DDD, (21xxxxxxxxx): ");
						String newTelefone = sc.nextLine();

						if (alunos.findByTelefone(newTelefone) == null && pessoas.findByTelefone(newTelefone) == null) {
							aluno.setTelefone(newTelefone);
							aluno.setUltimaAlteracaoPerfil(new Date());
							alunos.update(aluno);
							System.out.println("Atualização realizada com sucesso. \n");
						} else {
							throw new ObjectAlreadyExistsException("Erro, celular já existente para outro perfil.");
						}
						break;
					case 3:
						System.out.print("Informe a nova data de nascimento no padrão dia/mês/ano (29/05/1995): ");
						String newNascimento = sc.nextLine();
						aluno.setNascimento(Auxiliares.sdfDiaMesAno.parse(newNascimento));
						aluno.setUltimaAlteracaoPerfil(new Date());
						alunos.update(aluno);
						System.out.println("Atualização realizada com sucesso. \n");
						break;
					case 4:
						System.out.print("Informe a nova Nota Final do Aluno (separado com virgula): ");
						double notaFinal = sc.nextDouble();
						aluno.setNotaFinalCurso(notaFinal);
						aluno.setUltimaAlteracaoPerfil(new Date());
						alunos.update(aluno);
						System.out.println("Atualização realizada com sucesso. \n");
						break;
					case 5:
						continua = false;
						break;
					default:
						System.out.println("Foi digitado uma opção invalida, voltando ao menu principal.");
					}
				}
			} else {
				throw new ObjectNotFoundException("Perfil não localizado ou telefone digitado incorretamente.");
			}

			System.out.println("\n=============================================\n");

		} catch (ParseException e) {
			System.out.println("A data de nascimento foi digitada incorretamente.");
			System.out.println("\n=============================================\n");
		} catch (InputMismatchException e) {
			System.out.println("Algo foi digitado incorretamente.");
			sc.next();
			System.out.println("\n=============================================\n");
		} catch (ObjectNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("\n=============================================\n");
		} catch (NumberFormatException e) {
			System.out.println("O número de celular foi digitado incorretamente.");
			System.out.println("\n=============================================\n");
		} catch (ObjectAlreadyExistsException e) {
			System.out.println(e.getMessage());
			System.out.println("\n=============================================\n");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Não foi possivel inserir o celular, tamanho incorreto.");
		} catch (ObjectIsBlankException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void opcao4(Scanner sc, PessoaService pessoas, AlunoService alunos) {
		System.out.println("\n=============================================\n");

		try {
			System.out.print("Informe o telefone completo do Perfil que deseja excluir: ");
			String telefone = sc.nextLine();

			Pessoa pessoa = pessoas.findByTelefone(telefone);
			Aluno aluno = alunos.findByTelefone(telefone);

			if (pessoa != null) {
				pessoas.delete(pessoa);
				System.out.println("Pessoa deletada com sucesso.");
			} else if (aluno != null) {
				alunos.delete(aluno);
				System.out.println("Aluno deletado com sucesso.");
			} else {
				throw new ObjectNotFoundException("Perfil não localizado ou telefone digitado incorretamente.");
			}

			System.out.println("\n=============================================\n");

		} catch (InputMismatchException e) {
			System.out.println("Algo foi digitado incorretamente.");
			sc.next();
			System.out.println("\n=============================================\n");
		} catch (ObjectNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("\n=============================================\n");
		}
	}
}
