package candidato;

public class CelulaCandidato {
	Candidato item;
	CelulaCandidato proximo;
	
	public CelulaCandidato() {
		item = new Candidato();
		proximo = null;
	}
}
