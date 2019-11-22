package candidato;


public class NodoCandidato {
	Candidato item;
	NodoCandidato direita;
	NodoCandidato esquerda;
	
	public NodoCandidato(Candidato candidato) {
		item = candidato;
		direita = null;
		esquerda = null;
	}
}
