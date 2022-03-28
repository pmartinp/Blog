package blog;

import java.util.Arrays;

public class Post {

	private int id_post;
	private String titulo;
	private String introduccion;
	private String texto;
	private Categoria categoria;
	private String[] tags;
	private Comentario[] comentarios;
	
	public Post() { }
	
	public int getId_post() {
		return id_post;
	}
	public void setId_post(int id_post) {
		this.id_post = id_post;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getIntroduccion() {
		return introduccion;
	}
	public void setIntroduccion(String introduccion) {
		this.introduccion = introduccion;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}
	public Comentario[] getComentarios() {
		return comentarios;
	}
	public void setComentarios(Comentario[] comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		String cadenaComentarios= "\nId post: " + id_post + "\nTítulo: " + titulo + "\nIntroducción: " + introduccion + "\nTexto: " + texto
				+ "\nCategoría: " + categoria.getNombre() + "\nTags: " + Arrays.toString(tags).replaceAll("[\\[\\],]","")+ "\nComentarios: ";
				
		for(int i=0; i<comentarios.length; i++) {
			if(comentarios[i]!=null) {
				cadenaComentarios+="\n\nNombre: "+comentarios[i].getNombre()+ "\nTexto: "+comentarios[i].getTexto();
			}
		}
		
		return cadenaComentarios;
	}
	
	
}
