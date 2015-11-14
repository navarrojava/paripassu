package br.com.navarro.service;

import br.com.navarro.model.Senha;

public interface IPainelClienteService {

	public Senha solicitaSenha(Senha.TipoSenha tipo);
	public int getContadorNormal();
	public int getContadorPreferencial();
	public void setContadorNormal(int contadorNormal);
	public void setContadorPreferencial(int contadorPreferencial);
	
	
}
