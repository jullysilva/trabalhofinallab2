package Empresa;

public class Lista {
	private CelulaEmpresa primeiro;
	private CelulaEmpresa ultimo; 
	private float[] dados = new float[27];

	public float[] getDados() {
		return dados;
	}

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
    	return dados;
    }
    
    public void gestorDados() {
    	CelulaEmpresa aux = primeiro.proximo;
    	//While para definir o valor '0' a todos as posições do vetor
    	int i = 0;
    	while(i < 21) {
    		dados[i] = 0;
    		i++;
    	}
    	
    	//while para gerar base de dados de: vagas por atuacao, total de salario por atuacao, total por atuacao
    	while(aux != null) {
    		
    		if(aux.item.getAtuacao().equalsIgnoreCase("Administração") || aux.item.getAtuacao().equalsIgnoreCase("Administracão")
    				|| aux.item.getAtuacao().equalsIgnoreCase("Administraçao") || aux.item.getAtuacao().equalsIgnoreCase("Administracao") 
    				|| aux.item.getAtuacao().equalsIgnoreCase("administracao")) {
    			dados[0] += aux.item.getVagas();
    			dados[7] += aux.item.getSalario();
    			dados[14] += 1;
    			
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Engenharia") || aux.item.getAtuacao().equalsIgnoreCase("engenharia")) {
    			dados[1] += aux.item.getVagas();
    			dados[8] += aux.item.getSalario();
    			dados[15] += 1;
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Arte e Design") || aux.item.getAtuacao().equalsIgnoreCase("arte e design")) {
    			dados[2] += aux.item.getVagas();
    			dados[9] += aux.item.getSalario();
    			dados[16] += 1;
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Meio Ambiente") || aux.item.getAtuacao().equalsIgnoreCase("meio ambiente")) {
    			dados[3] += aux.item.getVagas();
    			dados[10] += aux.item.getSalario();
    			dados[17] += 1;
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Saúde") || aux.item.getAtuacao().equalsIgnoreCase("Saude") || aux.item.getAtuacao().equalsIgnoreCase("saude")) {
    			dados[4] = aux.item.getVagas();
    			dados[11] += aux.item.getSalario();
    			dados[18] += 1;
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Tecnologia") || aux.item.getAtuacao().equalsIgnoreCase("tecnologia")) {
    			dados[5] += aux.item.getVagas();
    			dados[12] += aux.item.getSalario();
    			dados[19] += 1;
    		}
    		else if(aux.item.getAtuacao().equalsIgnoreCase("Sociais e Humanas") || aux.item.getAtuacao().equalsIgnoreCase("sociais e humanas")) {
    			dados[6] += aux.item.getVagas();
    			dados[13] += aux.item.getSalario();
    			dados[20] += 1;
    		}
    		aux = aux.proximo;
    	}
    	
    	//while para obter total de vagas oferecidas através da coleta de vagas por atuacao
    	i = 0;
    	while(i < 7) {
    		dados[26] += dados[i];
    		i++;
    	}
    	
    	//while para obter total de vagas por escolaridade
    	aux = primeiro.proximo;
    	while(aux != null) {
    		if(aux.item.getEscolaridade().equalsIgnoreCase("Graduação") || aux.item.getEscolaridade().equalsIgnoreCase("graduacao"))
    			dados[21] += aux.item.getVagas();
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Pós-Graduação") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao"))
    			dados[22] += aux.item.getVagas();
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Mestrado"))
    			dados[23] += aux.item.getVagas();
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Doutorado"))
    			dados[24] += aux.item.getVagas();
    		else if(aux.item.getEscolaridade().equalsIgnoreCase("Pos-Doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado") 
    				|| aux.item.getEscolaridade().equalsIgnoreCase("Pós-Doutorado"))
    			dados[25] += aux.item.getVagas();
    			
    		aux = aux.proximo;
    	}
    }
    
    public String localizaVagas(String atuacao, String escolaridade) {
    	String dados = "";

    	if(atuacao.equalsIgnoreCase("administracao")) { 	    	
    		if(escolaridade.equalsIgnoreCase("graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && aux.item.getEscolaridade().equalsIgnoreCase(escolaridade))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}

    		else if(escolaridade.equalsIgnoreCase("pos-graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && (aux.item.getEscolaridade().equalsIgnoreCase("graduacao") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}
    		else if(escolaridade.equalsIgnoreCase("mestrado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !(aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}
    		else if(escolaridade.equalsIgnoreCase("doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado"))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}
    		else if(escolaridade.equalsIgnoreCase("pos-doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    			return dados;
    		}
    		else
    			System.out.print("EScolaridade inexistente em nossos registros");
    		return dados;
    	}
    	
    	else if(atuacao.equalsIgnoreCase("engenharia")) {
    		if(escolaridade.equalsIgnoreCase("graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && aux.item.getEscolaridade().equalsIgnoreCase(escolaridade))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}

    		else if(escolaridade.equalsIgnoreCase("pos-graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && (aux.item.getEscolaridade().equalsIgnoreCase("graduacao") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("mestrado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !(aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado"))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("pos-doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else
    			System.out.print("EScolaridade inexistente em nossos registros");
    		return dados;
    	}
    	else if(atuacao.equalsIgnoreCase("arte e design")) {
    		if(escolaridade.equalsIgnoreCase("graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && aux.item.getEscolaridade().equalsIgnoreCase(escolaridade))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}

    		else if(escolaridade.equalsIgnoreCase("pos-graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && (aux.item.getEscolaridade().equalsIgnoreCase("graduacao") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("mestrado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !(aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado"))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("pos-doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else
    			System.out.print("EScolaridade inexistente em nossos registros");
    		return dados;
    	}
    	else if(atuacao.equalsIgnoreCase("meio ambiente")) {
    		if(escolaridade.equalsIgnoreCase("graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && aux.item.getEscolaridade().equalsIgnoreCase(escolaridade))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}

    		else if(escolaridade.equalsIgnoreCase("pos-graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && (aux.item.getEscolaridade().equalsIgnoreCase("graduacao") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("mestrado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !(aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado"))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("pos-doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else
    			System.out.print("EScolaridade inexistente em nossos registros");
    		return dados;
    	}
    	else if(atuacao.equalsIgnoreCase("saude")) {
    		if(escolaridade.equalsIgnoreCase("graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && aux.item.getEscolaridade().equalsIgnoreCase(escolaridade))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}

    		else if(escolaridade.equalsIgnoreCase("pos-graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && (aux.item.getEscolaridade().equalsIgnoreCase("graduacao") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("mestrado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !(aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado"))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("pos-doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else
    			System.out.print("EScolaridade inexistente em nossos registros");
    		return dados;
    	}
    	else if(atuacao.equalsIgnoreCase("tecnologia")) {
    		if(escolaridade.equalsIgnoreCase("graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && aux.item.getEscolaridade().equalsIgnoreCase(escolaridade))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}

    		else if(escolaridade.equalsIgnoreCase("pos-graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && (aux.item.getEscolaridade().equalsIgnoreCase("graduacao") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("mestrado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !(aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado"))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("pos-doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else
    			System.out.print("EScolaridade inexistente em nossos registros");
    		return dados;
    	}
    	else if(atuacao.equalsIgnoreCase("sociais e humanas")) {
    		if(escolaridade.equalsIgnoreCase("graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && aux.item.getEscolaridade().equalsIgnoreCase(escolaridade))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}

    		else if(escolaridade.equalsIgnoreCase("pos-graduacao")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && (aux.item.getEscolaridade().equalsIgnoreCase("graduacao") || aux.item.getEscolaridade().equalsIgnoreCase("pos-graduacao")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("mestrado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !(aux.item.getEscolaridade().equalsIgnoreCase("doutorado") || aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado")))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao) && !aux.item.getEscolaridade().equalsIgnoreCase("pos-doutorado"))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else if(escolaridade.equalsIgnoreCase("pos-doutorado")) {
    			CelulaEmpresa aux = primeiro.proximo;
    			while(aux != null) {
    				if(aux.item.getAtuacao().equalsIgnoreCase(atuacao))
    					dados += "Empresa: " + aux.item.getNome() + "\nCargo: " + aux.item.getAtuacao() + "\nVagas: " + String.valueOf(aux.item.getVagas())  + "\nEscolaridade exigida: "
    	    	    	        + aux.item.getEscolaridade() + "\nSalário oferecido: " + String.valueOf(aux.item.getSalario()) + "\n\n";
    				aux = aux.proximo;
    			}
    		}
    		else
    			System.out.print("EScolaridade inexistente em nossos registros");
    		return dados;
    	}
    	else
    		return "\nÁrea de atuação não existe em nossos registros!\n";
    	
    }
    
}
