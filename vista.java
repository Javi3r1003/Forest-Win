/***************************************************************************
ForestWin
Proyecto Programación Orientada a Objetos
*vista.java (Clase vosta)
*Autores: Erick Raúl Alvarez Melgar - Carné 20900
		  Adam Sebastian Rios Kirste - Carné 20616
		  Juan Pablo Zelada Ramirez - Carné 201004
		  César Rodrigro Meza Torres - Carné 20287
		  Alberto Antonio Ortega Romero - Carné 20884
		  Javier Alejandro Mejía Alecio - Carné 20304

 Con esta clase podremos acceder a los métodos de la clase archivo para 
 ejecutar las funcionalidades del programa.
 
 Con esta clase imprimiremos todo lo que sucede en consola.
 ****************************************************************************/

//importamos todas la libreria util de java
import java.util.*;

//clase vista
class vista{
	//Atributo tipo Scanner
	private Scanner scan;
	//Objeto tipo archivo
	private archivo a;
	
	//Constructor de la clase
	vista(){
		
		//Instancia de los atributos
		scan = new Scanner(System.in);
		a = new archivo();
	}

	//Mostrar informacion pasada por un parametro String
    public void Imprimir_al_usuario(String info_mostrar){
        System.out.println(info_mostrar);
    }

	
//-------------------------------------------Métodos para los menú

	//Método para imprimir el menú principal y pedir las opciones al usuario
	public int menu(){
		int opcion = 0;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n            FORESTWIN");
			System.out.println("-----------------------------------");
			System.out.println("\n1- Iniciar sesion");
			System.out.println("2- Registrarse");
			System.out.println("3- Mostrar Usuarios");
			System.out.println("4- Salir");
		
		
			try{
				System.out.print("Ingrese la opcion que desea ejecutar: ");
				opcion = scan.nextInt();
				scan.nextLine();
				
				if(opcion > 0 && opcion < 5){
					seguir = true;
					
				}else{
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
				}
			}catch(Exception e){
				System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
				scan.nextLine();
			}
		}
		return opcion;
		
	}
	
//----------------------------Método para imprimir el sub menú y pedirle las opciones al usuario

	//menu para un administrador con sus opciones válidas
	public int menuAdministrador(){
		int opcion = 0;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n1- Mostrar todos los arboles existentes");
			System.out.println("2- Filtros de busqueda");//funcionalidad pendiente
			System.out.println("3- Agregar Especie");
			System.out.println("4- Eliminar especie");
			System.out.println("5- Modificar especie");
			System.out.println("6- Agregar ONG");
			System.out.println("7- Mostrar Organizaciones");
			System.out.println("8- Donar a una Organizacion");
			System.out.println("9- Ver Total de Donado");
			System.out.println("10- Salir");
		
			//comprobamos que el usuario solo ingrese valores numericos
			try{
				System.out.print("Ingrese la opcion que desea ejecutar: ");
				opcion = scan.nextInt();
				scan.nextLine();
				
				
				if(opcion > 0 && opcion < 11){
					seguir = true;
					
				}else{
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
					
				}
			}catch(Exception e){
				System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
				scan.nextLine();
			}
		}
		return opcion;
	}
	
	
	//menu para un usuario estandar y sus opciones válidas
	public int menuEstandar(){
		int opcion = 0;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n1- Mostrar todos los arboles existentes");
			System.out.println("2- Filtros de busqueda");//funcionalidad pendiente
			System.out.println("3- Ver ONG forestales");
			System.out.println("4- Realizar Donacion");
			System.out.println("5- Ver Total de Donado");
			System.out.println("6- Salir");
		
			//comprobamos que solo ingrese valores numéricos
			try{
				System.out.print("Ingrese la opcion que desea ejecutar: ");
				opcion = scan.nextInt();
				
				if(opcion > 0 && opcion < 7){
					seguir = true;
					
				}else{
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
					
				}
			}catch(Exception e){
				System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
				scan.nextLine();
			}
		}
		return opcion;
	}
	
	
//-----------------------------------------/metodos unicamente para comprobar el tipo de usuario que se intenta logear
	public int usuarioAdministrador(){
		return 2;
	}
	
	public int usuarioEstandar(){	
		return 1;
	}	
	
//--------------------------------------------------Métodos para Organizaciones

	//método para poder guardar Organizaciones a la base de datos
	public void crearONG(){
		//ArrayList para almacenar objetos de tipo usuario extraídos de la base de datos 
		ArrayList<organizacion> ORGSRep = a.leerOrganizaciones();
		organizacion ONGTemp;
			
		System.out.print("Ingrese el nombre de la organizacion: ");
		String nombre = scan.nextLine();
		
		
		//si el archivo existe lo leera y sino lo creará
		if(ORGSRep != null){
			
			int contador=0;
			//recorrer el ArrayList
			for(int i = 0 ; i<ORGSRep.size() ; i++){
				//objeto temporal de tipo organizacion
				ONGTemp = ORGSRep.get(i);
				
				//se compueba si existe el nombre de la organizacion
				if(nombre.equals(ONGTemp.getNombre())){
					contador = 1;
				}
			}
			
			//condicionales si la organizacion existe o no
			if(contador != 0){
				System.out.println("**************************");
				System.out.println("ORGANIZACION YA REGISTRADA");
				System.out.println("**************************");
			}else{
				System.out.print("Ingrese el correo electronico: ");
				String correo = scan.nextLine();
				
				System.out.print("Ingrese pagina web de la organizacion(si no tiene coloque 'No posee'): ");
				String pagina = scan.nextLine();
				
				System.out.print("Ingrese el numero telefonico de la organizacion: ");
				long numero = scan.nextLong();
				scan.nextLine();
				//instancia de organizacion 
				organizacion o = new organizacion(nombre, pagina, correo, numero);
				ORGSRep.add(o);
				a.nuevaONG(ORGSRep);
				System.out.println("-----------------------------------");
				System.out.println("ORGANIZACION REGISTRADA EXITOSAMENTE");
				System.out.println("-----------------------------------");
			}
		}else{
			System.out.print("Ingrese el correo electronico: ");
			String correo = scan.next();
			
			System.out.print("Ingrese pagina web de la organizacion(si no tiene coloque 'No posee'): ");
			String pagina = scan.next();
			
			long numero = 0;
			boolean verificadorNumero = false;
			while(verificadorNumero != true){
				
				System.out.print("Ingrese el numero telefonico de la organizacion: ");
				try{
					numero = scan.nextLong();
					scan.nextLine();
					//instancia de organizacion 
					ORGSRep = new ArrayList<organizacion>();
					organizacion o = new organizacion(nombre, pagina, correo, numero);
					ORGSRep.add(o);
					a.nuevaONG(ORGSRep);
					System.out.println("-----------------------------------");
					System.out.println("ORGANIZACION REGISTRADA EXITOSAMENTE");
					System.out.println("-----------------------------------");
					verificadorNumero = true;
				}catch(Exception e){
					System.out.println("--------------------------------------------------");
					System.out.println("***EL NUMERO DEBE POSEER SOLO VALORES NUMERICOS***");
					System.out.println("--------------------------------------------------");
				}
			}
		}
			
	}
	
	
	public void mostrarOrganizaciones(){
		
		
		//ArrayList que almacenará objetos de tipo organizacion 
		ArrayList<organizacion> ORGSRep = a.leerOrganizaciones();
		
		if(ORGSRep == null){
			System.out.println("*******************************************************");
			System.out.println("BASE DE DATOS NO ENCONTRADA, REGISTRE UNA ORGANIZACION");
			System.out.println("*******************************************************");
		}else{
			//Variable temporal de tipo usuario para utilizar sus getters 
			organizacion ONGTemp;
			System.out.println("---------------------------------------------------------");
			
			//Ciclo para recorrer el ArrayList y poder realizar prints de cada organizacion 
			for(int i = 0 ; i<ORGSRep.size() ; i++){
				ONGTemp = ORGSRep.get(i);
				System.out.println("Nombre de Organizacion: " + ONGTemp.getNombre() + "\n");
				System.out.println("Correo Electronico: " +ONGTemp.getCorreo() + "\n");
				System.out.println("Numero Telefonico: " +ONGTemp.getNumero() + "\n");
				System.out.println("Pagina Web: " +ONGTemp.getPagina() + "\n");
				System.out.println("---------------------------------------------------------");
			}
		}
	}
	
	
	//método par apoder realizar donaciones
	public usuario realizarDonacion(usuario u){
		
		//guardaremos el usuario en una variable
		usuario usuarioRecibido = null;
		
		//leeremos la base de datos de organizaciones y usuarios
		ArrayList<organizacion> ORGSRep = a.leerOrganizaciones();
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		
		//retiramos al usuario del arrayList ya que se le realizarán modificaciones
		for(int i = 0; i < usuariosRep.size() ; i++){
			if(u.getNombre().equals(usuariosRep.get(i).getNombre())){
				usuarioRecibido = usuariosRep.get(i);
				usuariosRep.remove(i);
			}
		}
		//verificamos que si exita la base de datos
		if(ORGSRep == null){
			System.out.println("*******************************************************");
			System.out.println("BASE DE DATOS NO ENCONTRADA, REGISTRE UNA ORGANIZACION");
			System.out.println("*******************************************************");
		}else{
			//Variable temporal de tipo organizacion para utilizar sus getters 
			organizacion ONGTemp = null;
			
			
			int opcionONG = 0;
			boolean verificadorOpcionONG = false;
			
			//creamos un sub menú para facilitar la donación
			while(verificadorOpcionONG != true){
				
				//imprimimos el nombre de las organizaciones que estén registradas
				System.out.println("\n---- ingrese una opcion para ver la informacion de una organizacion");
				for(int i = 0 ; i<ORGSRep.size() ; i++){
					ONGTemp = ORGSRep.get(i);
					System.out.println((i+1) + "- " + ONGTemp.getNombre());
				}
				 //se verifica que el usuario ingrese solo valores numéricos
				try{
					System.out.print("=: ");
					opcionONG = scan.nextInt();
					
					//mostramos información de la ONG seleccionada
					if(opcionONG < (ORGSRep.size()+1) && opcionONG > 0){
						organizacion mostrarOrganizacion = ORGSRep.get(opcionONG-1);
						System.out.println("\nNombre de Organizacion: " + mostrarOrganizacion.getNombre());
						System.out.println("---------------------------------------------------------");
						System.out.println("Correo Electronico: " +mostrarOrganizacion.getCorreo() + "\n");
						System.out.println("Numero Telefonico: " +mostrarOrganizacion.getNumero() + "\n");
						System.out.println("Pagina Web: " +mostrarOrganizacion.getPagina() + "\n");
						System.out.println("---------------------------------------------------------");
						
						boolean continuar = false;
						int opcionSub = 0;
						while(continuar != true){
							System.out.println("\n-Que desea hacer?");
							System.out.println("1- Donar a " + mostrarOrganizacion.getNombre());
							System.out.println("2- ver otra organizacion");
							System.out.println("3- Cancelar Donacion");
							
							try{
								System.out.print("=: ");
								opcionSub = scan.nextInt();
								
								if(opcionSub < 4 && opcionSub > 0){
									
									//opcion 1 para realizar la donación
									if(opcionSub == 1){
										boolean verificadorCantidad = false;
										while(verificadorCantidad != true){
											System.out.println("\n-Ingrese la cantidad que desea donar(Quetzales)");
											System.out.println("-Ingrese punto(.) para ingresar decimales");
											//verificamos que la cantidad sea numérica
											try{
												System.out.print("=: Q ");
												double cantidad = scan.nextDouble();
												
												//imprimimos un pequeño recibo
												if(cantidad > 0){
													System.out.println("\n\n=========================================================");
													System.out.println("Se ha mandado el correo de donacion a: ");
													System.out.println("= " + mostrarOrganizacion.getNombre());
													System.out.println("Donante: " + usuarioRecibido.getNombre());
													System.out.println("=========================================================");
													System.out.println("Total a donar: Q" + cantidad);
													System.out.println("=========================================================");
													System.out.println("\n------ EL MUNDO Y FOREST WIN TE AGRADECE POR TU APORTE (: ------\n");
													
													//se suma la cantidad donada al usuario
													usuarioRecibido.setDonaciones(cantidad);
													//se guarda el usuario de nuevo en el arrayList y se sobreescribe
													
													usuariosRep.add(usuarioRecibido);
													a.nuevoU(usuariosRep);
													verificadorOpcionONG = true;
													continuar = true;
													verificadorCantidad = true;
													
												}else if(cantidad <=0){
													System.out.println("*******************************************************");
													System.out.println("      DEBES DONAR UNA CANTIDAD MAYOR A 0 ):");
													System.out.println("*******************************************************");
												}
											}catch(Exception e){
												System.out.println("*******************************************************");
												System.out.println("      LA CANTIDAD MONETARIA DEBE SER NUMERICA");
												System.out.println("*******************************************************");
												scan.next();
											}
										}
										
									//opcion 2 si se desea seguir viendo información de organizaciones
									}else if(opcionSub == 2){
										continuar = true;
										
									//opcion 3 por si el usuario desea cancelar la donación
									}else if(opcionSub == 3){
										System.out.println("-------------------------------------------");
										System.out.println("             DONACION CANCELADA");
										System.out.println("-------------------------------------------");
										verificadorOpcionONG = true;
										continuar = true;
									}
								}else if(opcionSub > 3 || opcionSub<= 0){
									System.out.println("*******************************************************");
									System.out.println("                     OPCION INVALIDA");
									System.out.println("*******************************************************");
								}
								
							}catch(Exception e){
								System.out.println("*******************************************************");
								System.out.println("          LA OPCION DEBE SER NUMERICA");
								System.out.println("*******************************************************");
								scan.next();
							}
							
						}
						
					//sub menú para preguntarle al usuario si desea seguir con la donacion
					}else if(opcionONG > ORGSRep.size() || opcionONG <= 0 ){
						System.out.println("*******************************************************");
						System.out.println("                     OPCION INVALIDA");
						System.out.println("*******************************************************");
						boolean continuar = false;
						int opcionSub = 0;
						while(continuar != true){
							System.out.println("\n-Que desea hacer?");
							System.out.println("1- Seguir Buscando");
							System.out.println("2- Cancelar Donacion");
							
							try{
								System.out.print("=: ");
								opcionSub = scan.nextInt();
								
								if(opcionSub < 3 && opcionSub > 0){
									if(opcionSub == 1){
										continuar = true;
									}else if(opcionSub == 2){
										System.out.println("-------------------------------------------");
										System.out.println("             DONACION CANCELADA");
										System.out.println("-------------------------------------------");
										verificadorOpcionONG = true;
										continuar = true;
									}
								}
							}catch(Exception i){
								System.out.println("*******************************************************");
								System.out.println("          LA OPCION DEBE SER NUMERICA");
								System.out.println("*******************************************************");
								scan.next();
							}
						}
					}
				//sub menú para preguntarle al usuario si desea seguir con la donacion
				}catch(Exception e){
					System.out.println("*******************************************************");
					System.out.println("          LA OPCION DEBE SER NUMERICA");
					System.out.println("*******************************************************");
					scan.next();
					boolean continuar = false;
					int opcionSub = 0;
					while(continuar != true){
						System.out.println("\n-Que desea hacer?");
						System.out.println("1- Seguir Buscando");
						System.out.println("2- Cancelar Donacion");
						
						try{
							System.out.print("=: ");
							opcionSub = scan.nextInt();
							
							if(opcionSub < 3 && opcionSub > 0){
								if(opcionSub == 1){
									continuar = true;
								}else if(opcionSub == 2){
									System.out.println("-------------------------------------------");
									System.out.println("             DONACION CANCELADA");
									System.out.println("-------------------------------------------");
									verificadorOpcionONG = true;
									continuar = true;
								}
							}
						}catch(Exception i){
							System.out.println("*******************************************************");
							System.out.println("          LA OPCION DEBE SER NUMERICA");
							System.out.println("*******************************************************");
							scan.next();
						}
					}
				}
			}
		}

		return usuarioRecibido;
	}
	
	//método para imprimir las donaciones de un usuario logueado
	public void mostrarDonaciones(usuario u){
		usuario usuarioRecibido = u;
		System.out.println("\nTotal donado por: "+ usuarioRecibido.getNombre());
		System.out.println("-------------------------------------------");
		System.out.println("\nCantidad: Q" + usuarioRecibido.getDonaciones());
		System.out.println("\n-------------------------------------------");
		
	}
	
	
