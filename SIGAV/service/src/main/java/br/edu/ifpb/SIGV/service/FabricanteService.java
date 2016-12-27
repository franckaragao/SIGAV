package br.edu.ifpb.SIGV.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.SIGAV.domain.Fabricante;
import br.edu.ifpb.SIGAV.repository.FabricanteRepository;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Service
public class FabricanteService {
	
	@Autowired
	private FabricanteRepository fabricanteRepository;
	
	
	/**
	 * 
	 * @param fabricante
	 * @return
	 */
	@Transactional
	public Fabricante save(Fabricante fabricante){
		return fabricanteRepository.save(fabricante);
	}

}
