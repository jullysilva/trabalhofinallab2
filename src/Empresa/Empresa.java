package Empresa;

public class Empresa {
	private String nome;
	private String atuacao;
	private int vagas;
	private String escolaridade;
	private float salario;
	
	public Empresa() {}
	
	public Empresa(String nome, String atuacao, int vagas, String escolaridade, float salario) {
		setNome(nome);
		setAtuacao(atuacao);
		setVagas(vagas);
		setEscolaridade(escolaridade);
		setSalario(salario);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtuacao() {
		return atuacao;
	}

	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empresa: " + nome + "\nÁrea de atuação: " + atuacao + "\nQuantidade de vagas: " + vagas + "\nEscolaridade mínima: " + escolaridade
				+ "\nSalário máximo oferecido: " + salario + "\n";
	}
}
