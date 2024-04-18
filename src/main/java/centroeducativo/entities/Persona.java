package centroeducativo.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nombre;
	private String pApellido;
	private String sApellido;
	private String dni;
	private String direccion;
	private String email;
	private String telefono;
	private int tipoSexo;
	private byte[] image;
	private String color;
	
	public Persona() {
		super();
	}
	
	public Persona(int id, String nombre, String pApellido, String sApellido, String dni, String direccion, String email,
			String telefono, int tipoSexo, byte[] image, String color) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pApellido = pApellido;
		this.sApellido = sApellido;
		this.dni = dni;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
		this.tipoSexo = tipoSexo;
		this.image = image;
		this.color = color;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getpApellido() {
		return pApellido;
	}
	public void setpApellido(String pApellido) {
		this.pApellido = pApellido;
	}
	public String getsApellido() {
		return sApellido;
	}
	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(int tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return nombre +" " +pApellido + " " +sApellido;
	}
	
}
