package domain;

import java.util.Date;

import util.Auxiliares;

public class Aluno extends Pessoa{
	
	private double notaFinalCurso;

	public Aluno(String nome, String telefone, Date nascimento, double notaFinalCurso) {
		super(nome, telefone, nascimento);
		this.notaFinalCurso = notaFinalCurso;
	}

	public double getNotaFinalCurso() {
		return notaFinalCurso;
	}

	public void setNotaFinalCurso(double notaFinalCurso) {
		this.notaFinalCurso = notaFinalCurso;
	}
	
	@Override
	public String infoSimplificada() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + this.getNome());
		sb.append("\nTelefone: " + this.getTelefone());
		sb.append("\nIdade: " + Auxiliares.getIdade(this.getNascimento()));
		sb.append("\nData de nascimento: " + this.getNascimentoSimplificado());
		sb.append("\nNota final do curso: " + this.getNotaFinalCurso());
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID de usuario: " + this.getId());
		sb.append("\nNome: " + this.getNome());
		sb.append("\nTelefone: " + this.getTelefone());
		sb.append("\nIdade: " + Auxiliares.getIdade(this.getNascimento()));
		sb.append("\nData de nascimento: " + this.getNascimentoSimplificado());
		sb.append("\nNota final do curso: " + this.getNotaFinalCurso());
		sb.append("\nData de cadastro: " + this.getDataCadastro());
		if(this.getUltimaAlteracaoPerfil() != null) {
			sb.append("\nUltima data de Alteração: " + this.getUltimaAlteracaoPerfil());			
		}
		
		return sb.toString();
	}
}
