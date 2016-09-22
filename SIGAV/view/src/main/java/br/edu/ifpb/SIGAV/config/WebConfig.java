package br.edu.ifpb.SIGAV.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.edu.ifpb.SIGAV.controller.VeiculoController;

/**
 * Configuração web para mapeamento dos controllers
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Configuration
@ComponentScan(basePackageClasses = {VeiculoController.class})
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{

}
