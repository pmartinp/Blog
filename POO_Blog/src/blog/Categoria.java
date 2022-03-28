package blog;

public class Categoria {

	private int id_categoria;
	private String nombre;
	private String descripcion;
	private int id_autor;
	private String fecha_creacion;
	
	public Categoria() { }
	
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId_autor() {
		return id_autor;
	}
	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	public static boolean validaNombreCategoria(String nombre) {
		
		if(nombre.matches("^[a-zA-Z]"+"[a-zA-Z0-9\\s]*") && nombre.length()>=5 && nombre.length()<=20) {
			return true;
		}else {
			System.out.println("Nombre introducido incorrecto.");
			return false;
		}
	}

	@Override
	public String toString() {
		return "\n\nID Categoria: " + id_categoria + "\nNombre: " + nombre + "\nDescripcion: " + descripcion
				+ "\nID Autor: " + id_autor + "\nFecha creación: " + fecha_creacion;
	}
	
}
