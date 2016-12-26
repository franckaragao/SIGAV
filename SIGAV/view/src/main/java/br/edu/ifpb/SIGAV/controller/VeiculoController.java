package br.edu.ifpb.SIGAV.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.SIGAV.domain.Veiculo;
import br.edu.ifpb.SIGAV.enumerations.EspecieVeiculo;
import br.edu.ifpb.SIGV.service.VeiculoService;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Controller
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping("/veiculos/novo")
	public ModelAndView novo(Veiculo veiculo){
		ModelAndView mv = new ModelAndView("veiculo/cadastro_veiculo");
		mv.addObject("especies", EspecieVeiculo.values());
		return mv;
	}
	
	@RequestMapping(value = "/veiculos/novo", method = RequestMethod.POST)
	public ModelAndView save(@Valid Veiculo veiculo, BindingResult result, Model model, RedirectAttributes attributes){
		if(result.hasErrors()){
			model.addAttribute(veiculo);
			return novo(veiculo);
		}
		veiculoService.save(veiculo);
		attributes.addAttribute("message", "Veículo cadastrado com sucesso");
		return new ModelAndView("redirect:/veiculos/novo");
	}
	
}
