package br.edu.ifpb.SIGV.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.edu.ifpb.SIGV.service.VeiculoService;

/**
 * Configuração da camada de serviço.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Configuration
@ComponentScan(basePackageClasses= VeiculoService.class)
public class ServiceConfig {

}
