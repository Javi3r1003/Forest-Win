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
		vista v = new vista();
		
		
		//opciones del menú principal
		int opcion = 0;
		while(opcion != 5){
			opcion = v.menu();
			
			if(opcion == 1){
				if(v.login()){
					
					
					//opciones del sub menú
					int subOpcion = 0;
					while(subOpcion != 6){
					
						subOpcion = v.subMenu();
						
						if(subOpcion == 1){
							v.mostrarArboles();
						}else if(subOpcion == 2){
							v.filtrosDeBusqueda();
						}else if(subOpcion == 3){
							v.agregarArbol();
						}else if(subOpcion == 4){
							v.eliminarArbol();
							
						}else if(v.salirPerfil() == true){
								subOpcion = 6;
								
						}
					}
				}
			}else if(opcion == 2){
				v.crear();
			}else if(opcion ==3){
				v.mostrarUsuarios();
				
			}else if(opcion == 4){
				if(v.salirPrograma() == true){
					opcion = 5;
				}
			}
		
		}
		
		
	}
}
