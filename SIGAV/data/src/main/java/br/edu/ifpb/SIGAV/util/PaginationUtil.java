package br.edu.ifpb.SIGAV.util;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * Classe utilitaria para recursos de paginação
 * e ordenação em buscas.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 * @param <T>
 */
@Component
public class PaginationUtil<T>{
	
	
	/**
	 * Adiciona aordenação asc/desc.
	 * 
	 * @param pageable
	 * @param criteria
	 * @param query
	 * @param root
	 */
	public void createOrder(Pageable pageable,CriteriaBuilder criteria, 
				CriteriaQuery<T> query, Root<T> root ){
		
	    Sort sort = pageable.getSort();
	    if(sort != null){
	    	Sort.Order order = sort.iterator().next();
	    	String property = order.getProperty();
	    	
	    	if(order.isAscending()){
	    		query.orderBy(criteria.asc(root.get(property)));
	    	}else{
	    		query.orderBy(criteria.desc(root.get(property)));
	    	}
	    }
		
	}
	
	/**
	 * Cria paginação para qualquer entidade.
	 * 
	 * @param pageable
	 * @param query
	 * @param em
	 * @return
	 */
	public TypedQuery<T> createPagination(Pageable pageable, CriteriaQuery<T> query, EntityManager em){
		
		TypedQuery<T> result = em.createQuery(query)
				.setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
				.setMaxResults(pageable.getPageSize());
		
		return result;
	}

}
