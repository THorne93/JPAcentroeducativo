package centroeducativo.view;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import centroeducativo.controllers.ControladorMateriaJPA;
import centroeducativo.controllers.ControladorProfesor;
import centroeducativo.controllers.ControllerEstudiante;
import centroeducativo.controllers.ControllerValoracion;
import centroeducativo.controllers.SuperControladorJPA;
import centroeducativo.entities.Entidad;
import centroeducativo.entities.Estudiante;
import centroeducativo.entities.Materia;
import centroeducativo.entities.Profesor;
import centroeducativo.entities.Valoracion;

import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class PanelValoracion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JComboBox<Integer> jcbNota;
	JComboBox<Materia> jcbMateria;
	JComboBox<Profesor> jcbProfesor;
	private List<Estudiante> estudiantes = (List<Estudiante>) ControllerEstudiante.getInstance().findAll();
	private JList jlistEstudiantes;
	private JList jlistEstudiantesSeleccionado;
	private DefaultListModel<Estudiante> listModelEstudiantes = null;
	private DefaultListModel<Estudiante> listModelEstudiantesSeleccionado = null;
	private JFormattedTextField jftf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelValoracion frame = new PanelValoracion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelValoracion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbMateria = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel_1.add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel_1.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbNota = new JComboBox<Integer>();
		for (int i = 1; i < 11; i++) {
			jcbNota.addItem(i);
		}
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel_1.add(jcbNota, gbc_jcbNota);
		
		JButton jbuttonRefresh = new JButton("Refrescar");
		jbuttonRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshEstudiantes();
			}


		});
		
		JLabel lblNewLabel_5 = new JLabel("Fecha:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		jftf = new JFormattedTextField(sdf);
		jftf.setColumns(20);
		jftf.setValue(new Date());

		
		GridBagConstraints gbc_jftf = new GridBagConstraints();
		gbc_jftf.anchor = GridBagConstraints.WEST;
		gbc_jftf.insets = new Insets(0, 0, 5, 0);
		gbc_jftf.gridx = 1;
		gbc_jftf.gridy = 3;
		panel_1.add(jftf, gbc_jftf);
		GridBagConstraints gbc_jbuttonRefresh = new GridBagConstraints();
		gbc_jbuttonRefresh.anchor = GridBagConstraints.EAST;
		gbc_jbuttonRefresh.gridx = 1;
		gbc_jbuttonRefresh.gridy = 4;
		panel_1.add(jbuttonRefresh, gbc_jbuttonRefresh);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_3 = new JLabel("Estudiantes NO seleccionado");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Estudiantes Seleccionado");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jlistEstudiantes = new JList(this.getDefaultListModel());
		this.jlistEstudiantes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Valor por defecto
		JScrollPane scrollJList = new JScrollPane(jlistEstudiantes);

		GridBagConstraints gbc_jlistEstudiantes = new GridBagConstraints();
		gbc_jlistEstudiantes.insets = new Insets(0, 0, 0, 5);
		gbc_jlistEstudiantes.fill = GridBagConstraints.BOTH;
		gbc_jlistEstudiantes.gridx = 0;
		gbc_jlistEstudiantes.gridy = 1;
		panel.add(scrollJList, gbc_jlistEstudiantes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 0));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnNewButton_3 = new JButton("<<");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarTodo();
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 1;
		panel_2.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("<");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarAlumno();
			}
		});
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 2;
		panel_2.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton(">");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAlumno();
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 3;
		panel_2.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_2 = new JButton(">>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTodo();
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 4;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
		
		
		jlistEstudiantesSeleccionado = new JList(this.getDefaultListModel2());
		this.jlistEstudiantesSeleccionado.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane scrollJList2 = new JScrollPane(jlistEstudiantesSeleccionado);
		GridBagConstraints gbc_jlistEstudiantesSeleccionado = new GridBagConstraints();
		gbc_jlistEstudiantesSeleccionado.fill = GridBagConstraints.BOTH;
		gbc_jlistEstudiantesSeleccionado.gridx = 2;
		gbc_jlistEstudiantesSeleccionado.gridy = 1;
		panel.add(scrollJList2, gbc_jlistEstudiantesSeleccionado);
		
		JButton btnNewButton = new JButton("Guardar las notas.......");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guardar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		cargarProfesores();
		cargarMaterias();
		cargarEstudiantes();
	}
	
	private void cargarMaterias() {
		List<Materia> l = (List<Materia>) ControladorMateriaJPA.getInstance().findAll();
		
		for (Materia o : l) {
			jcbMateria.addItem(o);
		}
	}

	private void cargarEstudiantes() {
		for (int i = 0; i < estudiantes.size(); i++) {
			this.listModelEstudiantes.addElement(this.estudiantes.get(i));
		}

	}
	private void cargarProfesores() {
	
			List<Profesor> l = (List<Profesor>) ControladorProfesor.getInstance().findAll();

			for (Profesor o : l) {
				jcbProfesor.addItem(o);
			}
	
	}
	
	private void refreshEstudiantes() {
		int idProf = jcbProfesor.getSelectedIndex()+1;
		int idMat = jcbMateria.getSelectedIndex()+1;
		int idNota = (int) jcbNota.getSelectedItem();
		

		List<Valoracion> v = ControllerValoracion.getInstance().getNotas(idProf, idMat, idNota);
		this.listModelEstudiantesSeleccionado.removeAllElements();
		this.listModelEstudiantes.removeAllElements();
		cargarEstudiantes();
		for (int i = 0; i < estudiantes.size(); i++) {
			for (int j = 0; j < v.size(); j++) {
				if (v.get(j).getEstudiante().getId() == estudiantes.get(i).getId()) {
					this.listModelEstudiantesSeleccionado.addElement(this.estudiantes.get(i));
					this.listModelEstudiantes.removeElement(this.estudiantes.get(i));
				}
			}
		}
		
	}

	private DefaultListModel getDefaultListModel () {
		this.listModelEstudiantes = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantes;
	
	}
	
	/*
	 * alumnos seleccionado
	 */
	private DefaultListModel getDefaultListModel2 () {
		this.listModelEstudiantesSeleccionado = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantesSeleccionado;
	
	}
	
	private void quitarAlumno() {
		
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		for (int i = 0; i < this.jlistEstudiantesSeleccionado.getSelectedIndices().length; i++) {
			l.add(this.listModelEstudiantesSeleccionado.getElementAt(this.jlistEstudiantesSeleccionado.getSelectedIndices()[i]));
		}
		for (int i = this.jlistEstudiantesSeleccionado.getSelectedIndices().length - 1; i>=0; i--) {
			this.listModelEstudiantesSeleccionado.removeElementAt((this.jlistEstudiantesSeleccionado.getSelectedIndices()[i]));
		}

		for (Estudiante e : l) {
			this.listModelEstudiantes.addElement(e);
		}
	}
	
	private void addAlumno() {
		List<Estudiante> l = new ArrayList<Estudiante>();
		
		for (int i = 0; i < this.jlistEstudiantes.getSelectedIndices().length; i++) {
			l.add(this.listModelEstudiantes.getElementAt(this.jlistEstudiantes.getSelectedIndices()[i]));
		}
		for (int i = this.jlistEstudiantes.getSelectedIndices().length - 1; i>=0; i--) {
			this.listModelEstudiantes.removeElementAt((this.jlistEstudiantes.getSelectedIndices()[i]));
		}

		for (Estudiante e : l) {
			this.listModelEstudiantesSeleccionado.addElement(e);
		}
	}
	
	private void addTodo() {
		this.listModelEstudiantesSeleccionado.removeAllElements();
		this.listModelEstudiantes.removeAllElements();
		for (int i = 0; i < estudiantes.size() ; i++) {
			this.listModelEstudiantesSeleccionado.addElement(this.estudiantes.get(i));
		}
	}
	
	private void quitarTodo() {
		this.listModelEstudiantesSeleccionado.removeAllElements();
		this.listModelEstudiantes.removeAllElements();
		cargarEstudiantes();
	}
	
	private void guardar() throws SQLException {
		Profesor p = (Profesor) jcbProfesor.getSelectedItem();
		Materia m = (Materia) jcbMateria.getSelectedItem();
		int idNota = (int) jcbNota.getSelectedItem();
		Date f = (Date) jftf.getValue();
		
		for (int i = 0; i < this.listModelEstudiantesSeleccionado.size(); i++) {
			Estudiante e = this.listModelEstudiantesSeleccionado.get(i);
			Valoracion v = new Valoracion();
			v = ControllerValoracion.getNotaSingular(e.getId(), p.getId(), m.getId());
			if (v != null) {
				v.setFecha(f);
				v.setValoracion(idNota);
				ControllerValoracion.getInstance().update(v);
				}
			else {
				v = new Valoracion();
				v.setFecha(f);
				v.setEstudiante(e);
				v.setMateria(m);
				v.setProfesor(p);
				v.setValoracion(idNota);
				ControllerValoracion.getInstance().insert(v);
			}
			}
		
		for (int i = 0; i < this.listModelEstudiantes.size(); i++) {
			Estudiante e = this.listModelEstudiantes.get(i);
			Valoracion v = new Valoracion();
			v = ControllerValoracion.getNotaSingularDelete(e.getId(), p.getId(), m.getId(),idNota);
			if (v != null) {
				ControllerValoracion.getInstance().delete(v);
				}
		}
	
}
}
