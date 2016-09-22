package br.edu.ifpb.SIGAV.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Controller
public class VeiculoController {
	
	@RequestMapping("/veiculos/novo")
	public String novo(){
		return "veiculo/cadastro_veiculo";
	}
}
