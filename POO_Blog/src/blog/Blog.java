package blog;

import java.util.Arrays;
import java.util.Scanner;

public class Blog {

	public static void main(String[] args) {
		//Clase principal

		Scanner leer= new Scanner(System.in);
		
		int menu=0;
		Categoria[] categorias=new Categoria[3];
		Post[] posts=new Post[2];
		
		
		while(menu!=5) {
			
			mostrarMenu();
			menu=leer.nextInt();
			
			//comprobante de que elegimos una opción existente del menu
			while(menu<1 || menu>5) {
				System.out.println("Opción fuera de rango");
				menu=leer.nextInt();
			}
			
			switch(menu) {
			
			//Crear Categorías
			case 1:
				
				for(int i=0; i<categorias.length; i++) {
					categorias[i]=crearCategoria();
				}				
				
				for(Categoria cat: categorias) {
					System.out.println(cat.toString());
				}
				break;
			
			//Crear Posts
			case 2:
				
				for(int i=0; i<posts.length; i++) {
					posts[i]=crearPost(categorias);
				}
				break;
			
			//Escribir Comentarios
			case 3:
				
				//mostramos los diferentes posts que hay
				for(int i=0; i<posts.length; i++) {
					System.out.println((i+1)+". "+posts[i].getTitulo()+":");
				}
				
				int eleccion_post=leer.nextInt();
				
				//comprobante de que el posts seleccionado exista
				while(eleccion_post<1 || eleccion_post>posts.length) {
					System.out.println("Elija un post válido");
				}
				
				guardarComentario(posts, eleccion_post);
				break;
			
			//Mostrar Posts
			case 4:
				
				mostrarPost(posts);
				break;
				
			
			}
		}
		
		System.out.println("PEDRO MANUEL MARTÍN PÉREZ - Actividad 7 - 25 enero 2022");
	}
	
	public static void mostrarMenu() {
		System.out.println("\n1.- Crear Categorías");
		System.out.println("2.- Crear Posts");
		System.out.println("3.- Escribir Comentario");
		System.out.println("4.- Mostrar Posts");
		System.out.println("5.- Salir del programa");
	}
	
	public static Categoria crearCategoria() {
		Scanner leer=new Scanner(System.in);
		
		System.out.println("ID Categoría: ");
		int id_categoria=leer.nextInt();
		System.out.println("Nombre: ");
		String nombre=leer.nextLine();
		nombre=leer.nextLine();
		
		while(!Categoria.validaNombreCategoria(nombre)) {
			nombre=leer.nextLine();
		}
		System.out.println("Descripción: ");
		String descripcion=leer.nextLine();
		System.out.println("ID Autor: ");
		int id_autor=leer.nextInt();
		System.out.println("Fecha de creación: ");
		String fecha_creacion=leer.nextLine();
		fecha_creacion=leer.nextLine();
		
		Categoria categoria=new Categoria();
		
		categoria.setId_categoria(id_categoria);
		categoria.setNombre(nombre);
		categoria.setDescripcion(descripcion);
		categoria.setId_autor(id_autor);
		categoria.setFecha_creacion(fecha_creacion);
		
		return categoria;
	}
	
	public static Post crearPost(Categoria[] categorias) {
		Scanner leer= new Scanner(System.in);
		
		String[] tags;
		
		System.out.println("ID Post: ");
		int id_post=leer.nextInt();
		System.out.println("Título: ");
		String titulo=leer.nextLine();
		titulo=leer.nextLine();
		System.out.println("Introducción:");
		String introduccion=leer.nextLine();
		System.out.println("Texto: ");
		String texto=leer.nextLine();
		
		//mostramos las diferentes categorías que hay
		for(int i=0; i<categorias.length; i++) {
			System.out.println((1+i)+". "+categorias[i].getNombre());
		}
		int categoria=leer.nextInt();
		
		//comprobante de que elegimos bien la categoría
		while(categoria<1 || categoria>3) {
			System.out.println("Elige una categoria válida");
			categoria=leer.nextInt();
		}
		
		System.out.println("¿Cuántos tags desea introducir para este post (mínimo 3 tags)?");
		int num_tags=leer.nextInt();
		
		//comprobante de que elegimos bien el número de tags que queremos
		while(num_tags<3) {
			System.out.println("Como mínimo deben ser 3 tags");
			num_tags=leer.nextInt();
		}
		tags=new String[num_tags];
		
		for(int i=0; i<tags.length; i++) {
			System.out.println("tag "+(i+1)+":");
			tags[i]=leer.next();
		}
		
		Comentario[] comentarios=new Comentario[10];
		
		Post post=new Post();
		
		post.setId_post(id_post);
		post.setTitulo(titulo);
		post.setIntroduccion(introduccion);
		post.setTexto(texto);
		post.setCategoria(categorias[categoria-1]);
		post.setTags(tags);
		post.setComentarios(comentarios);
		return post;
	}
	
	public static Comentario escribirComentario() {
		Scanner leer= new Scanner(System.in);
				
		System.out.println("ID Comentario: ");
		int id_comentario=leer.nextInt();
		System.out.println("Email: ");
		String email=leer.next();
		
		while(!Comentario.validarEmail(email)) {
			System.out.println("El email introducido no es valido.");
			email=leer.next();
		}
		
		System.out.println("Nombre: ");
		String nombre=leer.nextLine();
		nombre=leer.nextLine();
		System.out.println("Texto: ");
		String texto=leer.nextLine();
		
		Comentario comentario= new Comentario(id_comentario, email, nombre, texto);

		return comentario;
	}

	public static void guardarComentario(Post[] posts, int eleccion_post) {
		
		//guardamos los comentarios si hay hueco en el array de comentarios del post
		for(int i=0; i<posts[eleccion_post-1].getComentarios().length; i++) {
			if(posts[eleccion_post-1].getComentarios()[i]==null) {
				posts[eleccion_post-1].getComentarios()[i]=escribirComentario();
				break;
			}
			else if(posts[eleccion_post-1].getComentarios()[posts[eleccion_post-1].getComentarios().length-1]!=null) {
				System.out.println("No se pueden escribir más comentarios");
			}
		}
		
	}
	
	public static void mostrarPost(Post[] posts) {
		
		for(int i=0; i<posts.length; i++) {
			System.out.println(posts[i].toString());
		}
	}
	
	
}
