//César Rodrigo Meza Torres 20287
//Clase filtro

import java.util.Random;
import java.util.ArrayList;

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
	public String filtrar(float pre, String ilu, float tem, String uti)
	{
		int b = 1;
		
		for (int i = 0; i < arboles.size(); i++)
		{
			
			
			Arbol ar = arboles.get(i);
			
			float p = ar.getPrecipitacion();
			float dp = ar.getDeltaPre();
			
			float t = ar.getTemperatura();
			float dt = ar.getDeltaTem();
			
			if((pre <= (p + dp) && ((p - dp) <= pre)))
			{
				if(ar.getIluminacion().contains(ilu))
				{
					if((tem <= (t + dt)) && ((t - dt) <= tem))
					{
						if(ar.getUtilidades().contains(uti))
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
			s +=  "Nombre: " + filtrados.get(i).getEspecie() + "Precipitacion: " + filtrados.get(i).getPrecipitacion() + "+-" + filtrados.get(i).getDeltaPre() + "Iluminación: " + filtrados.get(i).getIluminacion() + "Temperatura" + filtrados.get(i).getTemperatura() + "+-" + filtrados.get(i).getDeltaTem() + "Usos: " + filtrados.get(i).getUtilidades();           
		}
		
		return s;
	}
	
}
