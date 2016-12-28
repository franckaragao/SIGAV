package br.edu.ifpb.SIGV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.SIGAV.domain.Veiculo;
import br.edu.ifpb.SIGAV.repository.VeiculoRepository;
import br.edu.ifpb.SIGV.service.event.VeiculoEvent;

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

	@Autowired
	private ApplicationEventPublisher publisher;

	/**
	 * Salva um veículo e registra um evento após essa operação.
	 * 
	 * @param veiculo
	 * @return
	 */
	@Transactional
	public Veiculo save(Veiculo veiculo) {

		veiculo = veiculoRepository.save(veiculo);

		publisher.publishEvent(new VeiculoEvent(veiculo));

		return veiculo;
	}

}
