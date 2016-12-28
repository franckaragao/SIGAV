package br.edu.ifpb.SIGV.service.storage;

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
	private FotoStorage fotoStorage;
	
	/**
	 * 
	 * @param files
	 * @param result
	 */
	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> result, FotoStorage fotoStorage) {
		this.files = files;
		this.result = result;
		this.fotoStorage = fotoStorage;
	}

	@Override
	public void run() {
		
		String contentType = files[0].getContentType();
		String fileName = fotoStorage.saveLocalTemp(files);
		
		result.setResult(new FotoDTO(fileName, contentType));
		
	}

}
