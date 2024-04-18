package centroeducativo.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import centroeducativo.entities.Entidad;
import centroeducativo.entities.Materia;
import centroeducativo.entities.Profesor;
import centroeducativo.entities.Valoracion;

public class ControllerValoracion extends SuperControladorJPA {

	private static ControllerValoracion instance = null;

	public ControllerValoracion() {
		super("valoracionmateria", Valoracion.class);
	}

	public List<Valoracion> getNotas(int idProfesor, int idMateria, int idNota) {
		return (List<Valoracion>) getEntityManager()
				.createNativeQuery(
						"SELECT * FROM valoracionmateria where idProfesor = " + idProfesor + " and idMateria = "
								+ idMateria + " and valoracion between " + (idNota - 0.5) + " and " + (idNota + 0.49),
						Valoracion.class)
				.getResultList();

	}

	public static Valoracion getNotaSingular(int idEstudiante, int idProfesor, int idMateria) throws SQLException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroEducativo");

		EntityManager em = entityManagerFactory.createEntityManager();
		Valoracion v = new Valoracion();
		try {
			Query q = em.createNativeQuery(
					"SELECT * FROM valoracionmateria where idProfesor = ? and idEstudiante = ? and idMateria = ?",
					Valoracion.class);
			q.setParameter(1, idProfesor);
			q.setParameter(2, idEstudiante);
			q.setParameter(3, idMateria);
			v = (Valoracion) q.getSingleResult();

		} catch (Exception e) {
			return null;
		}

		em.close();
		return v;

	}

	public static Valoracion getNotaSingularDelete(int idEstudiante, int idProfesor, int idMateria, int nota)
			throws SQLException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("centroEducativo");

		EntityManager em = entityManagerFactory.createEntityManager();
		Valoracion v = new Valoracion();
		try {
			Query q = em.createNativeQuery(
					"SELECT * FROM valoracionmateria where idProfesor = ? and idEstudiante = ? and idMateria = ? and valoracion = ?",
					Valoracion.class);
			q.setParameter(1, idProfesor);
			q.setParameter(2, idEstudiante);
			q.setParameter(3, idMateria);
			q.setParameter(4, nota);
			v = (Valoracion) q.getSingleResult();

		} catch (Exception e) {
			return null;
		}

		em.close();
		return v;

	}

	/**
	 * Singleton
	 * 
	 * @return
	 */
	public static ControllerValoracion getInstance() {
		if (instance == null) {
			instance = new ControllerValoracion();
		}
		return instance;
	}

	public void update(Valoracion v) {
		EntityManager em = getEntityManager();

		em.getTransaction().begin();
		em.merge(v);
		em.getTransaction().commit();
	}

	public void insert(Valoracion v) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(v);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}

	public void delete(Valoracion v) {
		EntityManager em = getEntityManager();

		try {
			em.getTransaction().begin();
			Valoracion o = em.merge(v);
			em.remove(o);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}

	}
}
