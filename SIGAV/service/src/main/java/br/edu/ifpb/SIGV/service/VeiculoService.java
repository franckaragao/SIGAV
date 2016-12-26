package br.edu.ifpb.SIGV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.SIGAV.domain.Veiculo;
import br.edu.ifpb.SIGAV.repository.VeiculoRepository;

/**
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	/**
	 * 
	 * @param veiculo
	 * @return
	 */
	public Veiculo save(Veiculo veiculo){
		return veiculoRepository.save(veiculo);
	}

}
