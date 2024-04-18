package centroeducativo.controllers;

import java.util.List;

import centroeducativo.entities.Materia;


public class ControladorMateriaJPA extends SuperControladorJPA {

	
	private static ControladorMateriaJPA instance = null;
	
	
	public ControladorMateriaJPA() {
		super("materia", Materia.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControladorMateriaJPA getInstance() {
		if (instance == null) {
			instance = new ControladorMateriaJPA();
		}
		return instance;
	}
	
	
}
