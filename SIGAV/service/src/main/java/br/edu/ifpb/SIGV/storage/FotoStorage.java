package br.edu.ifpb.SIGV.storage;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public interface FotoStorage {
	
	/**
	 * 
	 * @param files
	 * @return 
	 */
	String saveLocalTemp(MultipartFile files[]);
	
	void save(String foto);

	byte[] getFotoTemporaria(String name);

	byte[] getFoto(String foto);

}
