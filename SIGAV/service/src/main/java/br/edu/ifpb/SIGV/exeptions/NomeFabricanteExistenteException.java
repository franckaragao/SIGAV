package br.edu.ifpb.SIGV.exeptions;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class NomeFabricanteExistenteException extends RuntimeException  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param msg
	 */
	public NomeFabricanteExistenteException(String msg) {
		super(msg);
	}

}
