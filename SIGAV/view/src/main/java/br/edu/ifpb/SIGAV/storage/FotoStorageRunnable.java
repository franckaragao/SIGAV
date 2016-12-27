package br.edu.ifpb.SIGAV.storage;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.edu.ifpb.SIGAV.dto.FotoDTO;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class FotoStorageRunnable implements Runnable{
	
	private MultipartFile[] files;
	private DeferredResult<FotoDTO> result;
	
	/**
	 * 
	 * @param files
	 * @param result
	 */
	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> result) {
		this.files = files;
		this.result = result;
	}

	@Override
	public void run() {
		
		String fileName = files[0].getOriginalFilename();
		String contentType = files[0].getContentType();
		
		result.setResult(new FotoDTO(fileName, contentType));
		
	}

}
