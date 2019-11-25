package candidato;

public class Candidato {
	private int id;
	private String nome;
	private int idade;
	private String sexo;
	private String escolaridade;
	private String atuacao;
	private float pretensao;
	
	public Candidato(){}
	
	public Candidato(int id, String nome, int idade, String sexo, String escolaridade, String atuacao, float pretensao){
		setId(id);
		setNome(nome);
		setIdade(idade);
		setSexo(sexo.toUpperCase());
		setEscolaridade(escolaridade);
		setAtuacao(atuacao);
		setPretensao(pretensao);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
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
	public float getPretensao() {
		return pretensao;
	}
	public void setPretensao(float pretensao) {
		this.pretensao = pretensao;
	}
	
	@Override
	public String toString() {
		return "Identidade: " + id + "\nNome: " + nome + "\nIdade: " + idade + "\nSexo: " + sexo + "\nEscolaridade: "
				+ escolaridade + "\nÁrea de atuação: " + atuacao + "\nPretensão salarial: " + pretensao;
	}
}
