package br.com.navarro.model;

import org.springframework.stereotype.Component;

@Component
public class Senha {
	
	private  int id;
	private int numero;
	private TipoSenha tipoSenha;
	private String mascaraSenha;
	
	
	public Senha(){
		
	}
	
	public Senha(int id, int numero, TipoSenha tipoSenha, String mascaraSenha) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipoSenha = tipoSenha;
		this.mascaraSenha = mascaraSenha;
	}
	
	
	public enum TipoSenha {
		N, P, GERAL;
	}
	
	
	public String formataSenha(TipoSenha tipoSenha,  int numeroSenha){
		
		switch (numeroSenha) {
		case  10:
			
			break;

		default:
			break;
		}
		
		return mascaraSenha;
	}
	
	/* Getters and Setters*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public TipoSenha getTipoSenha() {
		return tipoSenha;
	}
	public void setTipoSenha(TipoSenha tipoSenha) {
		this.tipoSenha = tipoSenha;
	}

	public String getMascaraSenha() {
		return mascaraSenha;
	}

	public void setMascaraSenha(String mascaraSenha) {
		this.mascaraSenha = mascaraSenha;
	}
}
