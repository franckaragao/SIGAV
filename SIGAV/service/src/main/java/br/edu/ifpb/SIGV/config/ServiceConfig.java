package br.edu.ifpb.SIGV.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.edu.ifpb.SIGV.VeiculoService;
import br.edu.ifpb.SIGV.storage.FotoStorage;
import br.edu.ifpb.SIGV.storage.local.FotoStorageLocal;

/**
 * Configuração da camada de serviço.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Configuration
@ComponentScan(basePackageClasses= VeiculoService.class)
public class ServiceConfig {
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public FotoStorage fotoStorage(){
		return new FotoStorageLocal();
	}

}
