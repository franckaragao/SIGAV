package br.edu.ifpb.SIGAV.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.edu.ifpb.SIGAV.domain.Fabricante;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class FabricanteConverter implements Converter<String, Fabricante>{

	@Override
	public Fabricante convert(String id) {
		if (!StringUtils.isEmpty(id)) {		
			Fabricante fab = new Fabricante();
			fab.setId(Long.valueOf(id));
			return fab;
		}
		
		return null;
	}

}
