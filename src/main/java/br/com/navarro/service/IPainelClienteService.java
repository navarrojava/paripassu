package br.com.navarro.service;

import br.com.navarro.model.Senha;

public interface IPainelClienteService {
	public Senha solicitaSenha(Senha.TipoSenha tipo);
	public Senha verificaSeFoiChamado(Senha senha);
}
