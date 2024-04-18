package centroeducativo.controllers;

import java.util.List;
import centroeducativo.entities.Entidad;
import centroeducativo.entities.Valoracion;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SuperControladorJPA {

	private static EntityManager em = null;
	private String nombreTabla = "";
	private Class tipoEntidad;
	
	/**
	 * 
	 * @param nombreTabla
	 */
	public SuperControladorJPA (String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	
	
	/**
	 * 
	 * @return
	 */
	protected EntityManager getEntityManager () {
		if (em == null) {
			em = Persistence.createEntityManagerFactory("centroEducativo")
				.createEntityManager();
		}
		return em;
	}
	
	
	/**
	 * 
	 */
	@SuppressWarnings(value = { "unchecked" })
	public List<? extends Entidad> findAll () {
		return (List<Entidad>) 
		getEntityManager()
		.createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad)
		.getResultList();
	}
	
	
	/**
	 * 
	 */
	public void update (Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public void insert (Entidad e) {
		EntityManager em = getEntityManager();
		
		try {
			em.persist(e);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}



}
