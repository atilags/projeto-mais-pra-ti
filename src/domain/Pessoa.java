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
		setTelefone(telefone);
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
		long tel = Long.parseLong(telefone);
		
		//Irá testar se o padrão do telefone está correto, com 11 digitos, ddd+celular, caso esteja incorreto o sistema irá dar erro de Out of Bound.
		this.telefoneFormatado(telefone);
		
		this.telefone = String.valueOf(tel);
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
	
	public String telefoneFormatado(String telefone) {
		telefone = "(" + telefone.substring(0,2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7,11);
		return telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(telefone);
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
		return Objects.equals(telefone, other.telefone);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nNome: " + this.getNome());
		sb.append("\nTelefone: " + this.telefoneFormatado(this.telefone));
		sb.append("\nIdade: " + Auxiliares.getIdade(this.getNascimento()));
		sb.append("\nData de nascimento: " + this.getNascimentoSimplificado());
		sb.append("\nData de cadastro: " + this.getDataCadastroSimplificado());
		if(this.getUltimaAlteracaoPerfil() != null) {
			sb.append("\nUltima data de Alteração: " + this.getUltimaAlteracaoPerfilSimplificado());			
		}
		
		return sb.toString();
	}
}
