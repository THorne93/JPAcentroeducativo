package centroeducativo.controllers;

import java.util.List;

import centroeducativo.entities.Materia;
import centroeducativo.entities.Profesor;


public class ControladorProfesor extends SuperControladorJPA {

	
	private static ControladorProfesor instance = null;
	
	
	public ControladorProfesor() {
		super("profesor", Profesor.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorProfesor getInstance() {
		if (instance == null) {
			instance = new ControladorProfesor();
		}
		return instance;
	}
	
	
}
