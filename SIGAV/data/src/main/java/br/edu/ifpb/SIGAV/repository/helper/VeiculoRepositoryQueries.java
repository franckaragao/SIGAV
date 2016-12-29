package br.edu.ifpb.SIGAV.repository.helper;

import java.util.List;

import br.edu.ifpb.SIGAV.domain.Veiculo;
import br.edu.ifpb.SIGAV.filter.VeiculoFilter;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public interface VeiculoRepositoryQueries{
	
	/**
	 * 
	 * @param filter
	 * @return
	 */
	List<Veiculo> filter(VeiculoFilter filter);

}
