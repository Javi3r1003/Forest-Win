/***************************************************************************
									ForestWin
Proyecto Programación Orientada a Objetos
 filtro.java (Clase filtro)
 Autores: Erick Raúl Alvarez Melgar - Carné 20900
		  Adam Sebastian Rios Kirste - Carné 20616
		  Juan Pablo Zelada Ramirez - Carné 201004
		  César Rodrigro Meza Torres - Carné 20287
		  Alberto Antonio Ortega Romero - Carné 20884
		  Javier Alejandro Mejía Alecio - Carné 20304

En esta clase se realizará la busqueda de arboles utilizando valores que el
usuario haya ingresado y poder así mostrarle especies con las que concidan los mismos
 ****************************************************************************/
 
//se importan las librerías que se utilizarán
import java.util.Random;
import java.util.ArrayList;

//clase filctro
public class filtro 
{
	//Propiedades de las clases
	private ArrayList<Arbol> arboles;
	private ArrayList<Arbol> filtrados;
	private archivo a;
	
	//Constructor
	public filtro()
	{
		arboles = new ArrayList<Arbol>();
		filtrados = new ArrayList<Arbol>();
		a = new archivo();
		arboles = a.leerArboles();
	}
	
	//Método de filtracion
	public String filtrar(float premax, float premin, String ilu, float temax, float temin, String uti)
	{
		int b = 0;
		
		//se realiza una busqueda para comparar valores
		for (int i = 0; i < arboles.size(); i++)
		{			
			Arbol ar = arboles.get(i);
			
			float p = ar.getPrecipitacion();
			float dp = ar.getDeltaPre();
			
			float t = ar.getTemperatura();
			float dt = ar.getDeltaTem();
			
			String ilm = ar.getIluminacion();
			String u = ar.getUtilidades();
			
			//Se sumaron números al rango para que los arboles que esten cerca de este aparezcan, de manera que se obtengan arboles con propiedades similares
			if(((p - dp) <= premin+5) && ((p + dp) >= premax-5))
			{
				if(ilm.contains(ilu))
				{
					if (((t - dt) <= temin+1) && ((t + dt) >= temax-1))
					{						
						if(u.contains(uti))
						{
							b = 1;
							filtrados.add(ar);
						}
					}
				}
			}
		}
		
		if (b == 1)
		{
			//se retorna un string con los valores necesarios
			return this.toString();
		}		
		else
		{
			return "No se encontro ningun arbol que cumpla con las caracteristicas";
		}
				
	}
	
	//Método para convertir la lista en string
	public String toString()
	{
		String s = "";
		for(int i = 0; i < filtrados.size(); i++)
		{
			Arbol arbolin = filtrados.get(i);
			String nombre = arbolin.getEspecie();
			float precipitacion = arbolin.getPrecipitacion();
			float deltaPrecipitacion = arbolin.getDeltaPre();
			String iluminacion = arbolin.getIluminacion();
			float temperatura =  arbolin.getTemperatura();
			float deltaTemperatura = arbolin.getDeltaTem();
			String usos = arbolin.getUtilidades();
			
			s += '\n' + "Nombre: " + nombre;
			s += '\n' + "Precipitacion: " + precipitacion + " +- " + deltaPrecipitacion;
			s += '\n' + "Iluminacion: " + iluminacion;
			s += '\n' + "Temperatura" + temperatura + " +- " + deltaTemperatura;
			s += '\n' + "Usos: " + usos;   
			s += '\n' + "--------------------------------------------------------------";
		}
		
		return s;
	}
	
}
