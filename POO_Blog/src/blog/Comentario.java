package blog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comentario {

	private int id_comentario;
	private String email;
	private String nombre;
	private String texto;
	
	public Comentario(int comentario, String email, String nombre, String texto) {
		
		this.setId_comentario(comentario);
		this.setEmail(email);
		this.setNombre(nombre);
		this.setTexto(texto);
	}
	
	public int getId_comentario() {
		return id_comentario;
	}
	public void setId_comentario(int id_comentario) {
		this.id_comentario = id_comentario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public static boolean validarEmail(String email) {
				
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
	}
	@Override
	public String toString() {
		return "\n\nID Comentario: " + id_comentario + "\nEmail: " + email + "\nNombre: " + nombre + "\nTexto: "
				+ texto;
	}
	
	
}
