package br.edu.ifpb.SIGAV.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifpb.SIGAV.domain.Fabricante;
import br.edu.ifpb.SIGV.FabricanteService;

/**
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Controller
@RequestMapping("/fabricantes")
public class FabricanteController {
	
	@Autowired
	private FabricanteService fabricanteService;
	
	/**
	 * 
	 * @param fabricante
	 * @param result
	 * @param model
	 * @param attributes
	 */
	@RequestMapping(method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> save(@Valid @RequestBody Fabricante fabricante, BindingResult result){
		
		if(result.hasErrors()){
			return new ResponseEntity<>(result.getFieldError("nome").getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
			
		fabricante = fabricanteService.save(fabricante);
		
		return new ResponseEntity<>(fabricante, HttpStatus.OK);

	}

}
