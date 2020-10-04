/***************************************************************************
									ForestWin
Proyecto Programación Orientada a Objetos
 main.java (Clase main)
 Autores: Erick Raúl Alvarez Melgar - Carné 20900
		  Adam Sebastian Rios Kirste - Carné 20616
		  Juan Pablo Zelada Ramirez - Carné 201004
		  César Rodrigro Meza Torres - Carné 20287
		  Alberto Antonio Ortega Romero - Carné 20884
		  Javier Alejandro Mejía Alecio - Carné 20304

 Con esta clase podremos ingresar a os métodos de impresión de la clase.
 vista para poder mostrarle el menú al usuario que esté interactuando con el programa
 ****************************************************************************/
class main{
	//metodo main
	public static void main(String[] args){
		//instancia de la clase vista
		controlador control = new controlador();
		
		
		//llamar al método para correr todo el programa
		control.programa();

		
		
	}
}
