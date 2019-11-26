package candidato;

import Empresa.CelulaEmpresa;

public class Lista {
	private CelulaCandidato primeiro;
	private CelulaCandidato ultimo; 
	private float[] dados = new float[22];
	private String[] porEscolaridade = new String[5];
	
	public float[] getDados() {
		return dados;
	}

	public String[] getPorEscolaridade() {
		return porEscolaridade;
	}

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
    
    
    public void gestorDados() {
    	CelulaCandidato aux = primeiro.proximo;
    	int i = 0;
    	while(i < 22) {
    		dados[i] = 0;
    		i++;
    	}
    	
    	while(aux != null) {
    		dados[0] += 1;
    		
    		if(aux.item.getSexo().equalsIgnoreCase("f"))
    			dados[1] += 1;
    		else
    			dados[2] += 1;
    		
    		if(aux.item.getEscolaridade().equalsIgnoreCase("Graduação") || aux.item.getEscolaridade().equalsIgnoreCase("Graduacao") 
    				|| aux.item.getEscolaridade().equalsIgnoreCase("Graduacão") || aux.item.getEscolaridade().equalsIgnoreCase("Graduacao") 
    				|| aux.item.getEscolaridade().equalsIgnoreCase("Graduacao"))
    			dados[3] += 1;
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Pós-Graduação") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao"))
    			dados[4] += 1;
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Mestrado") || aux.item.getEscolaridade().equalsIgnoreCase("mestrado"))
    			dados[5] += 1;
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("Doutorado"))
    			dados[6] += 1;
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Pos-Doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado") 
    				|| aux.item.getEscolaridade().equalsIgnoreCase("Pós-Doutorado"))
    			dados[7] += 1;
    		
    		if(aux.item.getAtuacao().equalsIgnoreCase("Administração") || aux.item.getAtuacao().equalsIgnoreCase("Administracão")
    				|| aux.item.getAtuacao().equalsIgnoreCase("Administraçao") || aux.item.getAtuacao().equalsIgnoreCase("Administracao") 
    				|| aux.item.getAtuacao().equalsIgnoreCase("administracao")) {
    			dados[8] += 1;
    			dados[15] += aux.item.getPretensao();
    		}	
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Engenharia") || aux.item.getAtuacao().equalsIgnoreCase("engenharia")) {
    			dados[9] += 1;
    			dados[16] += aux.item.getPretensao();
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Arte e Design") || aux.item.getAtuacao().equalsIgnoreCase("arte e design")) {
    			dados[10] += 1;
    			dados[17] += aux.item.getPretensao();
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Meio Ambiente") || aux.item.getAtuacao().equalsIgnoreCase("meio ambiente")) {
    			dados[11] += 1;
    			dados[18] += aux.item.getPretensao();
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Saúde") || aux.item.getAtuacao().equalsIgnoreCase("Saude") || aux.item.getAtuacao().equalsIgnoreCase("saude")) {
    			dados[12] += 1;
    			dados[19] += aux.item.getPretensao();
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Tecnologia") || aux.item.getAtuacao().equalsIgnoreCase("tecnologia")) {
    			dados[13] += 1;
    			dados[20] += aux.item.getPretensao();
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Sociais e Humanas") || aux.item.getAtuacao().equalsIgnoreCase("sociais e humanas")) {
    			dados[14] += 1;
    			dados[21] += aux.item.getPretensao();
    		}
    		
    		aux = aux.proximo;
    	}
    	
    }
    
    public void vagaPorEscolaridade() {
    	CelulaCandidato aux = primeiro.proximo;
    	String dado = "";
    	while(aux != null) {
    		if(aux.item.getEscolaridade().equalsIgnoreCase("Graduação") || aux.item.getEscolaridade().equalsIgnoreCase("Graduacao") 
    				|| aux.item.getEscolaridade().equalsIgnoreCase("Graduacão") || aux.item.getEscolaridade().equalsIgnoreCase("Graduacao") 
    				|| aux.item.getEscolaridade().equalsIgnoreCase("Graduacao"))
    			dados[3] += 1;
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Pós-Graduação") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao"))
    			dados[4] += 1;
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Mestrado") || aux.item.getEscolaridade().equalsIgnoreCase("mestrado"))
    			dados[5] += 1;
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("Doutorado"))
    			dados[6] += 1;
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Pos-Doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado") 
    				|| aux.item.getEscolaridade().equalsIgnoreCase("Pós-Doutorado"))
    			dados[7] += 1;
    		
    		aux = aux.proximo;
    	}
    }
    
    public String localizaVagas(String escolaridade) {
    	String dados = "";
	    	
    		if(escolaridade.equalsIgnoreCase("graduacao")) {
    			CelulaCandidato aux = primeiro.proximo;
    			while(aux != null) {
    					dados += aux.item.getId() + " - " + aux.item.getNome() + " - " + aux.item.getIdade() + " anos - Escolaridade: "
    	    	        + aux.item.getEscolaridade() + "\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}

    		else if(escolaridade.equalsIgnoreCase("pos-graduacao")) {
    			CelulaCandidato aux = primeiro.proximo;
    			while(aux != null) {
    				if(!aux.item.getEscolaridade().equalsIgnoreCase("graduacao"))
    					dados += aux.item.getId() + " - " + aux.item.getNome() + " - " + aux.item.getIdade() + " anos - Escolaridade: "
    	    	    	        + aux.item.getEscolaridade() + "\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}
    		else if(escolaridade.equalsIgnoreCase("mestrado")) {
    			CelulaCandidato aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getEscolaridade().equalsIgnoreCase("mestrado") || aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado"))
    					dados += aux.item.getId() + " - " + aux.item.getNome() + " - " + aux.item.getIdade() + " anos - Escolaridade: "
    	    	    	        + aux.item.getEscolaridade() + "\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}
    		else if(escolaridade.equalsIgnoreCase("doutorado")) {
    			CelulaCandidato aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("doutorado"))
    					dados += aux.item.getId() + " - " + aux.item.getNome() + " - " + aux.item.getIdade() + " anos - Escolaridade: "
    	    	    	        + aux.item.getEscolaridade() + "\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}
    		else if(escolaridade.equalsIgnoreCase("pos-doutorado")) {
    			CelulaCandidato aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado"))
    					dados += aux.item.getId() + " - " + aux.item.getNome() + " - " + aux.item.getIdade() + " anos - Escolaridade: "
    	    	    	        + aux.item.getEscolaridade() + "\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}
    		else
    			return "\nÁrea de atuação não existe em nossos registros!\n";
    	
    }
    
}
