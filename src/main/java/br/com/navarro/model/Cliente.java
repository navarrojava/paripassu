package br.com.navarro.model;

public class Cliente extends Usuario {

	private Senha senha;

	public Senha getSenha() {
		return senha;
	}

	public void setSenha(Senha senha) {
		this.senha = senha;
	}
}