//---------------------------------------------------Métodos para los usuarios

	//Método para iniciar sesión con usuarios registrados en la base de datos
	public usuario login(){
		//variable para verificar si el usuario existe
		boolean logeado = false;
		
		//ArrayList temporal que almacena los objetos de tipo arbol de la base de datos
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		usuario usuarioTemp = null;
		usuario usuarioAretornar = null;

		if(usuariosRep != null){
			System.out.print("\n-------Ingrese su nombre de usuario: ");
			String nombre = scan.nextLine();
		
			//Comprobaciones de usuario y contraseña al momento de hacer el login
			boolean comprobadorUsuario = false;
			boolean comprobadorContrasena = false;
			
			for(int i = 0 ; i<usuariosRep.size() ; i++){
				//variable temporal de tipo usuario
				usuario usuarioLista = usuariosRep.get(i);
						
				if(nombre.equals(usuarioLista.getNombre())){
					usuarioTemp = usuariosRep.get(i);
				}
				
			}
			
			try{ 
				if(nombre.equals(usuarioTemp.getNombre())){
					comprobadorUsuario = true;
					
				}
			}catch(Exception e){
				
			}
			
			if(comprobadorUsuario == true){
				
				
				System.out.print("-------Ingrese su contrasena: ");
				String contra = scan.next();
			
				try {	
					if(contra.equals(usuarioTemp.getContrasena())){
						comprobadorContrasena = true;	
					}
				}catch(Exception e){
					
				}
				
				
				if(comprobadorContrasena == true){
					System.out.println("-------------------------------------");
					System.out.println("          INICIANDO SESION...");
					System.out.println("-------------------------------------");
					try {

						Thread.sleep(2*1000);

					}catch(InterruptedException e){
						 
					}
					
					System.out.println("\n          BIENVENIDO " + usuarioTemp.getNombre() + "\n");
					logeado = true;
					usuarioAretornar = usuarioTemp;
				}else{
					System.out.println("**************************");
					System.out.println("CONTRASENA INCORRECTA");
					System.out.println("**************************");	
					
				}
			}else{
				System.out.println("**************************");
				System.out.println("USURARIO NO ENCONTRADO");
				System.out.println("**************************");	
			}
				
		}else{
			System.out.println("-------------------------------------");
			System.out.println("NO HAY USUARIOS CREADOS, REGISTRE UNO");
			System.out.println("-------------------------------------");
		}
		
		//si el usuario existe se retornará un true para poder acceder al sub Menú
		//dependiendo de el tipo de usuario que este sea
		return usuarioAretornar;
		
	}
	
	
	private int tipoUsuario(){
		
		int tipo = 0;
		System.out.println("\nIngrese el tipo de usuario que desea crear.");
		System.out.println("1- Estandar.");
		System.out.println("2- Administrador.");
		
		try {
			System.out.print("=: ");
			tipo = scan.nextInt();
			scan.nextLine();
			
			
		
			if(tipo == 1){
				System.out.println("\n-----------------------------------------");
				System.out.println("     SE CREARA UN USUARIO ESTANDAR");
				System.out.println("-----------------------------------------\n");
			}else if(tipo == 2){
				System.out.println("\n-----------------------------------------");
				System.out.println("     SE CREARA UN USUARIO ADMINISTRADOR");
				System.out.println("-----------------------------------------\n");
			}else if(tipo > 2 || tipo <= 0){
				System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
			}
		}catch(Exception e){
			System.out.println("\n***DEBES INDICAR CON UN 1 O 2 ***\n");
			scan.nextLine();
		}
		
		
		return tipo;
	}
	//creamos cada uno de los usuarios y lo mandamos al método de nuevoU de archivos para guardarlo en el txt
	public void crear(){
		int tipo = tipoUsuario();
		//ArrayList para almacenar objetos de tipo usuario extraídos de la base de datos 
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		usuario usuarioTemp;
		if(tipo == 1){
			
			System.out.print("Ingrese su nombre de usuario: ");
			String nombre = scan.nextLine();
		
			
			//si el archivo existe lo leera y sino lo creará
			if(usuariosRep != null){
				
				int contador=0;
				//recorrer el ArrayList
				for(int i = 0 ; i<usuariosRep.size() ; i++){
					//objeto temporal de tipo usuario
					usuarioTemp = usuariosRep.get(i);
					//se compueba si existe el nombre de usuario
					if(nombre.equals(usuarioTemp.getNombre())){
						contador = 1;
					
					}
				}
				
				//condicionales si el usuario existe o no
				if(contador != 0){
					System.out.println("**************************");
					System.out.println("USURARIO YA REGISTRADO");
					System.out.println("**************************");
				}else{
					System.out.print("Ingrese su contrasena: ");
					String contra = scan.next();

					//instancia de usuario estandar
					estandar u = new estandar(nombre, contra);
					usuariosRep.add(u);
					a.nuevoU(usuariosRep);
					System.out.println("-----------------------------------");
					System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
					System.out.println("-----------------------------------");
				}
			}else{
				System.out.print("Ingrese su contrasena: ");
				
				String contra = scan.next();
				
				usuariosRep = new ArrayList<usuario>();
				estandar u = new estandar(nombre, contra);
				usuariosRep.add(u);
				a.nuevoU(usuariosRep);
				System.out.println("-----------------------------------");
				System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
				System.out.println("-----------------------------------");
			}
			
		}else if(tipo == 2){
			System.out.print("Ingrese su nombre de usuario: ");
			String nombre = scan.nextLine();
			
			
			//si el archivo existe lo leera y sino lo creará
			if(usuariosRep != null){
				
				int contador=0;
				//recorrer el ArrayList
				for(int i = 0 ; i<usuariosRep.size() ; i++){
					//objeto temporal de tipo usuario
					usuarioTemp = usuariosRep.get(i);
					//se compueba si existe el nombre de usuario
					if(nombre.equals(usuarioTemp.getNombre())){
						contador = 1;
					
					}
				}
				
				//condicionales si el usuario existe o no
				if(contador != 0){
					System.out.println("**************************");
					System.out.println("USURARIO YA REGISTRADO");
					System.out.println("**************************");
				}else{
					System.out.print("Ingrese su contrasena: ");
					String contra = scan.next();

					//instancia de usuario administrador
					administrador u = new administrador(nombre, contra);
					usuariosRep.add(u);
					a.nuevoU(usuariosRep);
					System.out.println("-----------------------------------");
					System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
					System.out.println("-----------------------------------");
				}

			}else{
				System.out.print("Ingrese su contrasena: ");
				String contra = scan.next();
				usuariosRep = new ArrayList<usuario>();
				administrador u = new administrador(nombre, contra);
				usuariosRep.add(u);
				a.nuevoU(usuariosRep);
				System.out.println("-----------------------------------");
				System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
				System.out.println("-----------------------------------");
			}
			
		}
	}
	
	//Método para imprimir los usuarios existentes
	public void mostrarUsuarios(){
		//ArrayList que almacenará objetos de tipo usuario 
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		
		if(usuariosRep == null){
			System.out.println("************************************************");
			System.out.println("BASE DE DATOS NO ENCONTRADA, REGISTRE UN USUARIO");
			System.out.println("************************************************");
		}else{
			//Variable temporal de tipo usuario para utilizar sus getters 
			usuario usuarioTemp;
			System.out.println("-----------------------------------");
			
			//Ciclo para recorrer el ArrayList y poder realizar prints de cada usuario 
			for(int i = 0 ; i<usuariosRep.size() ; i++){
				usuarioTemp = usuariosRep.get(i);
				System.out.println("Nombre de usuario: " + usuarioTemp.getNombre());
				System.out.println("Contrasena: " +usuarioTemp.getContrasena() + "\n");
				System.out.println("-----------------------------------");
			}
		}
	}
	
	
	
//--------------------------------------------------- Métodos para los arboles

