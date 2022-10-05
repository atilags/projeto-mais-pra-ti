package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Pessoa {
	
	protected String nome;
	protected String telefone;
	protected Date nascimento;
	protected Date dataCadastro;
	protected Date ultimaAlteracaoPerfil;
	
	SimpleDateFormat sdfBasico = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdfAvancado = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, String telefone, Date nascimento) {
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
		
		this.dataCadastro = new Date();
	}
	
	public Pessoa(String nome, String telefone, String nascimento) throws ParseException {
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = sdfBasico.parse(nascimento);
		
		this.dataCadastro = new Date();
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
		return sdfBasico.format(nascimento);
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}
	
	public String getDataCadastroSimplificado() {
		return sdfAvancado.format(dataCadastro);
	}

	public Date getUltimaAlteracaoPerfil() {
		return ultimaAlteracaoPerfil;
	}

	public void setUltimaAlteracaoPerfil(Date ultimaAlteracaoPerfil) {
		this.ultimaAlteracaoPerfil = ultimaAlteracaoPerfil;
	}
	
	public String getUltimaAlteracaoPerfilSimplificado() {
		return sdfAvancado.format(ultimaAlteracaoPerfil);
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
		sb.append("Nome: " + nome);
		sb.append("\nTelefone: " + telefone);
		sb.append("\nData de nascimento: " + getNascimentoSimplificado());
		
		return sb.toString();
	}
	
	@Override
	public String toString() {

	}
}
