package br.edu.ifpb.SIGAV.controller.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Wrapper de Page adicionando metódo que mantém a url,
 * na paginação.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 * @param <T>
 */
public class PageWrapper<T> {

	private Page<T> page;
	private UriComponentsBuilder uriBuilder;
	
	/**
	 * 
	 * @param page
	 * @param httpServletRequest
	 */
	public PageWrapper(Page<T> page, HttpServletRequest httpServletRequest) {
		this.page = page;
		this.uriBuilder = ServletUriComponentsBuilder.fromRequest(httpServletRequest);
	}

	public List<T> getContent(){
		return page.getContent();
	}
	
	public int getNumber() {
		return page.getNumber();
	}

	public int getSize() {
		return page.getSize();
	}

	public boolean isFirst() {
		return page.isFirst();
	}

	public boolean isLast() {
		return page.isLast();
	}

	public int getTotalPages() {
		return page.getTotalPages();
	}

	public long getTotalElements() {
		return page.getTotalElements();
	}
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	public String urlTo(int page) {
		return uriBuilder.replaceQueryParam("page", page).build(true).encode().toUriString();
	}
}
