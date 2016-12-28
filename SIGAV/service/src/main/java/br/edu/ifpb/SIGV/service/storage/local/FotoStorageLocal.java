package br.edu.ifpb.SIGV.service.storage.local;

import java.io.IOException;
import static java.nio.file.FileSystems.getDefault;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import br.edu.ifpb.SIGV.service.storage.FotoStorage;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class FotoStorageLocal implements FotoStorage{
	
	private Logger LOGGER = LoggerFactory.getLogger(FotoStorageLocal.class);
	
	
	private Path local;
	private Path localTemp;
	
	public FotoStorageLocal() {
		this(getDefault().getPath(System.getenv("HOME"), ".sigav"));
	}
	
	public FotoStorageLocal(Path path) {
		this.local = path;
		creatFolders();
	}

	/**
	 * 
	 */
	private void creatFolders() {
		try {
			Files.createDirectories(this.local);
			this.localTemp = getDefault().getPath(this.local.toString(), "temp");
			Files.createDirectories(this.localTemp);
			
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Pastas criadas para salvar fotos.");
				LOGGER.debug("Pasta default: " + this.local.toAbsolutePath());
				LOGGER.debug("Pasta temporária: " + this.localTemp.toAbsolutePath());
			}
		} catch (IOException e) {
			throw new RuntimeException("Erro criando pasta para salvar foto", e);
		}
	}

	@Override
	public void saveLocalTemp(MultipartFile[] files) {
		System.out.println("Salvando temporariamente");
	}
}
