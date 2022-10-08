package menus;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import domain.Aluno;
import domain.Pessoa;
import services.AlunoService;
import services.PessoaService;
import services.excepctions.ObjectAlreadyExistsException;
import util.Auxiliares;

public class Menus {

	public static void opcao1(Scanner sc, PessoaService pessoas, AlunoService alunos) {
		try {
			System.out.println("--Sistema de cadastro --");
			System.out.println("\nNome: ");
			String nome = sc.nextLine();
			System.out.println("Telefone de contato: ");
			String telefone = sc.nextLine();
			System.out.println("Informe sua data de nascimento no padrão dia/mês/ano: ");
			String nascimento = sc.nextLine();
			
			System.out.println("O usuario em questão terá uma nota? Digita 1 para sim e 2 para não");
			int escolha = sc.nextInt();
			sc.nextLine();
			
			if(escolha == 1) {
				System.out.println("Informe a nota final do Aluno: ");
				double nota = sc.nextDouble();
				
				alunos.insert(new Aluno(nome, telefone, Auxiliares.sdfDiaMesAno.parse(nascimento), nota));
				System.out.println("Aluno criado com sucesso.");
			} else {
				pessoas.insert(new Pessoa(nome, telefone,  Auxiliares.sdfDiaMesAno.parse(nascimento)));
				System.out.println("Pessoa criada com sucesso.");
			}
		} catch(ParseException e){
			System.out.println("A data de nascimento foi digitada incorretamente.");
		} catch(InputMismatchException e) {
			System.out.println("Algo foi digitado incorretamente.");
			sc.next();
		} catch(ObjectAlreadyExistsException e) {
			System.out.println(e.getMessage());
		} catch(NumberFormatException e) {
			System.out.println("Um número foi digitado incorretamente, favor digite utilizando um ponto, como o exemplo: 9.8");
		}
	}

	public static void opcao2(Scanner sc, PessoaService pessoas, AlunoService alunos) {
		System.out.println("--- Pessoas ---");
		for(Pessoa p: pessoas.findAll()) {
			System.out.println("\n" + p);
		}
		
		System.out.println("--- Alunos ---");
		for(Aluno p: alunos.findAll()) {
			System.out.println("\n" + p);
		}
	}

	public static void opcao3(Scanner sc, PessoaService pessoas, AlunoService alunos) {
		System.out.println("--- Pessoas ---");
		for(Pessoa p: pessoas.findAll()) {
			System.out.println("\n" + p.infoSimplificada());
		}
		
		System.out.println("--- Alunos ---");
		for(Aluno p: alunos.findAll()) {
			System.out.println("\n" + p.infoSimplificada());
		}
	}

	public static void opcao4(Scanner sc, PessoaService pessoas, AlunoService alunos) {
		
	}
	
	public static void opcao5(Scanner sc, PessoaService pessoas, AlunoService alunos) {

	}
}
