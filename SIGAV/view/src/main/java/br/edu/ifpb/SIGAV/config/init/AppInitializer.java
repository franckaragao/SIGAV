package br.edu.ifpb.SIGAV.config.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.edu.ifpb.SIGAV.config.WebConfig;

/**
 * Configuração do Dispatcher servlet (Front Controller do spring)
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Mapeia controllers para o Dispather servlet
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	/**
	 * padrão de URL que será delegado para o Dispatcher servlet.
	 * 
	 * Mapeia para o Dispather servlet apartir do nome do projeto.
	 * 
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
