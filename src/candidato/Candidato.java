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
		this.escolaridade = escolaridade;
	}
	public String getAtuacao() {
		return atuacao;
	}
	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
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
