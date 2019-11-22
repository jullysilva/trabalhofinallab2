package Empresa;

public class CelulaEmpresa {
	Empresa item;
	CelulaEmpresa proximo;
	
	public CelulaEmpresa() {
		item = new Empresa();
		proximo = null;
	}
}
