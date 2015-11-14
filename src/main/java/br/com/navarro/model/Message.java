package br.com.navarro.model;
/**
 * 
 * @author navarro
 *
 */
public class Message {
	
	private int id;
	private String Mensagem;
	
	
	
	
	
	
	
	public Message(int id, String mensagem) {
		super();
		this.id = id;
		Mensagem = mensagem;
	}
	
	
	/*  GEtters e Setters   */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMensagem() {
		return Mensagem;
	}
	public void setMensagem(String mensagem) {
		Mensagem = mensagem;
	}

	
}