//Método para pedir datos al usuario del terreno e imprimir los árboles que cumplen con las condicones
	public void filtrosDeBusqueda(){
		
		//variables utilizadas para realizar la bisqueda
		double maxp = 1;
		double minp = 1;
		double maxt = 1;
		double mint = 1;
		String ilum = "";
		String util = "";
		
		System.out.println("\n------------------------Ingrese los datos");
		
		//verificamos el valor de la presipitación max
		boolean validaMax = false;
		while(validaMax != true)
		{
			System.out.print("\n-Ingrese la precipitacion maxima: ");
			try
			{
				double maxip = scan.nextDouble();
				
				if(maxip > 0){
					maxp = maxip;
					validaMax = true;
				}else{
					System.out.println("\n***LA PRECIPITACION MAXIMA DEBE SER MAYOR A CERO***\n");
				}
			}
			catch (Exception e)
			{
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//verificamos el valor de la presipitacion minima
		boolean validaMin = false;
		while(validaMin != true)
		{
			System.out.print("\n-Ingrese la precipitacion minima: ");
			try
			{
				double minip = scan.nextDouble();
				
				if(minip > 0 && minip <= maxp){
					minp = minip;
					validaMin = true;
					
				}else if(minip <= 0){
					System.out.println("\n***LA PRECIPITACION MINIMA DEBE SER MAYOR A 0 ***\n");
				}else if(minip > maxp){
					System.out.println("\n***LA PRECIPITACION MINIMA DEBE SER MENOR A LA MAXIMA***\n");
				}
			}
			catch (Exception e)
			{
				System.out.print("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//verificamos el valor de la temperatura maxima
		boolean validaMaxT = false;
		while(validaMaxT != true){
			System.out.print("\n-Ingrese la temperatura maxima: ");
			
			try{
				maxt = scan.nextDouble();				
				validaMaxT = true;	
			}catch (Exception e){
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//verificamos el valor de la temperatura minima
		boolean validaMinT = false;
		while(validaMinT != true)
		{
			System.out.print("\n-Ingrese la precipitacion minima: ");
			try
			{
				double minit = scan.nextDouble();
				
				if (minit <= maxt){
					mint = minit;
					validaMinT = true;
				}else if(minit > maxt){
					System.out.println("\n***LA TEMPERATURA MINIMA DEBE SER MENOR A LA MAXIMA***\n");
				}
			}catch (Exception e){
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//verificamos que el usuario ingrese bien las iluminacion
		boolean verificadorIlum = false;
		while (verificadorIlum != true){
			System.out.println("\n-Ingrese la iluminacion con la que desea buscar");
			System.out.println("1. Alta");
			System.out.println("2. Media");
			System.out.println("3. Baja");
			System.out.print("=: ");
			
			try{
				int s = scan.nextInt();
				
				if ( s < 4 && s > 0){
					if (s == 1){
						ilum = "Alta";
						verificadorIlum = true;
					}else if (s == 2){
						ilum = "Media";
						verificadorIlum = true;
					}else if(s == 3){
						ilum = "Baja";
						verificadorIlum = true;
					}
				}else if(s <= 0 || s > 3){
					System.out.println("\n***OPCION INVALIDA***\n");
				}
				
			}catch(Exception e){
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		
		
		}
		
		//verificamos qu eel usuario ingrese bien las utilidades
		boolean verificadorUtilidades = false;
		while (verificadorUtilidades != true){
			System.out.println("\n-Ingrese una utilidad con la que desea buscar");
			System.out.println("1. Maderable");
			System.out.println("2. Latex");
			System.out.println("3. Lenia");
			System.out.println("4. Comestible");
			System.out.println("5. Medicinal");
			System.out.println("6. Forraje");
			System.out.println("7. Ornamental");
			System.out.print("=: ");
			
			try{
				int st = scan.nextInt();
				if(st > 0 && st <8 ){
					int n2 = st;
					if (n2 == 1)
					{
						util = "Maderable";
						verificadorUtilidades = true;
					}
					else if (n2 == 2)
					{
						util = "Latex";
						verificadorUtilidades = true;
					}
					else if (n2 == 3)
					{
						util = "Lenia";
						verificadorUtilidades = true;
					}
					else if (n2 == 4)
					{
						util = "Comestible";
						verificadorUtilidades = true;
					}
					else if (n2 == 5)
					{
						util = "Medicinal";
						verificadorUtilidades = true;
					}
					else if (n2 == 6)
					{
						util = "Forraje";
						verificadorUtilidades = true;
					}
					else
					{
						util = "Ornamental";
						verificadorUtilidades = true;
					}
				}else if(st <= 0 || st > 7){
					System.out.println("\n***OPCION INVALIDA***\n");
				}
			}catch(Exception e){
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//se imprimira un arbol con las caracteristicas que se buscan
		System.out.println(a.filtrado((float)maxp, (float)minp, ilum, (float)maxt, (float)mint, util));
	}
	
	
	//Método para agregar una Especie nueva en la base de datos
	public void agregarArbol(){
		//Variable que cambiará si elusuario existe
		boolean existente = false;
		
		//ArrayList que almacenará objetos de tipo Arbol extraída de la base de datos
		ArrayList <Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol: ");
		String especie = scan.nextLine();
		
		//Ciclo para comprobar si existe la especie introducida por el usuario
		for(int i = 0 ; i<arboles.size() ; i++){
			
			Arbol arbolTemporal = arboles.get(i);
			if(especie.equals(arbolTemporal.getEspecie())){
				//Si el nombre de la especie existe cambiaremos el valor de la variable existente
				existente = true;
			}
		}
		
		//Si la especie no existe se le piden los datos al usuario de la especia a agregar
		if(existente == false){
			float premax = 0;
			boolean validarPremax = false;
			
			//Se crea un while para ver si modificar la precipitación máxima.
			while(validarPremax != true){
				System.out.print("\nIngrese la precipitacion maxima(mm): ");
				try{
					//Se verifica el rango del exámen
					float verificadorPremax = scan.nextFloat();
					if(verificadorPremax > 0){
						premax = verificadorPremax;
						validarPremax = true;
						
					}else if(verificadorPremax <= 0){
						System.out.println("\n***DEBES INGRESAR UNA PRECIPITACION MAYOR A 0***\n");
					}
					
					//Se captura la excepción de texto
				}catch (Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			//verificamos el valor ingresado por el usuario
			float premin = 0;
			boolean validarPremin = false;
			
			//Se crea un while para verificar si el usuario desea modificar el la precipitación mínicma
			while(validarPremin != true){
				System.out.print("\nIngrese la precipitacion minima(mm): ");
				
				//Se verifican lo datos ingresados
				try{
					float verificadorPremin = scan.nextFloat();
					
					if(verificadorPremin <= premax && verificadorPremin> 0){
						premin = verificadorPremin;
						validarPremin = true;
					}else if (verificadorPremin >= premax){
						System.out.println("\n***LA PRECIPITACION MINIMA NO PUEDE SER MAYOR A LA MAXIMA***\n");
						
					}else if(verificadorPremin <= 0){
						System.out.println("\n***DEBES INGRESAR UNA PRECIPITACION MAYOR A 0***\n");
					}
				}
				//Se captura la excepción
				catch (Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			//se crea un arrayLis solo para tener valores ya predefinidos y que el usuario elija
			ArrayList<String> iluminaciones = new ArrayList<String>(Arrays.asList("Alta" , "Media" , "Baja"));
			
			//verificamos el valor ingresado por el usuario
			String textIluminaciones = "";
			boolean validarIluminacion = false;
			while(validarIluminacion != true){
				System.out.println("\n-Ingrese las iluminaciones que desea(numero)");
				for(int i = 0 ; i<iluminaciones.size() ; i++){
					System.out.println((i+1) + "- " + iluminaciones.get(i));
				}
				System.out.print("=: ");
				
				try{
					int opcionIlum = scan.nextInt();
					if(opcionIlum > 0 && opcionIlum <= iluminaciones.size()){
						textIluminaciones += iluminaciones.get(opcionIlum-1) + ", ";
						iluminaciones.remove(opcionIlum-1);
						
						if(iluminaciones.size() != 0){
							boolean otraIluminacion = false;
							while(otraIluminacion != true){
								System.out.println("\n-Desea agregar otra luminacion?");
								System.out.println("1- Si");
								System.out.println("2- No");
								System.out.print("=: ");
								try{
									int otro = scan.nextInt();
									if(otro == 1){
										otraIluminacion = true;
									}else if(otro == 2){
										otraIluminacion = true;
										validarIluminacion = true;
									}else if(otro > 2 || otro <= 0){
										System.out.println("\n***OPCION INVALIDA***\n");
									}
								}catch(Exception e){
									System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
									scan.nextLine();
								}
							}
							
						}else if(iluminaciones.size() == 0){
							validarIluminacion = true;
						}
					}else if(opcionIlum <= 0 || opcionIlum > iluminaciones.size()){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			//verificamos el valor ingresado por el usuario
			float tempmax = 0;
			boolean validarTempmax = false;
			while(validarTempmax != true){
				System.out.print("\nIngrese la temperatura maxima(Celsius): ");
				try{
					tempmax = scan.nextFloat();
					validarTempmax = true;
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			//verificamos el valor ingresado por el usuario
			float tempmin = 0;
			boolean validarTempmin = false;
			while(validarTempmin != true){
				System.out.print("\nIngrese la temperatura minima(Celsius): ");
				try{
					
					float verificadorTempmin = scan.nextFloat();
					if(verificadorTempmin <= tempmax){
						tempmin = verificadorTempmin;
						validarTempmin = true;
					}else if(verificadorTempmin > tempmax){
						System.out.println("\n***LA TEMPERATURA MINIMA NO PUEDE SER MAYOR QUE LA MAXIMA***\n");
					}
					
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}					
			}
			//se crea un arrayList con utilidades predefinidas para que el usuario elija
			ArrayList<String> utilidades = new ArrayList<String>(Arrays.asList("Maderable" , "Latex" , "Lenia" , "Comestible" , "Medicinal" , "Forraje" , "Ornamental"));
			
			
			//verificamos el valor ingresado por el usuario
			String textUtilidades = "";
			boolean validarUtilidades = false;
			while(validarUtilidades != true){
				System.out.println("\n-Ingrese las utilidades que desea(numero)");
				for(int i = 0 ; i<utilidades.size() ; i++){
					System.out.println((i+1) + "- " + utilidades.get(i));
				}
				System.out.print("=: ");
				
				try{
					int opcionUtilidad = scan.nextInt();
					if(opcionUtilidad > 0 && opcionUtilidad <= utilidades.size()){
						textUtilidades += utilidades.get(opcionUtilidad-1) + ", ";
						utilidades.remove(opcionUtilidad-1);
						
						if(utilidades.size() != 0){
							
							//SE define un while par confirmar si el usuario desea modificar las utilidades
							boolean otraUtilidad = false;
							while(otraUtilidad != true){
								//Se imprime un el menu
								System.out.println("\n-Desea agregar otra utilidad?");
								System.out.println("1- Si");
								System.out.println("2- No");
								System.out.print("=: ");
								try{
									int otro = scan.nextInt();
									if(otro == 1){
										otraUtilidad = true;
									}else if(otro == 2){
										otraUtilidad = true;
										validarUtilidades = true;
									}else if(otro > 2 || otro <= 0){
										System.out.println("\n***OPCION INVALIDA***\n");
									}
									//Se atrapa la excepción
								}catch(Exception e){
									System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
									scan.nextLine();
								}
							}
							
						}else if(utilidades.size() == 0){
							validarUtilidades = true;
						}
					}else if(opcionUtilidad <= 0 || opcionUtilidad > utilidades.size()){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			//Calculos para obtener la tempratura promedio y un delta de los valroes flaot
			float precipitacion = ((premin+premax)/2.0f);
			float deltaPre = (premax-precipitacion);
			
			float temperatura = ((tempmax+tempmin)/2.0f);
			float deltaTem = (tempmax-temperatura);
			//Instanciar el objeto 
			Arbol nuevoArbol = new Arbol(especie, precipitacion, deltaPre, textIluminaciones, temperatura, deltaTem, textUtilidades);
			//gaurdar el objeto en el ArrayList
			arboles.add(nuevoArbol);
			//Sobrescribir la lista de la base de datos
			a.GuardarDatos(arboles);
			
			System.out.println("-----------------------------------");
			System.out.println("  ESPECIE AGREGADA CORRECTAMENTE");
			System.out.println("-----------------------------------");
		}else{
			System.out.println("************************************************");
			System.out.println("ESPECIE YA EXISTENTE, INGRESE UNA NO REGISTRADA");
			System.out.println("************************************************");
		}
	}
	//Método para Eliminar especies de la base de datos
	public void eliminarArbol(){
		
		//Variable que cambiará si el usuario existe o no
		boolean existente = false;
		//ArrayList que almacenará objetos de tipo Arbol estraido de la base de datos
		ArrayList <Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol que desea eliminar: ");
		String especie = scan.nextLine();
		
		for(int i = 0 ; i<arboles.size() ; i++){
			Arbol arbolTemporal = arboles.get(i);
			//comprobar si la especie agregada ya existe y si es así, la elimina
			if(especie.equals(arbolTemporal.getEspecie())){
				existente = true;
				arboles.remove(i);
			}
		}
			
		if(existente == true){
			System.out.println("-----------------------------------");
			System.out.println("  ESPECIE ELIMINADA CORRECTAMENTE");
			System.out.println("-----------------------------------");
			a.GuardarDatos(arboles);
			
		}else{
			System.out.println("*******************************************************");
			System.out.println("ESPECIE NO ENCONTRADA, NO SE ELIMINO NINGUNA ESPECIE");
			System.out.println("*******************************************************");
		}
	}
	
	
	//metodo para modificar especies
	public void modificarArboles(){
		
		//se lee la base de datos y se guarda en un ArrayList
		ArrayList<Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol que desea modificar: ");
		String especie = scan.nextLine();
		
		//se verifica que la especie ingresada exista
		boolean existente = false;
		Arbol arbolModificar = null;
		for(int i = 0 ; i<arboles.size() ; i ++ ){
			Arbol arbolTemporal = arboles.get(i);
			if(especie.equals(arbolTemporal.getEspecie())){
				arbolModificar = arbolTemporal;
				arboles.remove(i);
				existente = true;
			}
		}
		//si existe se solicitarán datos
		if(existente == true){
			System.out.println("\n-------NOMBRE DE LA ESPECIE A MODIFICAR: " + especie);
			
		String especieN ="";
			boolean aceptarCambioNombre = false;
			while(aceptarCambioNombre != true){
				System.out.println("Desea Modificar el nombre de la especie " + especie + "??");
				System.out.println("1-Si");
				System.out.println("2-No");
				System.out.print("=: ");
				
				try{
			
					int respuesta = scan.nextInt();
					scan.nextLine();
					
					if(respuesta == 1){
						System.out.print("\nIngrese el nuevo nombre del arbol: ");
						especieN = scan.nextLine();
						arbolModificar.setEspecie(especieN);
						System.out.println("\n---SE MODIFICO NOMBRE DE ESPECIE---\n");
						aceptarCambioNombre = true;
					}else if(respuesta == 2){
						System.out.println("\n---NO SE MODIFICO NOMBRE DE ESPECIE---\n");
						aceptarCambioNombre = true;
					}else if(respuesta > 2 || respuesta <= 0){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
				}catch(Exception e){
					System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
					scan.nextLine();
				}
				
				
			}
		
			
			//verificamos el valor ingresado por el usuario
			float premax = 0;
			boolean validarPremax = false;
			while(validarPremax != true){
				System.out.print("\nIngrese la precipitacion maxima(mm): ");
				try{
					float verificadorPremax = scan.nextFloat();
					if(verificadorPremax > 0){
						premax = verificadorPremax;
						validarPremax = true;
						
					}else if(verificadorPremax <= 0){
						System.out.println("\n***DEBES INGRESAR UNA PRECIPITACION MAYOR A 0***\n");
					}
					
				}catch (Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			//verificamos el valor ingresado por el usuario
			float premin = 0;
			boolean validarPremin = false;
			while(validarPremin != true){
				System.out.print("\nIngrese la precipitacion minima(mm): ");
				try{
					float verificadorPremin = scan.nextFloat();
					
					if(verificadorPremin <= premax && verificadorPremin> 0){
						premin = verificadorPremin;
						validarPremin = true;
					}else if (verificadorPremin >= premax){
						System.out.println("\n***LA PRECIPITACION MINIMA NO PUEDE SER MAYOR A LA MAXIMA***\n");
						
					}else if(verificadorPremin <= 0){
						System.out.println("\n***DEBES INGRESAR UNA PRECIPITACION MAYOR A 0***\n");
					}
				}
				catch (Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			
			ArrayList<String> iluminaciones = new ArrayList<String>(Arrays.asList("Alta" , "Media" , "Baja"));
			
			
			//verificamos el valor ingresado por el usuario
			String textIluminaciones = "";
			boolean aceptarCambioIlum = false;
			while(aceptarCambioIlum != true){
				System.out.println("Desea Modificar la iluminacion de la especie??");
				System.out.println("actual/actuales: " + arbolModificar.getIluminacion());
				System.out.println("1-Si");
				System.out.println("2-No");
				System.out.print("=: ");
				try{
					
					int respuesta = scan.nextInt();
					scan.nextLine();
					
					if(respuesta == 1){
						boolean validarIluminacion = false;
						while(validarIluminacion != true){
							System.out.println("\n-Ingrese las iluminaciones que desea(numero)");
							for(int i = 0 ; i<iluminaciones.size() ; i++){
								System.out.println((i+1) + "- " + iluminaciones.get(i));
							}
							System.out.print("=: ");
							try{
								int opcionIlum = scan.nextInt();
								if(opcionIlum > 0 && opcionIlum <= iluminaciones.size()){
									textIluminaciones += iluminaciones.get(opcionIlum-1) + ", ";
									iluminaciones.remove(opcionIlum-1);
									
									if(iluminaciones.size() != 0){
										boolean otraIluminacion = false;
										while(otraIluminacion != true){
											System.out.println("\n-Desea agregar otra luminacion?");
											System.out.println("1- Si");
											System.out.println("2- No");
											System.out.print("=: ");
											try{
												int otro = scan.nextInt();
												if(otro == 1){
													otraIluminacion = true;
												}else if(otro == 2){
													otraIluminacion = true;
													validarIluminacion = true;
												}else if(otro > 2 || otro <= 0){
													System.out.println("\n***OPCION INVALIDA***\n");
												}
											}catch(Exception e){
												System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
												scan.nextLine();
											}
										}
										
									}else if(iluminaciones.size() == 0){
										validarIluminacion = true;
									}
								}else if(opcionIlum <= 0 || opcionIlum > iluminaciones.size()){
									System.out.println("\n***OPCION INVALIDA***\n");
								}
							}catch(Exception e){
								System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
								scan.nextLine();
							}
							System.out.println("\n---SE MODIFICARON LAS ILUMINACIONES DE LA ESPECIE---\n");
							aceptarCambioIlum = true;
						}
					}else if(respuesta == 2){
						textIluminaciones = arbolModificar.getIluminacion();
						System.out.println("\n---NO SE MODIFICARON LAS ILUMINACIONES DE LA ESPECIE---\n");
						aceptarCambioIlum = true;
					}else if(respuesta > 2 || respuesta <= 0){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
				}catch(Exception e){
					System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
					scan.nextLine();
				}
			}
			//se modifica la iluminacion del arbol
			arbolModificar.setIluminacion(textIluminaciones);
			
			//verificamos el valor ingresado por el usuario
			float tempmax = 0;
			boolean aceptarCambioTempMax = false;
			while(aceptarCambioTempMax != true){
				System.out.println("Desea Modificar la temperatura maxima??");
				System.out.println("actual: " + (arbolModificar.getTemperatura() + arbolModificar.getDeltaTem()));
				System.out.println("1-Si");
				System.out.println("2-No");
				System.out.print("=: ");
				
				try{
			
					int respuesta = scan.nextInt();
					scan.nextLine();
					
					if(respuesta == 1){
						boolean validarTempmax = false;
						while(validarTempmax != true){
							System.out.print("\nIngrese la temperatura maxima(Celsius): ");
							try{
								tempmax = scan.nextFloat();
								validarTempmax = true;
							}catch(Exception e){
								System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
								scan.nextLine();
							}
						}
						aceptarCambioTempMax = true;
						System.out.println("\n---SE MODIFICARON LA TEMPERATURA MAXIMA DE LA ESPECIE---\n");
					}else if(respuesta == 2){
						tempmax = (arbolModificar.getTemperatura() + arbolModificar.getDeltaTem());
						System.out.println("\n---NO SE MODIFICARON LA TEMPERATURA MAXIMA DE LA ESPECIE---\n");
						aceptarCambioTempMax = true;
					}else if(respuesta > 2 || respuesta <= 0){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
					
				}catch(Exception e){
					System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			float tempmin = 0;
			boolean validarTempmin = false;
			boolean aceptarCambioTempMin = false;
			while(aceptarCambioTempMin != true){
				System.out.println("Desea Modificar la temperatura minima??");
				System.out.println("actual: " + (arbolModificar.getTemperatura() - arbolModificar.getDeltaTem()));
				System.out.println("1-Si");
				System.out.println("2-No");
				System.out.print("=: ");
				try{
			
					int respuesta = scan.nextInt();
					scan.nextLine();
					
					if(respuesta == 1){
				
						while(validarTempmin != true){
							System.out.print("\nIngrese la temperatura minima(Celsius): ");
							try{
								
								float verificadorTempmin = scan.nextFloat();
								if(verificadorTempmin <= tempmax){
									tempmin = verificadorTempmin;
									validarTempmin = true;
								}else if(verificadorTempmin > tempmax){
									System.out.println("\n***LA TEMPERATURA MINIMA NO PUEDE SER MAYOR QUE LA MAXIMA***\n");
								}
								
							}catch(Exception e){
								System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
								scan.nextLine();
							}					
						}
						System.out.println("\n---SE MODIFICARON LA TEMPERATURA MINIMA DE LA ESPECIE---\n");
						aceptarCambioTempMin = true;
						
					}else if(respuesta == 2){
						tempmin = (arbolModificar.getTemperatura() - arbolModificar.getDeltaTem());
						System.out.println("\n---NO SE MODIFICARON LA TEMPERATURA MINIMA DE LA ESPECIE---\n");
						aceptarCambioTempMin = true;
					}else if(respuesta > 2 || respuesta <= 0){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
					
				}catch(Exception e){
					System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			
			ArrayList<String> utilidades = new ArrayList<String>(Arrays.asList("Maderable" , "Latex" , "Lenia" , "Comestible" , "Medicinal" , "Forraje" , "Ornamental"));
			
			//verificamos el valor ingresado por el usuario
			String textUtilidades = "";
			boolean aceptarCambioUtil = false;
			
			//Se implementa un bucle while para que el usuario eliga modificar o no las utilidades del árbol
			while(aceptarCambioUtil != true){
				boolean validarUtilidades = false;
				
				//Se imprime el menú para que decida si modificar las utilidades
				System.out.println("Desea Modificar las utilidades de la especie??");
				System.out.println("actual/actuales: " + arbolModificar.getUtilidades());
				System.out.println("1-Si");
				System.out.println("2-No");
				System.out.print("=: ");
				
				try{
					//Se recibe la respuesta 
					int respuesta = scan.nextInt();
					scan.nextLine();
					
					//Se pone una sentencia lógica para determinar las acciones del programa.
					if(respuesta == 1){
						while(validarUtilidades != true){
							System.out.println("\n-Ingrese las utilidades que desea(numero)");
							for(int i = 0 ; i<utilidades.size() ; i++){
								System.out.println((i+1) + "- " + utilidades.get(i));
							}
							System.out.print("=: ");
							
							try{
								int opcionUtilidad = scan.nextInt();
								if(opcionUtilidad > 0 && opcionUtilidad <= utilidades.size()){
									textUtilidades += utilidades.get(opcionUtilidad-1) + ", ";
									utilidades.remove(opcionUtilidad-1);
									
									if(utilidades.size() != 0){
										boolean otraUtilidad = false;
										while(otraUtilidad != true){
											System.out.println("\n-Desea agregar otra utilidad?");
											System.out.println("1- Si");
											System.out.println("2- No");
											System.out.print("=: ");
											try{
												int otro = scan.nextInt();
												if(otro == 1){
													otraUtilidad = true;
												}else if(otro == 2){
													otraUtilidad = true;
													validarUtilidades = true;
												}else if(otro > 2 || otro <= 0){
													System.out.println("\n***OPCION INVALIDA***\n");
												}
											}catch(Exception e){
												System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
												scan.nextLine();
											}
										}
										
									}else if(utilidades.size() == 0){
										validarUtilidades = true;
									}
								}else if(opcionUtilidad <= 0 || opcionUtilidad > utilidades.size()){
									System.out.println("\n***OPCION INVALIDA***\n");
								}
								//Se atrapa la excepción de ingresar texto
							}catch(Exception e){
								System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
								scan.nextLine();
							}
						}
			//se modifica las utilidades del arbol
			arbolModificar.setUtilidades(textUtilidades);
			
			
			//se realizan los delta de la precipitacion y de la temperatura para sacar un promedio
			float precipitacion = ((premin+premax)/2.0f);
			float deltaPre = (premax-precipitacion);
			//se modifican los valores
			arbolModificar.setPrecipitacion(precipitacion);
			arbolModificar.setDeltaPre(deltaPre);
			
			float temperatura = ((tempmax+tempmin)/2.0f);
			float deltaTem = (tempmax-temperatura);
			
			
			//se modifican los valores
			arbolModificar.setTemperatura(temperatura);
			arbolModificar.setDeltaTem(deltaTem);

			//se vuelve a guardar el arbol en el Array 
			arboles.add(arbolModificar);
			//se sobreescribe el arrayList
			a.GuardarDatos(arboles);
			
			System.out.println("-----------------------------------");
			System.out.println("  ESPECIE MODIFICADA CORRECTAMENTE");
			System.out.println("-----------------------------------");
			a.GuardarDatos(arboles);
			
		}else{
			System.out.println("*******************************************************");
			System.out.println(" ESPECIE NO ENCONTRADA, NO SE MODIFICO NINGUNA ESPECIE");
			System.out.println("*******************************************************");
			
		}
		
	}
	
	//Método que simplemente imprime los Strings de un método de la clase Archivos
	public void mostrarArboles(){
		System.out.println("-----------------------------------");
		System.out.println(a.mostrarArboles());
	}
	

	
	
	//---------------salidas
	public boolean salirPerfil(){
		boolean cerrar = false;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n QUIERES SALIR DE TU PERFIL? ");
			
			System.out.println("1- Si");
			System.out.println("2- No");
			try {
				System.out.print("=: ");
				int salir = scan.nextInt();
				
			
				if(salir == 1){
					
					System.out.println("-----------------------------------");
					System.out.println("		 CERRANDO...");
					System.out.println("-----------------------------------");
					try {

						Thread.sleep(2*1000);

					}catch(InterruptedException e){
						 
					}
					System.out.println("-----------------------------------");
					System.out.println("		   PERFIL CERRADO");
					System.out.println("-----------------------------------");
					cerrar = true;
					seguir = true;
				}else if(salir == 2){
					System.out.println("-----------------------------------------");
					System.out.println("      NO SE HA CERRADO SESION (:");
					System.out.println("-----------------------------------------\n");
					seguir = true;
				}else if(salir > 2 || salir <= 0){
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
				}
			}catch(Exception e){
				System.out.println("\n***DEBES INDICAR CON UN 1 O 2 ***\n");
				scan.nextLine();
			}
		}
		
		return cerrar;
	}
	
	public boolean salirPrograma(){
		boolean cerrar = false;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n QUIERES SALIR DEL PROGRAMA? ");
			
			System.out.println("1- Si");
			System.out.println("2- No");
			try {
				System.out.print("=: ");
				int salir = scan.nextInt();
				
			
				if(salir == 1){
					System.out.println("-----------------------------------------");
					System.out.println("GRACIAS POR UTILIZAR NUESTRA PLATAFORMA");
					System.out.println("-----------------------------------------\n");
					System.out.println("              FORESTWIN.\n");
					cerrar = true;
					seguir = true;
				}else if(salir == 2){
					System.out.println("-----------------------------------------");
					System.out.println("     QUE BUENO QUE SIGUES AQUI (:");
					System.out.println("-----------------------------------------\n");
					seguir = true;
				}else if(salir > 2 || salir <= 0){
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
				}
			}catch(Exception e){
				System.out.println("\n***DEBES INDICAR CON UN 1 O 2 ***\n");
				scan.nextLine();
			}
		}
		
		return cerrar;
	}
	
	
	
}/***************************************************************************
ForestWin
Proyecto Programación Orientada a Objetos
*vista.java (Clase vosta)
*Autores: Erick Raúl Alvarez Melgar - Carné 20900
		  Adam Sebastian Rios Kirste - Carné 20616
		  Juan Pablo Zelada Ramirez - Carné 201004
		  César Rodrigro Meza Torres - Carné 20287
		  Alberto Antonio Ortega Romero - Carné 20884
		  Javier Alejandro Mejía Alecio - Carné 20304

 Con esta clase podremos acceder a los métodos de la clase archivo para 
 ejecutar las funcionalidades del programa.
 
 Con esta clase imprimiremos todo lo que sucede en consola.
 ****************************************************************************/

//importamos todas la libreria util de java
import java.util.*;

//clase vista
class vista{
	//Atributo tipo Scanner
	private Scanner scan;
	//Objeto tipo archivo
	private archivo a;
	
	//Constructor de la clase
	vista(){
		
		//Instancia de los atributos
		scan = new Scanner(System.in);
		a = new archivo();
	}

	//Mostrar informacion pasada por un parametro String
    public void Imprimir_al_usuario(String info_mostrar){
        System.out.println(info_mostrar);
    }

	
//-------------------------------------------Métodos para los menú

	//Método para imprimir el menú principal y pedir las opciones al usuario
	public int menu(){
		int opcion = 0;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n            FORESTWIN");
			System.out.println("-----------------------------------");
			System.out.println("\n1- Iniciar sesion");
			System.out.println("2- Registrarse");
			System.out.println("3- Mostrar Usuarios");
			System.out.println("4- Salir");
		
		
			try{
				System.out.print("Ingrese la opcion que desea ejecutar: ");
				opcion = scan.nextInt();
				scan.nextLine();
				
				if(opcion > 0 && opcion < 5){
					seguir = true;
					
				}else{
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
				}
			}catch(Exception e){
				System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
				scan.nextLine();
			}
		}
		return opcion;
		
	}
	
//----------------------------Método para imprimir el sub menú y pedirle las opciones al usuario

	//menu para un administrador con sus opciones válidas
	public int menuAdministrador(){
		int opcion = 0;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n1- Mostrar todos los arboles existentes");
			System.out.println("2- Filtros de busqueda");//funcionalidad pendiente
			System.out.println("3- Agregar Especie");
			System.out.println("4- Eliminar especie");
			System.out.println("5- Modificar especie");
			System.out.println("6- Agregar ONG");
			System.out.println("7- Mostrar Organizaciones");
			System.out.println("8- Donar a una Organizacion");
			System.out.println("9- Ver Total de Donado");
			System.out.println("10- Salir");
		
			//comprobamos que el usuario solo ingrese valores numericos
			try{
				System.out.print("Ingrese la opcion que desea ejecutar: ");
				opcion = scan.nextInt();
				scan.nextLine();
				
				
				if(opcion > 0 && opcion < 11){
					seguir = true;
					
				}else{
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
					
				}
			}catch(Exception e){
				System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
				scan.nextLine();
			}
		}
		return opcion;
	}
	
	
	//menu para un usuario estandar y sus opciones válidas
	public int menuEstandar(){
		int opcion = 0;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n1- Mostrar todos los arboles existentes");
			System.out.println("2- Filtros de busqueda");//funcionalidad pendiente
			System.out.println("3- Ver ONG forestales");
			System.out.println("4- Realizar Donacion");
			System.out.println("5- Ver Total de Donado");
			System.out.println("6- Salir");
		
			//comprobamos que solo ingrese valores numéricos
			try{
				System.out.print("Ingrese la opcion que desea ejecutar: ");
				opcion = scan.nextInt();
				
				if(opcion > 0 && opcion < 7){
					seguir = true;
					
				}else{
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
					
				}
			}catch(Exception e){
				System.out.println("\n***LA OPCION DEBE SER NUMERICA***\n");
				scan.nextLine();
			}
		}
		return opcion;
	}
	
	
//-----------------------------------------/metodos unicamente para comprobar el tipo de usuario que se intenta logear
	public int usuarioAdministrador(){
		return 2;
	}
	
	public int usuarioEstandar(){	
		return 1;
	}	
	
//--------------------------------------------------Métodos para Organizaciones

	//método para poder guardar Organizaciones a la base de datos
	public void crearONG(){
		//ArrayList para almacenar objetos de tipo usuario extraídos de la base de datos 
		ArrayList<organizacion> ORGSRep = a.leerOrganizaciones();
		organizacion ONGTemp;
			
		System.out.print("Ingrese el nombre de la organizacion: ");
		String nombre = scan.nextLine();
		
		
		//si el archivo existe lo leera y sino lo creará
		if(ORGSRep != null){
			
			int contador=0;
			//recorrer el ArrayList
			for(int i = 0 ; i<ORGSRep.size() ; i++){
				//objeto temporal de tipo organizacion
				ONGTemp = ORGSRep.get(i);
				
				//se compueba si existe el nombre de la organizacion
				if(nombre.equals(ONGTemp.getNombre())){
					contador = 1;
				}
			}
			
			//condicionales si la organizacion existe o no
			if(contador != 0){
				System.out.println("**************************");
				System.out.println("ORGANIZACION YA REGISTRADA");
				System.out.println("**************************");
			}else{
				System.out.print("Ingrese el correo electronico: ");
				String correo = scan.nextLine();
				
				System.out.print("Ingrese pagina web de la organizacion(si no tiene coloque 'No posee'): ");
				String pagina = scan.nextLine();
				
				System.out.print("Ingrese el numero telefonico de la organizacion: ");
				long numero = scan.nextLong();
				scan.nextLine();
				//instancia de organizacion 
				organizacion o = new organizacion(nombre, pagina, correo, numero);
				ORGSRep.add(o);
				a.nuevaONG(ORGSRep);
				System.out.println("-----------------------------------");
				System.out.println("ORGANIZACION REGISTRADA EXITOSAMENTE");
				System.out.println("-----------------------------------");
			}
		}else{
			System.out.print("Ingrese el correo electronico: ");
			String correo = scan.next();
			
			System.out.print("Ingrese pagina web de la organizacion(si no tiene coloque 'No posee'): ");
			String pagina = scan.next();
			
			long numero = 0;
			boolean verificadorNumero = false;
			while(verificadorNumero != true){
				
				System.out.print("Ingrese el numero telefonico de la organizacion: ");
				try{
					numero = scan.nextLong();
					scan.nextLine();
					//instancia de organizacion 
					ORGSRep = new ArrayList<organizacion>();
					organizacion o = new organizacion(nombre, pagina, correo, numero);
					ORGSRep.add(o);
					a.nuevaONG(ORGSRep);
					System.out.println("-----------------------------------");
					System.out.println("ORGANIZACION REGISTRADA EXITOSAMENTE");
					System.out.println("-----------------------------------");
					verificadorNumero = true;
				}catch(Exception e){
					System.out.println("--------------------------------------------------");
					System.out.println("***EL NUMERO DEBE POSEER SOLO VALORES NUMERICOS***");
					System.out.println("--------------------------------------------------");
				}
			}
		}
			
	}
	
	
	public void mostrarOrganizaciones(){
		
		
		//ArrayList que almacenará objetos de tipo organizacion 
		ArrayList<organizacion> ORGSRep = a.leerOrganizaciones();
		
		if(ORGSRep == null){
			System.out.println("*******************************************************");
			System.out.println("BASE DE DATOS NO ENCONTRADA, REGISTRE UNA ORGANIZACION");
			System.out.println("*******************************************************");
		}else{
			//Variable temporal de tipo usuario para utilizar sus getters 
			organizacion ONGTemp;
			System.out.println("---------------------------------------------------------");
			
			//Ciclo para recorrer el ArrayList y poder realizar prints de cada organizacion 
			for(int i = 0 ; i<ORGSRep.size() ; i++){
				ONGTemp = ORGSRep.get(i);
				System.out.println("Nombre de Organizacion: " + ONGTemp.getNombre() + "\n");
				System.out.println("Correo Electronico: " +ONGTemp.getCorreo() + "\n");
				System.out.println("Numero Telefonico: " +ONGTemp.getNumero() + "\n");
				System.out.println("Pagina Web: " +ONGTemp.getPagina() + "\n");
				System.out.println("---------------------------------------------------------");
			}
		}
	}
	
	
	//método par apoder realizar donaciones
	public usuario realizarDonacion(usuario u){
		
		//guardaremos el usuario en una variable
		usuario usuarioRecibido = null;
		
		//leeremos la base de datos de organizaciones y usuarios
		ArrayList<organizacion> ORGSRep = a.leerOrganizaciones();
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		
		//retiramos al usuario del arrayList ya que se le realizarán modificaciones
		for(int i = 0; i < usuariosRep.size() ; i++){
			if(u.getNombre().equals(usuariosRep.get(i).getNombre())){
				usuarioRecibido = usuariosRep.get(i);
				usuariosRep.remove(i);
			}
		}
		//verificamos que si exita la base de datos
		if(ORGSRep == null){
			System.out.println("*******************************************************");
			System.out.println("BASE DE DATOS NO ENCONTRADA, REGISTRE UNA ORGANIZACION");
			System.out.println("*******************************************************");
		}else{
			//Variable temporal de tipo organizacion para utilizar sus getters 
			organizacion ONGTemp = null;
			
			
			int opcionONG = 0;
			boolean verificadorOpcionONG = false;
			
			//creamos un sub menú para facilitar la donación
			while(verificadorOpcionONG != true){
				
				//imprimimos el nombre de las organizaciones que estén registradas
				System.out.println("\n---- ingrese una opcion para ver la informacion de una organizacion");
				for(int i = 0 ; i<ORGSRep.size() ; i++){
					ONGTemp = ORGSRep.get(i);
					System.out.println((i+1) + "- " + ONGTemp.getNombre());
				}
				 //se verifica que el usuario ingrese solo valores numéricos
				try{
					System.out.print("=: ");
					opcionONG = scan.nextInt();
					
					//mostramos información de la ONG seleccionada
					if(opcionONG < (ORGSRep.size()+1) && opcionONG > 0){
						organizacion mostrarOrganizacion = ORGSRep.get(opcionONG-1);
						System.out.println("\nNombre de Organizacion: " + mostrarOrganizacion.getNombre());
						System.out.println("---------------------------------------------------------");
						System.out.println("Correo Electronico: " +mostrarOrganizacion.getCorreo() + "\n");
						System.out.println("Numero Telefonico: " +mostrarOrganizacion.getNumero() + "\n");
						System.out.println("Pagina Web: " +mostrarOrganizacion.getPagina() + "\n");
						System.out.println("---------------------------------------------------------");
						
						boolean continuar = false;
						int opcionSub = 0;
						while(continuar != true){
							System.out.println("\n-Que desea hacer?");
							System.out.println("1- Donar a " + mostrarOrganizacion.getNombre());
							System.out.println("2- ver otra organizacion");
							System.out.println("3- Cancelar Donacion");
							
							try{
								System.out.print("=: ");
								opcionSub = scan.nextInt();
								
								if(opcionSub < 4 && opcionSub > 0){
									
									//opcion 1 para realizar la donación
									if(opcionSub == 1){
										boolean verificadorCantidad = false;
										while(verificadorCantidad != true){
											System.out.println("\n-Ingrese la cantidad que desea donar(Quetzales)");
											System.out.println("-Ingrese punto(.) para ingresar decimales");
											//verificamos que la cantidad sea numérica
											try{
												System.out.print("=: Q ");
												double cantidad = scan.nextDouble();
												
												//imprimimos un pequeño recibo
												if(cantidad > 0){
													System.out.println("\n\n=========================================================");
													System.out.println("Se ha mandado el correo de donacion a: ");
													System.out.println("= " + mostrarOrganizacion.getNombre());
													System.out.println("Donante: " + usuarioRecibido.getNombre());
													System.out.println("=========================================================");
													System.out.println("Total a donar: Q" + cantidad);
													System.out.println("=========================================================");
													System.out.println("\n------ EL MUNDO Y FOREST WIN TE AGRADECE POR TU APORTE (: ------\n");
													
													//se suma la cantidad donada al usuario
													usuarioRecibido.setDonaciones(cantidad);
													//se guarda el usuario de nuevo en el arrayList y se sobreescribe
													
													usuariosRep.add(usuarioRecibido);
													a.nuevoU(usuariosRep);
													verificadorOpcionONG = true;
													continuar = true;
													verificadorCantidad = true;
													
												}else if(cantidad <=0){
													System.out.println("*******************************************************");
													System.out.println("      DEBES DONAR UNA CANTIDAD MAYOR A 0 ):");
													System.out.println("*******************************************************");
												}
											}catch(Exception e){
												System.out.println("*******************************************************");
												System.out.println("      LA CANTIDAD MONETARIA DEBE SER NUMERICA");
												System.out.println("*******************************************************");
												scan.next();
											}
										}
										
									//opcion 2 si se desea seguir viendo información de organizaciones
									}else if(opcionSub == 2){
										continuar = true;
										
									//opcion 3 por si el usuario desea cancelar la donación
									}else if(opcionSub == 3){
										System.out.println("-------------------------------------------");
										System.out.println("             DONACION CANCELADA");
										System.out.println("-------------------------------------------");
										verificadorOpcionONG = true;
										continuar = true;
									}
								}else if(opcionSub > 3 || opcionSub<= 0){
									System.out.println("*******************************************************");
									System.out.println("                     OPCION INVALIDA");
									System.out.println("*******************************************************");
								}
								
							}catch(Exception e){
								System.out.println("*******************************************************");
								System.out.println("          LA OPCION DEBE SER NUMERICA");
								System.out.println("*******************************************************");
								scan.next();
							}
							
						}
						
					//sub menú para preguntarle al usuario si desea seguir con la donacion
					}else if(opcionONG > ORGSRep.size() || opcionONG <= 0 ){
						System.out.println("*******************************************************");
						System.out.println("                     OPCION INVALIDA");
						System.out.println("*******************************************************");
						boolean continuar = false;
						int opcionSub = 0;
						while(continuar != true){
							System.out.println("\n-Que desea hacer?");
							System.out.println("1- Seguir Buscando");
							System.out.println("2- Cancelar Donacion");
							
							try{
								System.out.print("=: ");
								opcionSub = scan.nextInt();
								
								if(opcionSub < 3 && opcionSub > 0){
									if(opcionSub == 1){
										continuar = true;
									}else if(opcionSub == 2){
										System.out.println("-------------------------------------------");
										System.out.println("             DONACION CANCELADA");
										System.out.println("-------------------------------------------");
										verificadorOpcionONG = true;
										continuar = true;
									}
								}
							}catch(Exception i){
								System.out.println("*******************************************************");
								System.out.println("          LA OPCION DEBE SER NUMERICA");
								System.out.println("*******************************************************");
								scan.next();
							}
						}
					}
				//sub menú para preguntarle al usuario si desea seguir con la donacion
				}catch(Exception e){
					System.out.println("*******************************************************");
					System.out.println("          LA OPCION DEBE SER NUMERICA");
					System.out.println("*******************************************************");
					scan.next();
					boolean continuar = false;
					int opcionSub = 0;
					while(continuar != true){
						System.out.println("\n-Que desea hacer?");
						System.out.println("1- Seguir Buscando");
						System.out.println("2- Cancelar Donacion");
						
						try{
							System.out.print("=: ");
							opcionSub = scan.nextInt();
							
							if(opcionSub < 3 && opcionSub > 0){
								if(opcionSub == 1){
									continuar = true;
								}else if(opcionSub == 2){
									System.out.println("-------------------------------------------");
									System.out.println("             DONACION CANCELADA");
									System.out.println("-------------------------------------------");
									verificadorOpcionONG = true;
									continuar = true;
								}
							}
						}catch(Exception i){
							System.out.println("*******************************************************");
							System.out.println("          LA OPCION DEBE SER NUMERICA");
							System.out.println("*******************************************************");
							scan.next();
						}
					}
				}
			}
		}

		return usuarioRecibido;
	}
	
	//método para imprimir las donaciones de un usuario logueado
	public void mostrarDonaciones(usuario u){
		usuario usuarioRecibido = u;
		System.out.println("\nTotal donado por: "+ usuarioRecibido.getNombre());
		System.out.println("-------------------------------------------");
		System.out.println("\nCantidad: Q" + usuarioRecibido.getDonaciones());
		System.out.println("\n-------------------------------------------");
		
	}
	
	
//---------------------------------------------------Métodos para los usuarios

	//Método para iniciar sesión con usuarios registrados en la base de datos
	public usuario login(){
		//variable para verificar si el usuario existe
		boolean logeado = false;
		
		//ArrayList temporal que almacena los objetos de tipo arbol de la base de datos
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		usuario usuarioTemp = null;
		usuario usuarioAretornar = null;

		if(usuariosRep != null){
			System.out.print("\n-------Ingrese su nombre de usuario: ");
			String nombre = scan.nextLine();
		
			//Comprobaciones de usuario y contraseña al momento de hacer el login
			boolean comprobadorUsuario = false;
			boolean comprobadorContrasena = false;
			
			for(int i = 0 ; i<usuariosRep.size() ; i++){
				//variable temporal de tipo usuario
				usuario usuarioLista = usuariosRep.get(i);
						
				if(nombre.equals(usuarioLista.getNombre())){
					usuarioTemp = usuariosRep.get(i);
				}
				
			}
			
			try{ 
				if(nombre.equals(usuarioTemp.getNombre())){
					comprobadorUsuario = true;
					
				}
			}catch(Exception e){
				
			}
			
			if(comprobadorUsuario == true){
				
				
				System.out.print("-------Ingrese su contrasena: ");
				String contra = scan.next();
			
				try {	
					if(contra.equals(usuarioTemp.getContrasena())){
						comprobadorContrasena = true;	
					}
				}catch(Exception e){
					
				}
				
				
				if(comprobadorContrasena == true){
					System.out.println("-------------------------------------");
					System.out.println("          INICIANDO SESION...");
					System.out.println("-------------------------------------");
					try {

						Thread.sleep(2*1000);

					}catch(InterruptedException e){
						 
					}
					
					System.out.println("\n          BIENVENIDO " + usuarioTemp.getNombre() + "\n");
					logeado = true;
					usuarioAretornar = usuarioTemp;
				}else{
					System.out.println("**************************");
					System.out.println("CONTRASENA INCORRECTA");
					System.out.println("**************************");	
					
				}
			}else{
				System.out.println("**************************");
				System.out.println("USURARIO NO ENCONTRADO");
				System.out.println("**************************");	
			}
				
		}else{
			System.out.println("-------------------------------------");
			System.out.println("NO HAY USUARIOS CREADOS, REGISTRE UNO");
			System.out.println("-------------------------------------");
		}
		
		//si el usuario existe se retornará un true para poder acceder al sub Menú
		//dependiendo de el tipo de usuario que este sea
		return usuarioAretornar;
		
	}
	
	
	private int tipoUsuario(){
		
		int tipo = 0;
		System.out.println("\nIngrese el tipo de usuario que desea crear.");
		System.out.println("1- Estandar.");
		System.out.println("2- Administrador.");
		
		try {
			System.out.print("=: ");
			tipo = scan.nextInt();
			scan.nextLine();
			
			
		
			if(tipo == 1){
				System.out.println("\n-----------------------------------------");
				System.out.println("     SE CREARA UN USUARIO ESTANDAR");
				System.out.println("-----------------------------------------\n");
			}else if(tipo == 2){
				System.out.println("\n-----------------------------------------");
				System.out.println("     SE CREARA UN USUARIO ADMINISTRADOR");
				System.out.println("-----------------------------------------\n");
			}else if(tipo > 2 || tipo <= 0){
				System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
			}
		}catch(Exception e){
			System.out.println("\n***DEBES INDICAR CON UN 1 O 2 ***\n");
			scan.nextLine();
		}
		
		
		return tipo;
	}
	//creamos cada uno de los usuarios y lo mandamos al método de nuevoU de archivos para guardarlo en el txt
	public void crear(){
		int tipo = tipoUsuario();
		//ArrayList para almacenar objetos de tipo usuario extraídos de la base de datos 
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		usuario usuarioTemp;
		if(tipo == 1){
			
			System.out.print("Ingrese su nombre de usuario: ");
			String nombre = scan.nextLine();
		
			
			//si el archivo existe lo leera y sino lo creará
			if(usuariosRep != null){
				
				int contador=0;
				//recorrer el ArrayList
				for(int i = 0 ; i<usuariosRep.size() ; i++){
					//objeto temporal de tipo usuario
					usuarioTemp = usuariosRep.get(i);
					//se compueba si existe el nombre de usuario
					if(nombre.equals(usuarioTemp.getNombre())){
						contador = 1;
					
					}
				}
				
				//condicionales si el usuario existe o no
				if(contador != 0){
					System.out.println("**************************");
					System.out.println("USURARIO YA REGISTRADO");
					System.out.println("**************************");
				}else{
					System.out.print("Ingrese su contrasena: ");
					String contra = scan.next();

					//instancia de usuario estandar
					estandar u = new estandar(nombre, contra);
					usuariosRep.add(u);
					a.nuevoU(usuariosRep);
					System.out.println("-----------------------------------");
					System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
					System.out.println("-----------------------------------");
				}
			}else{
				System.out.print("Ingrese su contrasena: ");
				
				String contra = scan.next();
				
				usuariosRep = new ArrayList<usuario>();
				estandar u = new estandar(nombre, contra);
				usuariosRep.add(u);
				a.nuevoU(usuariosRep);
				System.out.println("-----------------------------------");
				System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
				System.out.println("-----------------------------------");
			}
			
		}else if(tipo == 2){
			System.out.print("Ingrese su nombre de usuario: ");
			String nombre = scan.nextLine();
			
			
			//si el archivo existe lo leera y sino lo creará
			if(usuariosRep != null){
				
				int contador=0;
				//recorrer el ArrayList
				for(int i = 0 ; i<usuariosRep.size() ; i++){
					//objeto temporal de tipo usuario
					usuarioTemp = usuariosRep.get(i);
					//se compueba si existe el nombre de usuario
					if(nombre.equals(usuarioTemp.getNombre())){
						contador = 1;
					
					}
				}
				
				//condicionales si el usuario existe o no
				if(contador != 0){
					System.out.println("**************************");
					System.out.println("USURARIO YA REGISTRADO");
					System.out.println("**************************");
				}else{
					System.out.print("Ingrese su contrasena: ");
					String contra = scan.next();

					//instancia de usuario administrador
					administrador u = new administrador(nombre, contra);
					usuariosRep.add(u);
					a.nuevoU(usuariosRep);
					System.out.println("-----------------------------------");
					System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
					System.out.println("-----------------------------------");
				}

			}else{
				System.out.print("Ingrese su contrasena: ");
				String contra = scan.next();
				usuariosRep = new ArrayList<usuario>();
				administrador u = new administrador(nombre, contra);
				usuariosRep.add(u);
				a.nuevoU(usuariosRep);
				System.out.println("-----------------------------------");
				System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
				System.out.println("-----------------------------------");
			}
			
		}
	}
	
	//Método para imprimir los usuarios existentes
	public void mostrarUsuarios(){
		//ArrayList que almacenará objetos de tipo usuario 
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		
		if(usuariosRep == null){
			System.out.println("************************************************");
			System.out.println("BASE DE DATOS NO ENCONTRADA, REGISTRE UN USUARIO");
			System.out.println("************************************************");
		}else{
			//Variable temporal de tipo usuario para utilizar sus getters 
			usuario usuarioTemp;
			System.out.println("-----------------------------------");
			
			//Ciclo para recorrer el ArrayList y poder realizar prints de cada usuario 
			for(int i = 0 ; i<usuariosRep.size() ; i++){
				usuarioTemp = usuariosRep.get(i);
				System.out.println("Nombre de usuario: " + usuarioTemp.getNombre());
				System.out.println("Contrasena: " +usuarioTemp.getContrasena() + "\n");
				System.out.println("-----------------------------------");
			}
		}
	}
	
	
	
//--------------------------------------------------- Métodos para los arboles

//Método para pedir datos al usuario del terreno e imprimir los árboles que cumplen con las condicones
	public void filtrosDeBusqueda(){
		
		//variables utilizadas para realizar la bisqueda
		double maxp = 1;
		double minp = 1;
		double maxt = 1;
		double mint = 1;
		String ilum = "";
		String util = "";
		
		System.out.println("\n------------------------Ingrese los datos");
		
		//verificamos el valor de la presipitación max
		boolean validaMax = false;
		while(validaMax != true)
		{
			System.out.print("\n-Ingrese la precipitacion maxima: ");
			try
			{
				double maxip = scan.nextDouble();
				
				if(maxip > 0){
					maxp = maxip;
					validaMax = true;
				}else{
					System.out.println("\n***LA PRECIPITACION MAXIMA DEBE SER MAYOR A CERO***\n");
				}
			}
			catch (Exception e)
			{
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//verificamos el valor de la presipitacion minima
		boolean validaMin = false;
		while(validaMin != true)
		{
			System.out.print("\n-Ingrese la precipitacion minima: ");
			try
			{
				double minip = scan.nextDouble();
				
				if(minip > 0 && minip <= maxp){
					minp = minip;
					validaMin = true;
					
				}else if(minip <= 0){
					System.out.println("\n***LA PRECIPITACION MINIMA DEBE SER MAYOR A 0 ***\n");
				}else if(minip > maxp){
					System.out.println("\n***LA PRECIPITACION MINIMA DEBE SER MENOR A LA MAXIMA***\n");
				}
			}
			catch (Exception e)
			{
				System.out.print("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//verificamos el valor de la temperatura maxima
		boolean validaMaxT = false;
		while(validaMaxT != true){
			System.out.print("\n-Ingrese la temperatura maxima: ");
			
			try{
				maxt = scan.nextDouble();				
				validaMaxT = true;	
			}catch (Exception e){
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//verificamos el valor de la temperatura minima
		boolean validaMinT = false;
		while(validaMinT != true)
		{
			System.out.print("\n-Ingrese la precipitacion minima: ");
			try
			{
				double minit = scan.nextDouble();
				
				if (minit <= maxt){
					mint = minit;
					validaMinT = true;
				}else if(minit > maxt){
					System.out.println("\n***LA TEMPERATURA MINIMA DEBE SER MENOR A LA MAXIMA***\n");
				}
			}catch (Exception e){
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//verificamos que el usuario ingrese bien las iluminacion
		boolean verificadorIlum = false;
		while (verificadorIlum != true){
			System.out.println("\n-Ingrese la iluminacion con la que desea buscar");
			System.out.println("1. Alta");
			System.out.println("2. Media");
			System.out.println("3. Baja");
			System.out.print("=: ");
			
			try{
				int s = scan.nextInt();
				
				if ( s < 4 && s > 0){
					if (s == 1){
						ilum = "Alta";
						verificadorIlum = true;
					}else if (s == 2){
						ilum = "Media";
						verificadorIlum = true;
					}else if(s == 3){
						ilum = "Baja";
						verificadorIlum = true;
					}
				}else if(s <= 0 || s > 3){
					System.out.println("\n***OPCION INVALIDA***\n");
				}
				
			}catch(Exception e){
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		
		
		}
		
		//verificamos qu eel usuario ingrese bien las utilidades
		boolean verificadorUtilidades = false;
		while (verificadorUtilidades != true){
			System.out.println("\n-Ingrese una utilidad con la que desea buscar");
			System.out.println("1. Maderable");
			System.out.println("2. Latex");
			System.out.println("3. Lenia");
			System.out.println("4. Comestible");
			System.out.println("5. Medicinal");
			System.out.println("6. Forraje");
			System.out.println("7. Ornamental");
			System.out.print("=: ");
			
			try{
				int st = scan.nextInt();
				if(st > 0 && st <8 ){
					int n2 = st;
					if (n2 == 1)
					{
						util = "Maderable";
						verificadorUtilidades = true;
					}
					else if (n2 == 2)
					{
						util = "Latex";
						verificadorUtilidades = true;
					}
					else if (n2 == 3)
					{
						util = "Lenia";
						verificadorUtilidades = true;
					}
					else if (n2 == 4)
					{
						util = "Comestible";
						verificadorUtilidades = true;
					}
					else if (n2 == 5)
					{
						util = "Medicinal";
						verificadorUtilidades = true;
					}
					else if (n2 == 6)
					{
						util = "Forraje";
						verificadorUtilidades = true;
					}
					else
					{
						util = "Ornamental";
						verificadorUtilidades = true;
					}
				}else if(st <= 0 || st > 7){
					System.out.println("\n***OPCION INVALIDA***\n");
				}
			}catch(Exception e){
				System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
				scan.nextLine();
			}
		}
		
		//se imprimira un arbol con las caracteristicas que se buscan
		System.out.println(a.filtrado((float)maxp, (float)minp, ilum, (float)maxt, (float)mint, util));
	}
	
	
	//Método para agregar una Especie nueva en la base de datos
	public void agregarArbol(){
		//Variable que cambiará si elusuario existe
		boolean existente = false;
		
		//ArrayList que almacenará objetos de tipo Arbol extraída de la base de datos
		ArrayList <Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol: ");
		String especie = scan.nextLine();
		
		//Ciclo para comprobar si existe la especie introducida por el usuario
		for(int i = 0 ; i<arboles.size() ; i++){
			
			Arbol arbolTemporal = arboles.get(i);
			if(especie.equals(arbolTemporal.getEspecie())){
				//Si el nombre de la especie existe cambiaremos el valor de la variable existente
				existente = true;
			}
		}
		
		//Si la especie no existe se le piden los datos al usuario de la especia a agregar
		if(existente == false){
			float premax = 0;
			boolean validarPremax = false;
			while(validarPremax != true){
				System.out.print("\nIngrese la precipitacion maxima(mm): ");
				try{
					float verificadorPremax = scan.nextFloat();
					if(verificadorPremax > 0){
						premax = verificadorPremax;
						validarPremax = true;
						
					}else if(verificadorPremax <= 0){
						System.out.println("\n***DEBES INGRESAR UNA PRECIPITACION MAYOR A 0***\n");
					}
					
				}catch (Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			//verificamos el valor ingresado por el usuario
			float premin = 0;
			boolean validarPremin = false;
			while(validarPremin != true){
				System.out.print("\nIngrese la precipitacion minima(mm): ");
				try{
					float verificadorPremin = scan.nextFloat();
					
					if(verificadorPremin <= premax && verificadorPremin> 0){
						premin = verificadorPremin;
						validarPremin = true;
					}else if (verificadorPremin >= premax){
						System.out.println("\n***LA PRECIPITACION MINIMA NO PUEDE SER MAYOR A LA MAXIMA***\n");
						
					}else if(verificadorPremin <= 0){
						System.out.println("\n***DEBES INGRESAR UNA PRECIPITACION MAYOR A 0***\n");
					}
				}
				catch (Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			//se crea un arrayLis solo para tener valores ya predefinidos y que el usuario elija
			ArrayList<String> iluminaciones = new ArrayList<String>(Arrays.asList("Alta" , "Media" , "Baja"));
			
			//verificamos el valor ingresado por el usuario
			String textIluminaciones = "";
			boolean validarIluminacion = false;
			while(validarIluminacion != true){
				System.out.println("\n-Ingrese las iluminaciones que desea(numero)");
				for(int i = 0 ; i<iluminaciones.size() ; i++){
					System.out.println((i+1) + "- " + iluminaciones.get(i));
				}
				System.out.print("=: ");
				
				try{
					int opcionIlum = scan.nextInt();
					if(opcionIlum > 0 && opcionIlum <= iluminaciones.size()){
						textIluminaciones += iluminaciones.get(opcionIlum-1) + ", ";
						iluminaciones.remove(opcionIlum-1);
						
						if(iluminaciones.size() != 0){
							boolean otraIluminacion = false;
							while(otraIluminacion != true){
								System.out.println("\n-Desea agregar otra luminacion?");
								System.out.println("1- Si");
								System.out.println("2- No");
								System.out.print("=: ");
								try{
									int otro = scan.nextInt();
									if(otro == 1){
										otraIluminacion = true;
									}else if(otro == 2){
										otraIluminacion = true;
										validarIluminacion = true;
									}else if(otro > 2 || otro <= 0){
										System.out.println("\n***OPCION INVALIDA***\n");
									}
								}catch(Exception e){
									System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
									scan.nextLine();
								}
							}
							
						}else if(iluminaciones.size() == 0){
							validarIluminacion = true;
						}
					}else if(opcionIlum <= 0 || opcionIlum > iluminaciones.size()){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			//verificamos el valor ingresado por el usuario
			float tempmax = 0;
			boolean validarTempmax = false;
			while(validarTempmax != true){
				System.out.print("\nIngrese la temperatura maxima(Celsius): ");
				try{
					tempmax = scan.nextFloat();
					validarTempmax = true;
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			//verificamos el valor ingresado por el usuario
			float tempmin = 0;
			boolean validarTempmin = false;
			while(validarTempmin != true){
				System.out.print("\nIngrese la temperatura minima(Celsius): ");
				try{
					
					float verificadorTempmin = scan.nextFloat();
					if(verificadorTempmin <= tempmax){
						tempmin = verificadorTempmin;
						validarTempmin = true;
					}else if(verificadorTempmin > tempmax){
						System.out.println("\n***LA TEMPERATURA MINIMA NO PUEDE SER MAYOR QUE LA MAXIMA***\n");
					}
					
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}					
			}
			//se crea un arrayList con utilidades predefinidas para que el usuario elija
			ArrayList<String> utilidades = new ArrayList<String>(Arrays.asList("Maderable" , "Latex" , "Lenia" , "Comestible" , "Medicinal" , "Forraje" , "Ornamental"));
			
			
			//verificamos el valor ingresado por el usuario
			String textUtilidades = "";
			boolean validarUtilidades = false;
			while(validarUtilidades != true){
				System.out.println("\n-Ingrese las utilidades que desea(numero)");
				for(int i = 0 ; i<utilidades.size() ; i++){
					System.out.println((i+1) + "- " + utilidades.get(i));
				}
				System.out.print("=: ");
				
				try{
					int opcionUtilidad = scan.nextInt();
					if(opcionUtilidad > 0 && opcionUtilidad <= utilidades.size()){
						textUtilidades += utilidades.get(opcionUtilidad-1) + ", ";
						utilidades.remove(opcionUtilidad-1);
						
						if(utilidades.size() != 0){
							boolean otraUtilidad = false;
							while(otraUtilidad != true){
								System.out.println("\n-Desea agregar otra utilidad?");
								System.out.println("1- Si");
								System.out.println("2- No");
								System.out.print("=: ");
								try{
									int otro = scan.nextInt();
									if(otro == 1){
										otraUtilidad = true;
									}else if(otro == 2){
										otraUtilidad = true;
										validarUtilidades = true;
									}else if(otro > 2 || otro <= 0){
										System.out.println("\n***OPCION INVALIDA***\n");
									}
								}catch(Exception e){
									System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
									scan.nextLine();
								}
							}
							
						}else if(utilidades.size() == 0){
							validarUtilidades = true;
						}
					}else if(opcionUtilidad <= 0 || opcionUtilidad > utilidades.size()){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			//Calculos para obtener la tempratura promedio y un delta de los valroes flaot
			float precipitacion = ((premin+premax)/2.0f);
			float deltaPre = (premax-precipitacion);
			
			float temperatura = ((tempmax+tempmin)/2.0f);
			float deltaTem = (tempmax-temperatura);
			//Instanciar el objeto 
			Arbol nuevoArbol = new Arbol(especie, precipitacion, deltaPre, textIluminaciones, temperatura, deltaTem, textUtilidades);
			//gaurdar el objeto en el ArrayList
			arboles.add(nuevoArbol);
			//Sobrescribir la lista de la base de datos
			a.GuardarDatos(arboles);
			
			System.out.println("-----------------------------------");
			System.out.println("  ESPECIE AGREGADA CORRECTAMENTE");
			System.out.println("-----------------------------------");
		}else{
			System.out.println("************************************************");
			System.out.println("ESPECIE YA EXISTENTE, INGRESE UNA NO REGISTRADA");
			System.out.println("************************************************");
		}
	}
	//Método para Eliminar especies de la base de datos
	public void eliminarArbol(){
		
		//Variable que cambiará si el usuario existe o no
		boolean existente = false;
		//ArrayList que almacenará objetos de tipo Arbol estraido de la base de datos
		ArrayList <Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol que desea eliminar: ");
		String especie = scan.nextLine();
		
		for(int i = 0 ; i<arboles.size() ; i++){
			Arbol arbolTemporal = arboles.get(i);
			//comprobar si la especie agregada ya existe y si es así, la elimina
			if(especie.equals(arbolTemporal.getEspecie())){
				existente = true;
				arboles.remove(i);
			}
		}
			
		if(existente == true){
			System.out.println("-----------------------------------");
			System.out.println("  ESPECIE ELIMINADA CORRECTAMENTE");
			System.out.println("-----------------------------------");
			a.GuardarDatos(arboles);
			
		}else{
			System.out.println("*******************************************************");
			System.out.println("ESPECIE NO ENCONTRADA, NO SE ELIMINO NINGUNA ESPECIE");
			System.out.println("*******************************************************");
		}
	}
	
	
	//metodo para modificar especies
	public void modificarArboles(){
		
		//se lee la base de datos y se guarda en un ArrayList
		ArrayList<Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol que desea modificar: ");
		String especie = scan.nextLine();
		
		//se verifica que la especie ingresada exista
		boolean existente = false;
		Arbol arbolModificar = null;
		for(int i = 0 ; i<arboles.size() ; i ++ ){
			Arbol arbolTemporal = arboles.get(i);
			if(especie.equals(arbolTemporal.getEspecie())){
				arbolModificar = arbolTemporal;
				arboles.remove(i);
				existente = true;
			}
		}
		//si existe se solicitarán datos
		if(existente == true){
			System.out.println("\n-------NOMBRE DE LA ESPECIE A MODIFICAR: " + especie);
			
			System.out.print("\nIngrese el nuevo nombre del arbol: ");
			String especieN = scan.nextLine();
			arbolModificar.setEspecie(especieN);
			
			//verificamos el valor ingresado por el usuario
			float premax = 0;
			boolean validarPremax = false;
			while(validarPremax != true){
				System.out.print("\nIngrese la precipitacion maxima(mm): ");
				try{
					float verificadorPremax = scan.nextFloat();
					if(verificadorPremax > 0){
						premax = verificadorPremax;
						validarPremax = true;
						
					}else if(verificadorPremax <= 0){
						System.out.println("\n***DEBES INGRESAR UNA PRECIPITACION MAYOR A 0***\n");
					}
					
				}catch (Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			//verificamos el valor ingresado por el usuario
			float premin = 0;
			boolean validarPremin = false;
			while(validarPremin != true){
				System.out.print("\nIngrese la precipitacion minima(mm): ");
				try{
					float verificadorPremin = scan.nextFloat();
					
					if(verificadorPremin <= premax && verificadorPremin> 0){
						premin = verificadorPremin;
						validarPremin = true;
					}else if (verificadorPremin >= premax){
						System.out.println("\n***LA PRECIPITACION MINIMA NO PUEDE SER MAYOR A LA MAXIMA***\n");
						
					}else if(verificadorPremin <= 0){
						System.out.println("\n***DEBES INGRESAR UNA PRECIPITACION MAYOR A 0***\n");
					}
				}
				catch (Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			
			ArrayList<String> iluminaciones = new ArrayList<String>(Arrays.asList("Alta" , "Media" , "Baja"));
			
			
			//verificamos el valor ingresado por el usuario
			String textIluminaciones = "";
			boolean validarIluminacion = false;
			while(validarIluminacion != true){
				System.out.println("\n-Ingrese las iluminaciones que desea(numero)");
				for(int i = 0 ; i<iluminaciones.size() ; i++){
					System.out.println((i+1) + "- " + iluminaciones.get(i));
				}
				System.out.print("=: ");
				
				try{
					int opcionIlum = scan.nextInt();
					if(opcionIlum > 0 && opcionIlum <= iluminaciones.size()){
						textIluminaciones += iluminaciones.get(opcionIlum-1) + ", ";
						iluminaciones.remove(opcionIlum-1);
						
						if(iluminaciones.size() != 0){
							boolean otraIluminacion = false;
							while(otraIluminacion != true){
								System.out.println("\n-Desea agregar otra luminacion?");
								System.out.println("1- Si");
								System.out.println("2- No");
								System.out.print("=: ");
								try{
									int otro = scan.nextInt();
									if(otro == 1){
										otraIluminacion = true;
									}else if(otro == 2){
										otraIluminacion = true;
										validarIluminacion = true;
									}else if(otro > 2 || otro <= 0){
										System.out.println("\n***OPCION INVALIDA***\n");
									}
								}catch(Exception e){
									System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
									scan.nextLine();
								}
							}
							
						}else if(iluminaciones.size() == 0){
							validarIluminacion = true;
						}
					}else if(opcionIlum <= 0 || opcionIlum > iluminaciones.size()){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			//se modifica la iluminacion del arbol
			arbolModificar.setIluminacion(textIluminaciones);
			
			//verificamos el valor ingresado por el usuario
			float tempmax = 0;
			boolean validarTempmax = false;
			while(validarTempmax != true){
				System.out.print("\nIngrese la temperatura maxima(Celsius): ");
				try{
					tempmax = scan.nextFloat();
					validarTempmax = true;
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			float tempmin = 0;
			boolean validarTempmin = false;
			while(validarTempmin != true){
				System.out.print("\nIngrese la temperatura minima(Celsius): ");
				try{
					
					float verificadorTempmin = scan.nextFloat();
					if(verificadorTempmin <= tempmax){
						tempmin = verificadorTempmin;
						validarTempmin = true;
					}else if(verificadorTempmin > tempmax){
						System.out.println("\n***LA TEMPERATURA MINIMA NO PUEDE SER MAYOR QUE LA MAXIMA***\n");
					}
					
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}					
			}
			
			
			ArrayList<String> utilidades = new ArrayList<String>(Arrays.asList("Maderable" , "Latex" , "Lenia" , "Comestible" , "Medicinal" , "Forraje" , "Ornamental"));
			
			//verificamos el valor ingresado por el usuario
			String textUtilidades = "";
			boolean validarUtilidades = false;
			while(validarUtilidades != true){
				System.out.println("\n-Ingrese las utilidades que desea(numero)");
				for(int i = 0 ; i<utilidades.size() ; i++){
					System.out.println((i+1) + "- " + utilidades.get(i));
				}
				System.out.print("=: ");
				
				try{
					int opcionUtilidad = scan.nextInt();
					if(opcionUtilidad > 0 && opcionUtilidad <= utilidades.size()){
						textUtilidades += utilidades.get(opcionUtilidad-1) + ", ";
						utilidades.remove(opcionUtilidad-1);
						
						if(utilidades.size() != 0){
							boolean otraUtilidad = false;
							while(otraUtilidad != true){
								System.out.println("\n-Desea agregar otra utilidad?");
								System.out.println("1- Si");
								System.out.println("2- No");
								System.out.print("=: ");
								try{
									int otro = scan.nextInt();
									if(otro == 1){
										otraUtilidad = true;
									}else if(otro == 2){
										otraUtilidad = true;
										validarUtilidades = true;
									}else if(otro > 2 || otro <= 0){
										System.out.println("\n***OPCION INVALIDA***\n");
									}
								}catch(Exception e){
									System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
									scan.nextLine();
								}
							}
							
						}else if(utilidades.size() == 0){
							validarUtilidades = true;
						}
					}else if(opcionUtilidad <= 0 || opcionUtilidad > utilidades.size()){
						System.out.println("\n***OPCION INVALIDA***\n");
					}
				}catch(Exception e){
					System.out.println("\n***DEBES INGRESAR UNA CANTIDAD NUMERICA***\n");
					scan.nextLine();
				}
			}
			
			//se modifica las utilidades del arbol
			arbolModificar.setUtilidades(textUtilidades);
			
			
			//se realizan los delta de la precipitacion y de la temperatura para sacar un promedio
			float precipitacion = ((premin+premax)/2.0f);
			float deltaPre = (premax-precipitacion);
			//se modifican los valores
			arbolModificar.setPrecipitacion(precipitacion);
			arbolModificar.setDeltaPre(deltaPre);
			
			float temperatura = ((tempmax+tempmin)/2.0f);
			float deltaTem = (tempmax-temperatura);
			
			
			//se modifican los valores
			arbolModificar.setTemperatura(temperatura);
			arbolModificar.setDeltaTem(deltaTem);

			//se vuelve a guardar el arbol en el Array 
			arboles.add(arbolModificar);
			//se sobreescribe el arrayList
			a.GuardarDatos(arboles);
			
			System.out.println("-----------------------------------");
			System.out.println("  ESPECIE MODIFICADA CORRECTAMENTE");
			System.out.println("-----------------------------------");
			a.GuardarDatos(arboles);
			
		}else{
			System.out.println("*******************************************************");
			System.out.println(" ESPECIE NO ENCONTRADA, NO SE MODIFICO NINGUNA ESPECIE");
			System.out.println("*******************************************************");
			
		}
		
	}
	
	//Método que simplemente imprime los Strings de un método de la clase Archivos
	public void mostrarArboles(){
		System.out.println("-----------------------------------");
		System.out.println(a.mostrarArboles());
	}
	

	
	
	//---------------salidas
	public boolean salirPerfil(){
		boolean cerrar = false;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n QUIERES SALIR DE TU PERFIL? ");
			
			System.out.println("1- Si");
			System.out.println("2- No");
			try {
				System.out.print("=: ");
				int salir = scan.nextInt();
				
			
				if(salir == 1){
					
					System.out.println("-----------------------------------");
					System.out.println("		 CERRANDO...");
					System.out.println("-----------------------------------");
					try {

						Thread.sleep(2*1000);

					}catch(InterruptedException e){
						 
					}
					System.out.println("-----------------------------------");
					System.out.println("		   PERFIL CERRADO");
					System.out.println("-----------------------------------");
					cerrar = true;
					seguir = true;
				}else if(salir == 2){
					System.out.println("-----------------------------------------");
					System.out.println("      NO SE HA CERRADO SESION (:");
					System.out.println("-----------------------------------------\n");
					seguir = true;
				}else if(salir > 2 || salir <= 0){
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
				}
			}catch(Exception e){
				System.out.println("\n***DEBES INDICAR CON UN 1 O 2 ***\n");
				scan.nextLine();
			}
		}
		
		return cerrar;
	}
	
	public boolean salirPrograma(){
		boolean cerrar = false;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n QUIERES SALIR DEL PROGRAMA? ");
			
			System.out.println("1- Si");
			System.out.println("2- No");
			try {
				System.out.print("=: ");
				int salir = scan.nextInt();
				
			
				if(salir == 1){
					System.out.println("-----------------------------------------");
					System.out.println("GRACIAS POR UTILIZAR NUESTRA PLATAFORMA");
					System.out.println("-----------------------------------------\n");
					System.out.println("              FORESTWIN.\n");
					cerrar = true;
					seguir = true;
				}else if(salir == 2){
					System.out.println("-----------------------------------------");
					System.out.println("     QUE BUENO QUE SIGUES AQUI (:");
					System.out.println("-----------------------------------------\n");
					seguir = true;
				}else if(salir > 2 || salir <= 0){
					System.out.println("\n***ESTA OPCION NO ES VALIDA***\n");
				}
			}catch(Exception e){
				System.out.println("\n***DEBES INDICAR CON UN 1 O 2 ***\n");
				scan.nextLine();
			}
		}
		
		return cerrar;
	}
	
	
	
}
