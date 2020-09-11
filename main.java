
class main{
	public static void main(String[] args){
		vista v = new vista();
		
		int opcion = 0;
		while(opcion != 5){
			opcion = v.menu();
			
			if(opcion == 1){
				if(v.login()){
					int subOpcion = 0;
					while(subOpcion != 5){
					
						subOpcion = v.subMenu();
						
						if(subOpcion == 1){
							v.mostrarArboles();
						}else if(subOpcion == 2){
							v.leerArboles();
						}else if(subOpcion == 3){
							//aqui iria lo de eliminar
						}else if(subOpcion == 4){
							if(v.salirPerfil()){
								subOpcion = 5;
							}
								
						}
					}
				}
			}else if(opcion == 2){
				v.crear();
			}else if(opcion ==3){
				v.mostrarUsuarios();
				
			}else if(opcion == 4){
				if(v.salirPrograma()){
					opcion = 5;
				}
			}
		
		}
		
		
	}
}