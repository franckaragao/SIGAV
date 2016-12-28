package br.edu.ifpb.SIGAV.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.edu.ifpb.SIGV.exeptions.NomeFabricanteExistenteException;

/**
 * Controller advice tratar excessões lançadas que NÃO foram
 * tratadas pelos controllers. 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@ControllerAdvice
public class ControllerAdviceExceptionHandler {
	
	/**
	 * Trata excessão de nome de fabricante existente. 
	 * Caso um fabricante já cadastrado com um nome tente ser cadastrado/alterado.
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(NomeFabricanteExistenteException.class)
	public ResponseEntity<String> handleFabricanteExistenteException(NomeFabricanteExistenteException e){
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

	}
}
