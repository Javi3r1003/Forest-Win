/***************************************************************************
									ForestWin
Proyecto Programación Orientada a Objetos
 usuario.java (Clase usuario)
 Autores: Erick Raúl Alvarez Melgar - Carné 20900
		  Adam Sebastian Rios Kirste - Carné 20616
		  Juan Pablo Zelada Ramirez - Carné 201004
		  César Rodrigro Meza Torres - Carné 20287
		  Alberto Antonio Ortega Romero - Carné 20884
		  Javier Alejandro Mejía Alecio - Carné 20304

Con esta clase se implemento la clase Serializable para poder guardar los 
objetos creados en un documento y poder crear así una base de datos
 ****************************************************************************/
 
 //Se importa la clase Serializable 
import java.io.Serializable;

//Clase Usuario
class usuario implements Serializable {
	//Atributos
	private String nombre;
	private String contrasena;
	
	//Constructor de la clase
	usuario(String n, String c){
		nombre = n;
		contrasena = c;
	}
	
	//getters de la clase
	public String getNombre(){
		return nombre;
	}
	
	public String getContrasena(){
		return contrasena;
	}
}
