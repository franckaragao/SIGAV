package br.edu.ifpb.SIGAV.enumerations;

public enum Origin {
	
	OWN("Próprio"),
	ALLOCATED("Alocado");
	
	private String description;
	
	private Origin(String desciption) {
		this.description = desciption;
	}

	public String getDescription() {
		return description;
	}
	
}
