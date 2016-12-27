package br.edu.ifpb.SIGAV.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.SIGAV.domain.Fabricante;

/**
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long>{
	
	/**
	 * 
	 * @param nome
	 * @return
	 */
	public Optional<Fabricante> findByNomeIgnoreCase(String nome);

}
