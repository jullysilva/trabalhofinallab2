package Empresa;

import arquivo.ArquivoTextoEscrita;
import arquivo.ArquivoTextoLeitura;

public class manipulaEmpresa {
	private ArquivoTextoLeitura leitorArquivo;
	private ArquivoTextoEscrita escritorArquivo;
	private String arquivo;
	private Lista lista = new Lista();

	public manipulaEmpresa(ArquivoTextoLeitura leitorArquivo, ArquivoTextoEscrita escritorArquivo, String arquivo) {
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
	
	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public void carregaDadosArquivo() {
		String[] informacoes = new String[5];
		Empresa empresa;
		String linhaArquivo = leitorArquivo.ler();
		while(linhaArquivo != null && linhaArquivo != "\n"){
			linhaArquivo = leitorArquivo.ler();
			
			if(linhaArquivo != null){
			informacoes = linhaArquivo.split(";");
			empresa = new Empresa(informacoes[0], informacoes[1], Integer.parseInt(informacoes[2]), informacoes[3],	Float.parseFloat(informacoes[4]));
			
				populaLista(empresa);
			}
		}
		getLista().gestorDados();
	}
	
	public void armazenaDadosArquivo(String nomeEmp) {
		if(getLista().localizar(nomeEmp) != null)
			gravaDadosArquivo(getLista().localizar(nomeEmp));
	}
	
	public void gravaDadosArquivo(Empresa empresa) {
		populaLista(empresa);
		atualizarArquivo();
	}
	
	public void atualizarArquivo() {
		escritorArquivo.abrirArquivo(getArquivo());
		escritorArquivo.escrever(getLista().listarDados());
		escritorArquivo.fecharArquivo();
		getLista().gestorDados();
	}
	
	private void populaLista(Empresa empresa) {
		lista.adicionar(empresa);
	}
}
