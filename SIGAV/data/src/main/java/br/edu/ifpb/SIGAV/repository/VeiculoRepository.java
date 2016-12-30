package br.edu.ifpb.SIGAV.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.SIGAV.domain.Veiculo;
import br.edu.ifpb.SIGAV.filter.VeiculoFilter;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	/**
	 * 
	 * @param filter
	 * @param pageable 
	 * @return
	 */
	Page<Veiculo> filter(VeiculoFilter filter, Pageable pageable);
	
	

}
