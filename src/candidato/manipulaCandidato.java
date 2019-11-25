package candidato;

import arquivo.*;

public class manipulaCandidato {
	private ArquivoTextoLeitura leitorArquivo;
	private ArquivoTextoEscrita escritorArquivo;
	private String arquivo;
	private Arvore arvore = new Arvore();
	private Lista lista = new Lista();

	public manipulaCandidato(ArquivoTextoLeitura leitorArquivo, ArquivoTextoEscrita escritorArquivo, String arquivo) {
		setLeitorArquivo(leitorArquivo);
		setEscritorArquivo(escritorArquivo);
		setArquivo(arquivo);
	}

	public ArquivoTextoLeitura getLeitorArquivo() {
		return leitorArquivo;
	}

	public void setLeitorArquivo(ArquivoTextoLeitura leitorArquivo) {
		this.leitorArquivo = leitorArquivo;
	}

	public ArquivoTextoEscrita getEscritorArquivo() {
		return escritorArquivo;
	}

	public void setEscritorArquivo(ArquivoTextoEscrita escritorArquivo) {
		this.escritorArquivo = escritorArquivo;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public Arvore getArvore() {
		return arvore;
	}

	public void setArvore(Arvore arvore) {
		this.arvore = arvore;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public void carregaDadosArquivo() {
		String[] informacoes = new String[7];
		Candidato candidato;
		String linhaArquivo = leitorArquivo.ler();
		while(linhaArquivo != null){
			linhaArquivo = leitorArquivo.ler();
			
			if(linhaArquivo != null && linhaArquivo != "\n"){
			informacoes = linhaArquivo.split(";");
			candidato = new Candidato(Integer.parseInt(informacoes[0]), informacoes[1], Integer.parseInt(informacoes[2]), informacoes[3],
					informacoes[4], informacoes[5], Float.parseFloat(informacoes[6]));
				populaArvore(candidato);
				populaLista(candidato);
				
			}
		}
		getLista().gestorDados();
	}
	
	public void armazenaDadosArquivo(int identidade) {
		if(getArvore().pesquisar(identidade) != null)
			gravaDadosArquivo(getArvore().pesquisar(identidade));
	}
	
	public void gravaDadosArquivo(Candidato candidato) {
		populaArvore(candidato);
		populaLista(candidato);
		atualizarArquivo();
	}
	
	public void removerDadosAL(int id) {
		getArvore().remover(id);
		getLista().remover(id);
		
		atualizarArquivo();
	}
	
	public void atualizarArquivo() {
		escritorArquivo.abrirArquivo(getArquivo());
		escritorArquivo.escrever(getLista().listarDados());
		escritorArquivo.fecharArquivo();
		getLista().gestorDados();
	}
	
	private void populaArvore(Candidato candidato) {
		arvore.inserir(candidato);
	}
	
	private void populaLista(Candidato candidato) {
		lista.adicionar(candidato);
	}
}
