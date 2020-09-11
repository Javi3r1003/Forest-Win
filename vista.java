import java.util.*;

class vista{
	Scanner scan;
	archivo a;
	vista(){
		scan = new Scanner(System.in);
		a = new archivo();
	}
	
	public int menu(){
		System.out.println("\n            FORESTWIN");
		System.out.println("-----------------------------------");
		System.out.println("\n1- Iniciar sesion");
		System.out.println("2- Registrarse");
		System.out.println("3- Mostrar Usuarios");
		System.out.println("4- Salir");
		System.out.print("Ingrese la opcion que desea ejecutar: ");
		int opcion = scan.nextInt();
	
		
		return opcion;
		
	}
	
	public int subMenu(){
		System.out.println("\n1- Mostrar todos los arboles existentes");
		System.out.println("2- Filtros de busqueda");
		System.out.println("3- Eliminar un arbol");
		System.out.println("4- Salir");
		
		System.out.print("Ingrese la opcion que desea ejecutar: ");
		int opcion = scan.nextInt();
		return opcion;
	}
	
	
	public boolean login(){
		
		boolean logeado = false;
		
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		usuario usuarioTemp = null;
		if(usuariosRep != null){
			System.out.print("Ingrese su nombre de usuario: ");
			String nombre = scan.next();
		
			
			boolean comprobadorUsuario = false;
			boolean comprobadorContrasena = false;
			
			for(int i = 0 ; i<usuariosRep.size() ; i++){
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
		
		
		return logeado;
		
	}
	
	
	
	//creamos cada uno de los usuarios y lo mandamos al método de nuevoU de archivos para guardarlo en el txt
	public void crear(){
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		usuario usuarioTemp;
		
		System.out.print("Ingrese su nombre de usuario: ");
		String nombre = scan.next();
		
		if(usuariosRep != null){
			
			int contador=0;
			
			for(int i = 0 ; i<usuariosRep.size() ; i++){
				usuarioTemp = usuariosRep.get(i);
				if(nombre.equals(usuarioTemp.getNombre())){
					contador = 1;
				
				}
			}
			if(contador != 0){
				System.out.println("**************************");
				System.out.println("USURARIO YA REGISTRADO");
				System.out.println("**************************");
			}else{
				System.out.print("Ingrese su contrasena: ");
				String contra = scan.next();
				usuario u = new usuario(nombre, contra);
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
			usuario u = new usuario(nombre, contra);
			usuariosRep.add(u);
			a.nuevoU(usuariosRep);
			System.out.println("-----------------------------------");
			System.out.println("USUARIO REGISTRADO EXITOSAMENTE");
			System.out.println("-----------------------------------");
		}
			
		
	}
	//es el método imprimir de la clase archivo
	public void mostrarUsuarios(){
		ArrayList<usuario> usuariosRep = a.leerUsuarios();
		
		if(usuariosRep == null){
			System.out.println("************************************************");
			System.out.println("BASE DE DATOS NO ENCONTRADA, REGISTRE UN USUARIO");
			System.out.println("************************************************");
		}else{
			usuario usuarioTemp;
			System.out.println("-----------------------------------");
			for(int i = 0 ; i<usuariosRep.size() ; i++){
				usuarioTemp = usuariosRep.get(i);
				System.out.println("Nombre de usuario: " + usuarioTemp.getNombre());
				System.out.println("Contrasena: " +usuarioTemp.getContrasena() + "\n");
				System.out.println("-----------------------------------");
			}
		}
	}
	//Método para obtener el arraylist de arboles
	public void leerArboles(){
		ArrayList <Arbol> arboles = a.leerArboles();
		
	}
	
	public void mostrarArboles(){
		System.out.println("-----------------------------------");
		System.out.println(a.mostrarArboles());
	}
	
	public boolean salirPerfil(){
		boolean cerrar = false;
		System.out.println("\n QUIERES SALIR DE TU PERFIL? ");
		
		System.out.println("1- Si");
		System.out.println("2- No");
		
		System.out.print("=: ");
		
		int salir = scan.nextInt();
		if(salir == 1){
			System.out.println("-----------------------------------");
			System.out.println("		   PERFIL CERRADO");
			System.out.println("-----------------------------------");
			cerrar = true;
		}
		
		return cerrar;
	}
	
	public boolean salirPrograma(){
		boolean cerrar = false;
		System.out.println("\n QUIERES SALIR DEL PROGRAMA? ");
		
		System.out.println("1- Si");
		System.out.println("2- No");
		
		System.out.print("=: ");
		
		int salir = scan.nextInt();
		if(salir == 1){
			System.out.println("-----------------------------------------");
			System.out.println("GRACIAS POR UTILIZAR NUESTRA PLATAFORMA");
			System.out.println("-----------------------------------------\n");
			System.out.println("              FORESWIN.\n");
			cerrar = true;
		}
		
		return cerrar;
	}
	
	
}