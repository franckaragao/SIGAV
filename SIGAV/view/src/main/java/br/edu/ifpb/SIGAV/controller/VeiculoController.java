package br.edu.ifpb.SIGAV.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifpb.SIGAV.domain.Veiculo;
import br.edu.ifpb.SIGAV.repository.Veiculos;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Controller
public class VeiculoController {
	
	@Autowired
	private Veiculos veiculos;
	
	@RequestMapping("/veiculos/novo")
	public String novo(){
		veiculos.findAll();
		return "veiculo/cadastro_veiculo";
	}
	
	@RequestMapping(value = "/veiculos/novo", method = RequestMethod.POST)
	public String save(@Valid Veiculo veiculo){
		System.out.println(veiculo.getIdentificacao());
		return "veiculo/cadastro_veiculo";
	}
	
}
