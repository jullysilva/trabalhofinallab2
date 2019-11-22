package candidato;


public class Lista {
	private CelulaCandidato primeiro;
	private CelulaCandidato ultimo; 

	public Lista()
	{
		primeiro = new CelulaCandidato();
		ultimo = primeiro;
	}

	public void adicionar(Candidato novaCand)
	{
		CelulaCandidato aux = new CelulaCandidato();
		ultimo.proximo = aux;
		aux.item = novaCand;
				

		ultimo = ultimo.proximo;
	}

    public Candidato remover(int id)
    {
        CelulaCandidato aux, anterior;
 
        anterior = primeiro;

        aux = primeiro.proximo;
        while (aux != null)
        {
            if (aux.item.getId() == id)
            {
                anterior.proximo = aux.proximo;

                if (aux == ultimo)
                {
                    ultimo = anterior;
                }
                return aux.item;
            }
            else
            {
                anterior = aux;
                aux = aux.proximo;
            }
        }
        return null;
    }
    
    
    public Candidato localizar(int id)
    {
        CelulaCandidato aux;

        aux = primeiro.proximo;

        while (aux != null)
        {

            if (aux.item.getId() == id)
            {
                return aux.item;
            }
            else
            {
                aux = aux.proximo;
            }
        }
        return null;
    }

    public Boolean listaVazia()
    {
        if (primeiro == ultimo)
            return true;
        else
            return false;
    } 
    
    public String listarDados() {
    	String dados = "\n";
    	CelulaCandidato aux = primeiro.proximo;
    	
    	while(aux != null) {
    		dados += String.valueOf(aux.item.getId()) + ";" + aux.item.getNome() + ";" + String.valueOf(aux.item.getIdade()) + ";" + aux.item.getSexo()  + ";"
    				+ aux.item.getEscolaridade() + ";" + aux.item.getAtuacao() + ";" + String.valueOf(aux.item.getPretensao() + "\n");
    		aux = aux.proximo;
    	}
    	return dados;
    }
    
}
