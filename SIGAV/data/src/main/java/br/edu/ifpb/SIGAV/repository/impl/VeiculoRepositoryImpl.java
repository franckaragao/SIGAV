package br.edu.ifpb.SIGAV.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.edu.ifpb.SIGAV.domain.Veiculo;
import br.edu.ifpb.SIGAV.filter.VeiculoFilter;
import br.edu.ifpb.SIGAV.util.PaginationUtil;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class VeiculoRepositoryImpl {
	
	/**
	 * 
	 */
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PaginationUtil<Veiculo> paginationUtil;
	
	/**
	 * 
	 */
	public Page<Veiculo> filter(VeiculoFilter filter, Pageable pageable) {

		CriteriaBuilder criteria = em.getCriteriaBuilder();
		
		CriteriaQuery<Veiculo> query = criteria.createQuery(Veiculo.class);
		Root<Veiculo> root = query.from(Veiculo.class);
	    
	    query.select(root);
	    
	    List<Predicate> predicates = aplyFilter(filter, criteria, query, root);
	    
	    
	    if(predicates.size() > 0)
	    	query.where(criteria.and(predicates.toArray(new Predicate[]{})));
	    
	    paginationUtil.createOrder(pageable, criteria, query, root);
	    
	    List<Veiculo> results = paginationUtil.createPagination(pageable, query, em)
				.getResultList();
	    
	    long countRows = countRows(filter, criteria, predicates);

	    return new PageImpl<>(results, pageable, countRows);
	}
	
	/**
	 * 
	 * @param filter
	 * @return
	 */
	private Long countRows(VeiculoFilter filter, CriteriaBuilder criteria, List<Predicate> predicates) {
		
		CriteriaQuery<Long> cq = criteria.createQuery(Long.class);
		cq.select(criteria.count(cq.from(Veiculo.class)));
		
		cq.where(criteria.and(predicates.toArray(new Predicate[]{})));

		em.createQuery(cq);
		Long count = em.createQuery(cq).getSingleResult();
		
		return count;
	}

	/**
	 * 
	 * @param filter
	 */
	private List<Predicate> aplyFilter(VeiculoFilter filter, CriteriaBuilder criteria, CriteriaQuery<Veiculo> query, 
				Root<Veiculo> root) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(!StringUtils.isEmpty(filter.getPlaca()))
	    	predicates.add(criteria.like(root.get("placa"), "%"+filter.getPlaca().toUpperCase()+"%"));

	    if(!StringUtils.isEmpty(filter.getIdentificacao()))
	    	predicates.add(criteria.like(root.get("identificacao"), "%"+filter.getIdentificacao()+"%"));
	    
	    if(isFabricante(filter))
	    	predicates.add(criteria.equal(root.get("fabricante"), filter.getFabricante()));
	    
	    if(filter.getEspecieVeiculo() != null)
	    	predicates.add(criteria.equal(root.get("especieVeiculo"), filter.getEspecieVeiculo()));

	    if(filter.getOrigin() != null)
	    	predicates.add(criteria.equal(root.get("origin"), filter.getOrigin()));

	    if(filter.getNumeroDe() != null)
	    	predicates.add(criteria.ge(root.get("numeroLugares"), filter.getNumeroDe()));
	    
	    if(filter.getNumeroAte() != null)
	    	predicates.add(criteria.le(root.get("numeroLugares"), filter.getNumeroAte()));
	    
	  return predicates;
	}
	
	private boolean isFabricante(VeiculoFilter filter){
		return filter.getFabricante() != null && filter.getFabricante().getId() != null;
	}
	
}
