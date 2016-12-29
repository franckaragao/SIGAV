package br.edu.ifpb.SIGAV.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.edu.ifpb.SIGAV.domain.Veiculo;
import br.edu.ifpb.SIGAV.filter.VeiculoFilter;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class VeiculoRepositoryImpl {
	
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 */
	public List<Veiculo> filter(VeiculoFilter filter) {

		CriteriaBuilder criteria = em.getCriteriaBuilder();
		
		CriteriaQuery<Veiculo> query = criteria.createQuery(Veiculo.class);
		Root<Veiculo> root = query.from(Veiculo.class);
	    List<Predicate> predicates = new ArrayList<Predicate>();
	    
	    query.select(root);
	    
	    if(!StringUtils.isEmpty(filter.getPlaca()))
	    	predicates.add(criteria.like(root.get("placa"), "%"+filter.getPlaca().toUpperCase()+"%"));

	    if(!StringUtils.isEmpty(filter.getIdentificacao()))
	    	predicates.add(criteria.like(root.get("identificacao"), "%"+filter.getIdentificacao()+"%"));
	    
	    if(!StringUtils.isEmpty(filter.getFabricante()))
	    	predicates.add(criteria.equal(root.get("fabricante"), filter.getFabricante()));
	    
	    if(!StringUtils.isEmpty(filter.getEspecieVeiculo()))
	    	predicates.add(criteria.equal(root.get("especieVeiculo"), filter.getEspecieVeiculo()));

	    if(!StringUtils.isEmpty(filter.getOrigin()))
	    	predicates.add(criteria.equal(root.get("origin"), filter.getOrigin()));

	    if(filter.getNumeroDe() != null)
	    	predicates.add(criteria.ge(root.get("numeroLugares"), filter.getNumeroDe()));
	    
	    if(filter.getNumeroAte() != null)
	    	predicates.add(criteria.le(root.get("numeroLugares"), filter.getNumeroAte()));
	    
	    
	    
	    if(predicates.size() > 0)
	    	query.where(criteria.and(predicates.toArray(new Predicate[]{})));
	    
		return em.createQuery(query).getResultList();
	}
	
}
