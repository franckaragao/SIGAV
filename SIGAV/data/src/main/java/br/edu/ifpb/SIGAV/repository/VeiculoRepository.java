package br.edu.ifpb.SIGAV.repository;

import java.util.List;

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
	
	List<Veiculo> filter(VeiculoFilter filter);
	
	

}
