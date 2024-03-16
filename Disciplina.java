package ca;

public class Disciplina {
	private String nome, id;

	protected Disciplina(String nome, String id) {
		this.nome = nome;
		this.id = id;
	}

	// Getters
	
	protected String getNome() {
		return nome;
	}

	protected String getId() {
		return id;
	}

}
