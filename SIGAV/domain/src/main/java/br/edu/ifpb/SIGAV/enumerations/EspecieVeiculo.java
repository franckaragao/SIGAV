package br.edu.ifpb.SIGAV.enumerations;

public enum EspecieVeiculo {
	
	AUTOMOVEL("Automóvel"),
	VAN("Van"),
	MICRO_ONIBUS("Microônibus"),
	ONIBUS("ônibus"),
	MOTOCICLETA("Motocicleta"),
	TRICICLO("Triciclo"),
	QUADRICICLO("Quadriciclo"),
	DE_CARGA("De Carga"),
	TRATOR("Trator"),
	MISTOS("Mistos");
	
	private String description;
	
	private EspecieVeiculo(String desciption) {
		this.description = desciption;
	}

	public String getDescription() {
		return description;
	}
	
}
