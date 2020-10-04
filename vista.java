/***************************************************************************
									ForestWin
Proyecto Programación Orientada a Objetos
 vista.java (Clase vosta)
 Autores: Erick Raúl Alvarez Melgar - Carné 20900
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
//-------------------------------------------Métodos oara los menú

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
	
	//Método para imprimir el sub menú y pedirle las opciones al usuario
	public int subMenu(){
		int opcion = 0;
		boolean seguir = false;
		while (seguir != true){
			System.out.println("\n1- Mostrar todos los arboles existentes");
			System.out.println("2- Filtros de busqueda(pendiente)");//funcionalidad pendiente
			System.out.println("3- Agregar Especie");
			System.out.println("4- Eliminar especie");
			System.out.println("5- Modificar especie");
			System.out.println("6- Salir");
		
		
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
	
	//Método para pedir datos al usuario del terreno e imprimir los árboles que cumplen con las condicones
	public void filtrosDeBusqueda()
	{
		float maxp = 1;
		float minp = 1;
		float maxt = 1;
		float mint = 1;
		float p, t, dp, dt; 
		String ilum = "";
		String util = "";
		String s, st;
		boolean i = false;
		boolean u = false;
		int c = 0;
		
		System.out.println("\n1-Ingrese los datos");
		System.out.println("Ingrese la precipitacion maxima");
		maxp = scan.nextFloat();
		System.out.println("Ingrese la precipitacion minima");
		minp = scan.nextFloat();
		System.out.println("Ingrese la temperatura maxima");
		maxp = scan.nextFloat();
		System.out.println("Ingrese la temperatura minima");
		minp = scan.nextFloat();
		
		p = ((maxp+minp)/2);
		dp = maxp - p;
		
		t = ((maxt+mint)/2);
		dt = maxt - t;
		
		System.out.println("Ingrese la iluminacion");
		s = scan.next();
		ilum = ilum + "," + s;
		
		while (i == false)
		{

			System.out.println("Desea ingresar otra iluminacion?");
			System.out.println("1. Si");
			System.out.println("2. No");
			int x = scan.nextInt();
			
			if (x == 1)
			{
				System.out.println("Ingrese la iluminacion");
				s = scan.next();
				ilum = ilum + "," + s;
			}
			else
			{
				i = true;
			}
		}
		
		System.out.println("Ingrese una utilidad");
		st = scan.next();
		util = util + "," + st;
		
		while (u == false)
		{

			System.out.println("Desea ingresar otra utilidad?");
			System.out.println("1. Si");
			System.out.println("2. No");
			int y = scan.nextInt();
			
			if (y == 1)
			{
				System.out.println("Ingrese la utilidad");
				st = scan.next();
				util = util + "," + st;
			}
			else
			{
				u = true;
			}
		}
		
		System.out.println(a.filtrado(p, ilum, t, util));
	}
	
	
//---------------------------------------------------Métodos para los uauarios

	//Método para iniciar sesión con usuarios registrados en la base de datos
	public boolean login(){
		//variable para verificar si el usuario existe
		boolean logeado = false;
		
		//ArrayList temporal que almacena los objetos de tipo arbol de la base de datos
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		usuario usuarioTemp = null;

		if(usuariosRep != null){
			System.out.print("Ingrese su nombre de usuario: ");
			String nombre = scan.next();
		
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
				
				
				System.out.print("Ingrese su contrasena: ");
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
					
					
					System.out.println("\n          BIENVENIDO " + usuarioTemp.getNombre() + "\n");
					logeado = true;
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
		return logeado;
		
	}
	
	
	private int tipoUsuario(){
		
		int tipo = 0;
		System.out.println("\nIngrese el tipo de usuario que desea crear.");
		System.out.println("1- Estandar.");
		System.out.println("2- Administrador.");
		
		try {
			System.out.print("=: ");
			tipo = scan.nextInt();
			
		
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
			String nombre = scan.next();
			
			
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
			String nombre = scan.next();
			
			
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
	//Método para agregar una Especie nueva en la base de datos
	public void agregarArbol(){
		//Variable que cambiará si elusuario existe
		boolean existente = false;
		
		//ArrayList que almacenará objetos de tipo Arbol extraída de la base de datos
		ArrayList <Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol: ");
		String especie = scan.next();
		
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
			System.out.print("\nIngrese la precipitacion maxima(mm): ");
			float premax = scan.nextFloat();
			
			System.out.print("\nIngrese la precipitacion minima(mm): ");
			float premin = scan.nextFloat();
			
			
			System.out.println("\nIngrese el tipo de iluminacion(solo un tipo): ");
			System.out.println("Alta");
			System.out.println("Media");
			System.out.println("Baja");
			System.out.print("=: ");
			String ilum = scan.next();
			scan.nextLine();
			
			
			
			System.out.print("\nIngrese la temperatura maxima(Celsius): ");
			float tempmax = scan.nextFloat();
			
			
			System.out.print("\nIngrese la temperatura minima(Celsius): ");
			float tempmin = scan.nextFloat();
			
			System.out.println("\nIngrese las utilidades del arbol, separelo por comas(una utilidad)");
			System.out.println("Maderable");
			System.out.println("Latex");
			System.out.println("Lena");
			System.out.println("Comestible");
			System.out.println("Medicinal");
			System.out.println("Forraje");
			System.out.println("Ornamental");
			System.out.print("=: ");
			String utilidades = scan.next();
			
			//Calculos para obtener la tempratura promedio y un delta de los valroes flaot
			float precipitacion = ((premin+premax)/2.0f);
			float deltaPre = (premax-precipitacion);
			
			float temperatura = ((tempmax+tempmin)/2.0f);
			float deltaTem = (tempmax-temperatura);
			//Instanciar el objeto 
			Arbol nuevoArbol = new Arbol(especie, precipitacion, deltaPre, ilum, temperatura, deltaTem, utilidades);
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
		String especie = scan.next();
		
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
	
	public void modificarArboles(){
		ArrayList<Arbol> arboles = a.leerArboles();
		System.out.print("\nIngrese la especie del arbol que desea modificar: ");
		String especie = scan.next();
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
		
		if(existente == true){
			System.out.println("\n-------NOMBRE DE LA ESPECIE A MODIFICAR: " + especie);
			
			System.out.print("\nIngrese el nuevo nombre del arbol: ");
			String especieN = scan.next();
			arbolModificar.setEspecie(especieN);
			
			System.out.print("\nIngrese la precipitacion maxima(mm): ");
			float premax = scan.nextFloat();
			
			System.out.print("\nIngrese la precipitacion minima(mm): ");
			float premin = scan.nextFloat();
			
			
			System.out.println("\nIngrese el tipo de iluminacion(solo un tipo): ");
			System.out.println("Alta");
			System.out.println("Media");
			System.out.println("Baja");
			System.out.print("=: ");
			String ilum = scan.next();
			
			arbolModificar.setIluminacion(ilum);
			
			
			System.out.print("\nIngrese la temperatura maxima(Celsius): ");
			float tempmax = scan.nextFloat();
			
			
			System.out.print("\nIngrese la temperatura minima(Celsius): ");
			float tempmin = scan.nextFloat();
			
			System.out.println("\nIngrese las utilidades del arbol, separelo por comas(una utilidad)");
			System.out.println("Maderable");
			System.out.println("Latex");
			System.out.println("Lena");
			System.out.println("Comestible");
			System.out.println("Medicinal");
			System.out.println("Forraje");
			System.out.println("Ornamental");
			System.out.print("=: ");
			String utilidades = scan.next();
			
			arbolModificar.setUtilidades(utilidades);
			

			float precipitacion = ((premin+premax)/2.0f);
			float deltaPre = (premax-precipitacion);
			
			arbolModificar.setPrecipitacion(precipitacion);
			arbolModificar.setDeltaPre(deltaPre);
			
			float temperatura = ((tempmax+tempmin)/2.0f);
			float deltaTem = (tempmax-temperatura);
			
			arbolModificar.setTemperatura(temperatura);
			arbolModificar.setDeltaTem(deltaTem);


			arboles.add(arbolModificar);
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
