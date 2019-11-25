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
		if(atuacao.equalsIgnoreCase("Administração") || atuacao.equalsIgnoreCase("Administracão") 
			|| atuacao.equalsIgnoreCase("Administraçao") || atuacao.equalsIgnoreCase("Administracao") 
			|| atuacao.equalsIgnoreCase("administracao"))
			this.atuacao = "administracao";
		else if(atuacao.equalsIgnoreCase("Engenharia") || atuacao.equalsIgnoreCase("engenharia"))
			this.atuacao = "engenharia";
		else if(atuacao.equalsIgnoreCase("Arte e Design") || atuacao.equalsIgnoreCase("arte e design"))
			this.atuacao = "arte e design";
		else if(atuacao.equalsIgnoreCase("Meio Ambiente") || atuacao.equalsIgnoreCase("meio ambiente"))
			this.atuacao = "meio ambiente";
		else if(atuacao.equalsIgnoreCase("Saúde") || atuacao.equalsIgnoreCase("Saude") || atuacao.equalsIgnoreCase("saude"))
			this.atuacao = "saude";
		else if(atuacao.equalsIgnoreCase("Tecnologia") || atuacao.equalsIgnoreCase("tecnologia"))
			this.atuacao = "tecnologia";
		else if(atuacao.equalsIgnoreCase("Sociais e Humanas") || atuacao.equalsIgnoreCase("sociais e humanas"))
			this.atuacao = "sociais e humanas";
		
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
		if(escolaridade.equalsIgnoreCase("Graduação") || escolaridade.equalsIgnoreCase("graduacao"))
			this.escolaridade = "graduacao";
		else if(escolaridade.equalsIgnoreCase("Pós-Graduação") || escolaridade.equalsIgnoreCase("pos-graduacao"))
			this.escolaridade = "pos-graduacao";
		else if(escolaridade.equalsIgnoreCase("Mestrado"))
			this.escolaridade = "mestrado";
		else if(escolaridade.equalsIgnoreCase("Doutorado"))
			this.escolaridade = "doutorado";
		else if(escolaridade.equalsIgnoreCase("Pos-Doutorado") || escolaridade.equalsIgnoreCase("pos-doutorado") 
				|| escolaridade.equalsIgnoreCase("Pós-Doutorado"))
			this.escolaridade = "pos-doutorado";
		
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
