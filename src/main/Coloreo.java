package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Coloreo {
	
	private Grafo grafo;
	
	public Coloreo(Grafo grafo)
	{
		this.grafo = grafo;
	}
	
	public HashMap<Integer, String> colorear()
	{
		HashMap<Integer, String> salida = new HashMap<>();
		salida.put(0, "0"); // Esto indica que el color 0, por ahora, contiene al nodo 0 (que seria el representado por la primer fila de la matriz de adyacencia. //
		
		ArrayList<Integer> coloresEnElMomento = new ArrayList<>();
		coloresEnElMomento.add(0); // Este ArrayList contiene los colores que ya estan presentes en el grafo. //
		Integer siguienteColor = 1;
	
		
		for(int i = 1; i<grafo.obtenerCantNodos(); i++)
		{
			ArrayList<Integer> coloresATachar = new ArrayList<Integer>(coloresEnElMomento);
			for(int j = 0; j<i; j++)
			{
				if(grafo.obtenerValor(i, j)!=1000000 && grafo.obtenerValor(i, j)!=0)
				{
					for(int z = 0; z<coloresEnElMomento.size(); z++) // Itera por cada color que ya exista en el grafo. //
					{
						Integer colorActual = coloresEnElMomento.get(z);
						boolean seguirConEsteNodo = true;
						
						String values = salida.get(colorActual);
						if(values!=null)
						{
							String[] valores = values.split(" ");
							for(int a = 0; a<valores.length; a++)
							{
								if(valores[a].equals(String.valueOf(j)))
								{
									coloresATachar.remove((Integer)z); // Sin ese casteo de "z" el remove tomaba ese numero como la posicion a borrar y no el OBJETO a borrar. //
									seguirConEsteNodo = false;
									break;
								}
							}
						}
						
						if(seguirConEsteNodo == false)
						{
							break;
						}
					}
				}
			}
			
			if(coloresATachar.size()>0)
			{
				Integer colorAPonerseEnEsteNodo = coloresATachar.get(0); // Tomo el primer color de los disponibles para ser coloreado. //
				String aux = salida.get(colorAPonerseEnEsteNodo);
				aux = aux+" "+String.valueOf(i);
				salida.put(colorAPonerseEnEsteNodo, aux);
			}
			else
			{
				coloresEnElMomento.add(siguienteColor);
				salida.put(siguienteColor, String.valueOf(i));
				siguienteColor++;
			}
		}
		
		//System.out.println("Llego");
		return salida;
	}

}
