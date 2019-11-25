package candidato;

public class Arvore {
	private NodoCandidato raiz; // referência à raiz da árvore.

    public Arvore()
    {
        raiz = null;
    }

    public Boolean arvoreVazia()
    {

        if (this.raiz == null)
            return true;
        else
            return false;
    }

    private NodoCandidato adicionar(NodoCandidato raizArvore, Candidato novoCand)
    {
        if (raizArvore == null)
            raizArvore = new NodoCandidato(novoCand);
        else
        {
            if (raizArvore.item.getId() > novoCand.getId())
                raizArvore.esquerda = adicionar(raizArvore.esquerda, novoCand);
            else
            {
                if (raizArvore.item.getId() < novoCand.getId())
                    raizArvore.direita = adicionar(raizArvore.direita, novoCand);
                else
                    System.out.println("O candidato " + novoCand.getNome() + ", cuja identidade é " + novoCand.getId() + ", já foi inserida anteriormente na árvore.");
            }
        }
        return raizArvore;
    }
    
    public void inserir(Candidato novoCand)
    {
        this.raiz = adicionar(this.raiz, novoCand);
    }

    public Candidato pesquisar(int id) {
    	return localizarNaArvore(raiz, id);
    }
    
    private Candidato localizarNaArvore(NodoCandidato raizArvore, int id) {
    	if(!arvoreVazia()) {
			if (raizArvore != null) {
				if (raizArvore.item.getId() == id)
					return raizArvore.item;
				else if (raizArvore.item.getId() > id)
					return localizarNaArvore(raizArvore.esquerda, id);
				else if (raizArvore.item.getId() < id)
					return localizarNaArvore(raizArvore.direita, id);
			}
		}
    	return null;
    }

    private NodoCandidato antecessor(NodoCandidato tirarCand, NodoCandidato raizArvore)
    {

        if (raizArvore.direita != null)
        {

            raizArvore.direita = antecessor(tirarCand, raizArvore.direita);
            return raizArvore;
        }

        else
        {
            tirarCand.item.setId((int) raizArvore.item.getId());
            tirarCand.item.setNome(raizArvore.item.getNome());
            tirarCand.item.setIdade(raizArvore.item.getIdade());
            tirarCand.item.setSexo(raizArvore.item.getSexo());
            tirarCand.item.setEscolaridade(raizArvore.item.getEscolaridade());
            tirarCand.item.setAtuacao(raizArvore.item.getAtuacao());
            tirarCand.item.setPretensao(raizArvore.item.getPretensao());
            return raizArvore.esquerda;
        }
    }


    private NodoCandidato retirar(NodoCandidato raizArvore, int id)
    {
        if (raizArvore == null)
        {
        	 System.out.println("O candidato, cuja identidade é " + id + ", não foi encontrada.");
            return raizArvore;
        }
        else
        {

            if (raizArvore.item.getId() == id)
            {

                if (raizArvore.direita == null)
                    return (raizArvore.esquerda);
                else
                    if (raizArvore.esquerda == null)
                        return (raizArvore.direita);
                    else
                    {
                        raizArvore.esquerda = antecessor(raizArvore, raizArvore.esquerda);
                        return (raizArvore);
                    }
            }
            else
            {

                if (raizArvore.item.getId() > id)
                    raizArvore.esquerda = retirar(raizArvore.esquerda, id);
                else

                    raizArvore.direita = retirar(raizArvore.direita, id);
                return raizArvore;
            }
        }
    }


    public void remover(int id)
    {
        this.raiz = retirar(this.raiz, id);
    }
    
    public  int  numCandidatos() {
    	return contarCandidatos(raiz);
    }
    
    private int contarCandidatos(NodoCandidato  raizArvore) {
    	
    	if(raizArvore !=  null)
    		return 1+contarCandidatos(raizArvore.direita) + contarCandidatos(raizArvore.esquerda);
    	else 
    		return 0;
    	
    }
}
