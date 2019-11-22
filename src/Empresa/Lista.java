package Empresa;

public class Lista {
	private CelulaEmpresa primeiro;
	private CelulaEmpresa ultimo; 


	public Lista()
	{
		primeiro = new CelulaEmpresa();
		ultimo = primeiro;
	}
	public void adicionar(Empresa novaEmp)
	{
		CelulaEmpresa aux = new CelulaEmpresa();
		ultimo.proximo = aux;
		
		aux.item = novaEmp;

		ultimo = ultimo.proximo;
	}

    public Empresa remover(String nomeEmp){
        CelulaEmpresa aux, anterior = null;
        aux = primeiro.proximo;
        
        while (aux != null){

            if (aux.item.getNome().equalsIgnoreCase(nomeEmp)) {

                anterior.proximo = aux.proximo;

                if (aux == ultimo)
                    ultimo = anterior;
                return aux.item;
            }
            else{
                anterior = aux;
                aux = aux.proximo;
            }
        }
        return null;
    }

    public Empresa localizar(String nomeEmp){
        CelulaEmpresa aux;
        aux = primeiro.proximo;

        while (aux != null){
            if (aux.item.getNome().equalsIgnoreCase(nomeEmp))
                return aux.item;
            else
                aux = aux.proximo;
        }
        return null;
    }

    public Boolean listaVazia(){

        if (primeiro == ultimo)
            return true;
        else
            return false;
    } 
    
    public String listarDados() {
    	String dados = "\n";
    	CelulaEmpresa aux = primeiro.proximo;
    	
    	while(aux != null) {
    		dados += aux.item.getNome() + ";" + aux.item.getAtuacao() + ";" + String.valueOf(aux.item.getVagas())  + ";"
    				+ aux.item.getEscolaridade() + ";" + String.valueOf(aux.item.getSalario() + "\n");
    		aux = aux.proximo;
    	}
    	geraDadosRelatorio();
    	return dados;
    }
    
    private void geraDadosRelatorio() {
    	
    }
}
