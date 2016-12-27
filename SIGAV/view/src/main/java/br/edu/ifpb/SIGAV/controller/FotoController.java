package br.edu.ifpb.SIGAV.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.edu.ifpb.SIGAV.dto.FotoDTO;
import br.edu.ifpb.SIGAV.storage.FotoStorageRunnable;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@RestController
@RequestMapping("/fotos")
public class FotoController {
	
	
	/**
	 * 
	 * @param files
	 * @return
	 */
	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files){
		
		DeferredResult<FotoDTO> result = new DeferredResult<>();
		
		Thread thread = new Thread(new FotoStorageRunnable(files, result));
		thread.start();
		
		return result;
	}

}
