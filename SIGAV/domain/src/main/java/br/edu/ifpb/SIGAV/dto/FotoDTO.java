package br.edu.ifpb.SIGAV.dto;

/**
 * Foto DTO (Data Transferer Object).
 * 
 * Para trabalhar com transferencia de informações 
 * de uma foto.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class FotoDTO {

	private String nome;
	private String contentType;
	
	public FotoDTO(String nome, String contentType) {
		this.nome = nome;
		this.contentType = contentType;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
