package br.edu.ifpb.SIGV.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.edu.ifpb.SIGV.storage.FotoStorage;

/**
 * Registro de ouvintes para eventos relacionados
 * a veículo.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Component
public class VeiculoListener {
	
	@Autowired
	private FotoStorage fotoStorage;
	
	/**
	 * Recebe um event e executa uma tarefa.
	 * @param event
	 */
	@EventListener(condition="#event.foto")
	public void veiculoSalvo(VeiculoEvent event){
		
		fotoStorage.save(event.getVeiculo().getFoto());
		
	}

}
