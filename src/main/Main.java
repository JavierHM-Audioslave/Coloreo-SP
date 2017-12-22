package main;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Grafo grafo;
		try
		{
			Scanner sc = new Scanner(new File("in2.txt"));
			grafo = new Grafo(sc.nextInt(),sc.nextInt());
			grafo.cargarGrafoNodirigido(sc);
			
			try
			{
				sc.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.exit(1);
			}
			
			Coloreo coloreo = new Coloreo(grafo);
			coloreo.colorear();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}
