package br.edu.ifpb.SIGV.event;

import org.springframework.util.StringUtils;

import br.edu.ifpb.SIGAV.domain.Veiculo;

/**
 * Classe de eventos.
 * Utilizado quando alguma operação acontencer.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class VeiculoEvent {

	private Veiculo veiculo;

	public VeiculoEvent(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public boolean isFoto(){
		return !StringUtils.isEmpty(veiculo.getFoto());
	}

}
