import java.io.*;
import java.util.*;

class archivo{
	
	public void nuevoU(ArrayList<usuario> usuarios){
		
		
		 try{
            //Instanciar el guardador de base de datos
            ObjectOutputStream GuardarDatos = new ObjectOutputStream(new FileOutputStream("Usuarios.forestwin"));

            // Escribir la Base de datos de Arboles
            GuardarDatos.writeObject(usuarios);
            GuardarDatos.close();

        }catch (Exception e){}
		
    }
	
	
	public ArrayList<usuario> leerUsuarios(){
		try{
            //Instanciar el lector de base de datos
            ObjectInputStream AbrirDatos = new ObjectInputStream(new FileInputStream("Usuarios.forestwin"));

            //Leer la Base de datos de Arboles
            ArrayList<usuario> UsuariosTemp= (ArrayList<usuario>) AbrirDatos.readObject();
            AbrirDatos.close();
            return UsuariosTemp;

        }catch (Exception e){
            return null;
        }
	}
	
	
	public ArrayList<Arbol> leerArboles(){
		try{
            //Instanciar el lector de base de datos
            ObjectInputStream AbrirDatos = new ObjectInputStream(new FileInputStream("DatosArboles.forestwin"));

            //Leer la Base de datos de Arboles
            ArrayList<Arbol> UsuariosTemp= (ArrayList<Arbol>) AbrirDatos.readObject();
            AbrirDatos.close();
            return UsuariosTemp;

        }catch (Exception e){
            return null;
        }
	}
	
	public String mostrarArboles(){
		String Retornar = "";
		try{
            //Instanciar el lector de base de datos
            ObjectInputStream AbrirDatos = new ObjectInputStream(new FileInputStream("DatosArboles.forestwin"));

            //Leer la Base de datos de Arboles
            ArrayList<Arbol> ListaArboles_recuperada = (ArrayList<Arbol>) AbrirDatos.readObject();
            AbrirDatos.close();
			
			
			Arbol temp;
						
			for (int i = 0; i < ListaArboles_recuperada.size(); i++) {
				temp = ListaArboles_recuperada.get(i);
				Retornar = Retornar + "Especie: " + temp.getEspecie() + "\n";
				Retornar = Retornar + "Precipitacion Maxima: " + temp.getPrMax() + "\n";
				Retornar = Retornar + "Precipitacion Minima: " + temp.getPrMin() + "\n";
				Retornar = Retornar + "Tipo de Iluminacion: " + temp.getIluminacion() + "\n";
				Retornar = Retornar + "Temperatura Maxima: " + temp.getTempMax() + "\n";
				Retornar = Retornar + "Temperatura Minima: " + temp.getTempMin() + "\n";
				Retornar = Retornar + "Utilidades: " + temp.getUtilidades() + "\n";
				Retornar = Retornar + "----------------------------------------------\n";
			}
			
            return Retornar;

        }catch (Exception e){
            System.out.println("Base de Datos no encontrada");
            return "Base de datos no encontrada";
        }
		
	}

}