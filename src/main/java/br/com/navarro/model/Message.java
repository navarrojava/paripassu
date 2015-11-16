package br.com.navarro.model;

/**
 * 
 * @author navarro
 *
 */

public class Message {
	
	private int id;
	private String mensagem;
	
	public Message(int id, String mensagem) {
		super();
		this.id = id;
		this.mensagem = mensagem;
	}
	
	/*  Getters e Setters   */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
