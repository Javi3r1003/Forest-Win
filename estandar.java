/***************************************************************************
ForestWin
Proyecto Programación Orientada a Objetos
*estandar.java (Clase estandar)
*Autores: Erick Raúl Alvarez Melgar - Carné 20900
		  Adam Sebastian Rios Kirste - Carné 20616
		  Juan Pablo Zelada Ramirez - Carné 201004
		  César Rodrigro Meza Torres - Carné 20287
		  Alberto Antonio Ortega Romero - Carné 20884
		  Javier Alejandro Mejía Alecio - Carné 20304

Esta clase es derivada de la clase usuario, utiliza sus mismos métodos y atributos
 ****************************************************************************/

class estandar extends usuario{
	
	
	//constructor de la clase
	public estandar(String nom, String con){
		//se llama al cosntructor de la clase base
		super(nom, con);
	}
	
	//@Overriding del métoto ya definido en usuario
	public int tipoUsuario(vista v){
		int tipo = v.usuarioEstandar();
		
		return tipo;
	}
}
