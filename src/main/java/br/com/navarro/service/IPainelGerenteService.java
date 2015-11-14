package br.com.navarro.service;

import java.util.List;

import br.com.navarro.model.Message;
import br.com.navarro.model.Senha;

public interface IPainelGerenteService {
	

	public Senha chamaProximaSenha() ;
	public List<Senha> todasAsSenhas() ;
    public Message  zeraContadorSenha();
	

}
