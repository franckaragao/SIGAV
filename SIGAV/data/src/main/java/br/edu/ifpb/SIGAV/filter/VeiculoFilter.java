package br.edu.ifpb.SIGAV.filter;

import br.edu.ifpb.SIGAV.domain.Fabricante;
import br.edu.ifpb.SIGAV.enumerations.EspecieVeiculo;
import br.edu.ifpb.SIGAV.enumerations.Origin;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class VeiculoFilter {

	private String placa;

	private String identificacao;

	private Fabricante fabricante;

	private EspecieVeiculo especieVeiculo;

	private Origin origin;

	private Integer numeroDe;

	private Integer numeroAte;

	public VeiculoFilter() {

	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public EspecieVeiculo getEspecieVeiculo() {
		return especieVeiculo;
	}

	public void setEspecieVeiculo(EspecieVeiculo especieVeiculo) {
		this.especieVeiculo = especieVeiculo;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public Integer getNumeroDe() {
		return numeroDe;
	}

	public void setNumeroDe(Integer numeroDe) {
		this.numeroDe = numeroDe;
	}

	public Integer getNumeroAte() {
		return numeroAte;
	}

	public void setNumeroAte(Integer numeroAte) {
		this.numeroAte = numeroAte;
	}

	@Override
	public String toString() {
		return "VeiculoFilter [placa=" + placa + ", identificacao=" + identificacao + ", fabricante=" + fabricante
				+ ", especieVeiculo=" + especieVeiculo + ", origin=" + origin + ", numeroDe=" + numeroDe
				+ ", numeroAte=" + numeroAte + "]";
	}

}
