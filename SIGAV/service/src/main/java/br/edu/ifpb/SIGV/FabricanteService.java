package br.edu.ifpb.SIGV;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpb.SIGAV.domain.Fabricante;
import br.edu.ifpb.SIGAV.repository.FabricanteRepository;
import br.edu.ifpb.SIGV.exeptions.NomeFabricanteExistenteException;

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
		Optional<Fabricante> fabricanteOptional = fabricanteRepository
				.findByNomeIgnoreCase(fabricante.getNome());
		
		if(fabricanteOptional.isPresent())
			throw new NomeFabricanteExistenteException("Nome de fabricante já cadastrado.");
		
		return fabricanteRepository.save(fabricante);
	}
}
