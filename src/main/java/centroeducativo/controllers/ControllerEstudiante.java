package centroeducativo.controllers;

import java.util.List;
import centroeducativo.entities.Estudiante;



public class ControllerEstudiante extends SuperControladorJPA {

	
	private static ControllerEstudiante instance = null;
	
	
	public ControllerEstudiante() {
		super("estudiante", Estudiante.class);
	}
	
	
	/**
	 * Singleton
	 * @return
	 */
	public static ControllerEstudiante getInstance() {
		if (instance == null) {
			instance = new ControllerEstudiante();
		}
		return instance;
	}
	
	
}
