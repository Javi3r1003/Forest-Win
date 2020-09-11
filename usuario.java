import java.io.Serializable;


class usuario implements Serializable {
	String nombre;
	String contrasena;
	
	usuario(String n, String c){
		nombre = n;
		contrasena = c;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getContrasena(){
		return contrasena;
	}
}