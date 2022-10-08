package domain;

import java.util.Date;
import java.util.Objects;

import util.Auxiliares;

public class Pessoa {
	
	protected long id;
	protected String nome;
	protected String telefone;
	protected Date nascimento;
	protected Date dataCadastro;
	protected Date ultimaAlteracaoPerfil;
	
	public static int geraId = 0;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, String telefone, Date nascimento) {
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		
		this.dataCadastro = new Date();
		this.id = ++geraId; 
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getNascimentoSimplificado() {
		return Auxiliares.sdfDiaMesAno.format(nascimento);
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public String getDataCadastroSimplificado() {
		return Auxiliares.sdfDataEHora.format(dataCadastro);
	}

	public Date getUltimaAlteracaoPerfil() {
		return ultimaAlteracaoPerfil;
	}

	public void setUltimaAlteracaoPerfil(Date ultimaAlteracaoPerfil) {
		this.ultimaAlteracaoPerfil = ultimaAlteracaoPerfil;
	}
	
	public String getUltimaAlteracaoPerfilSimplificado() {
		return Auxiliares.sdfDataEHora.format(ultimaAlteracaoPerfil);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(nome, other.nome);
	}
	
	public String infoSimplificada() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: " + this.getNome());
		sb.append("\nTelefone: " + this.getTelefone());
		sb.append("\nIdade: " + Auxiliares.getIdade(this.getNascimento()));
		sb.append("\nData de nascimento: " + this.getNascimentoSimplificado());
		sb.append("\nData de cadastro: " + this.getDataCadastroSimplificado());
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nNome: " + this.getNome());
		sb.append("\nTelefone: " + this.getTelefone());
		sb.append("\nIdade: " + Auxiliares.getIdade(this.getNascimento()));
		sb.append("\nData de nascimento: " + this.getNascimentoSimplificado());
		sb.append("\nData de cadastro: " + this.getDataCadastro());
		if(this.getUltimaAlteracaoPerfil() != null) {
			sb.append("\nUltima data de Alteração: " + this.getUltimaAlteracaoPerfil());			
		}
		
		return sb.toString();
	}
}
