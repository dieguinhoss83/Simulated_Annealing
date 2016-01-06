package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

/**
 * Clase que la seleccion que permite que todos los nodos sean cubiertos por el minimo numero de estaciones de incendio.
 * @author javier
 *
 */
public class BruteApproach {
	static //Mapa que contiene los resultados para cada ejecución con el nº de estaciones conectadas
	HashMap<Solution, Integer> resultadosFinales = new HashMap<>();
			
	static //Arraylist con todas las estaciones
	ArrayList<int[]> listaEstaciones = new ArrayList<>();
	
	public static void main(String[] args) {
		addStations();
		bruteApproach();
	}
	/**
	 * Metodo que añade las conexiones entre los nodos.
	 */
	public static void addStations(){
		//Declaracion de las conexiones de cada estacion
		int[] estacion1 = {1,2,4,5};
		listaEstaciones.add(estacion1);
		
		int[] estacion2 = {1,2,3,5,6};
		listaEstaciones.add(estacion2);
		
		int[] estacion3 = {2,3,6,7};
		listaEstaciones.add(estacion3);
		
		int[] estacion4 = {1,4,5,8,10,11};
		listaEstaciones.add(estacion4);
		
		int[] estacion5 = {1,2,4,5,6,8};
		listaEstaciones.add(estacion5);
		
		int[] estacion6 = {2,3,5,6,7,8,9};
		listaEstaciones.add(estacion6);
		
		int[] estacion7 = {3,6,7,9,13};
		listaEstaciones.add(estacion7);
		
		int[] estacion8 = {4,5,6,8,9,11,12};
		listaEstaciones.add(estacion8);
		
		int[] estacion9 = {6,7,8,9,12,13};
		listaEstaciones.add(estacion9);
		
		int[] estacion10 = {4,10,11,14};
		listaEstaciones.add(estacion10);
		
		int[] estacion11 = {4,8,10,11,12,14};
		listaEstaciones.add(estacion11);
		
		int[] estacion12 = {8,9,11,12,13,15};
		listaEstaciones.add(estacion12);
		
		int[] estacion13 = {7,9,12,13,15,16};
		listaEstaciones.add(estacion13);
		
		int[] estacion14 = {10,11,14,15};
		listaEstaciones.add(estacion14);

		int[] estacion15 = {12,13,14,15,16};
		listaEstaciones.add(estacion15);
		
		int[] estacion16 = {13,15,16};
		listaEstaciones.add(estacion16);
	}
	
	/**
	 * Metodo que genera una posible solucion, la cual es una lista de estaciones.
	 * @param numeroEstaciones
	 * @return
	 */
	public static ArrayList<Integer> generateStationList(int numeroEstaciones){
		int[] estaciones = new Random().ints(1,16).distinct().limit(numeroEstaciones).toArray();
		ArrayList<Integer> posibleSolucion = new ArrayList<>();

	    for (int index = 0; index < estaciones.length; index++)
	    {
	    	posibleSolucion.add(estaciones[index]);
	    }
	    
		return posibleSolucion; 
	}
	
	public static Solution generateSolution(int amp, int min){
		boolean valida = false;
		Solution solucion = null;
		do{
		//Numero de estaciones con las que cubriremos el problema
		//int numEstaciones = new Random().nextInt(15) + 1;
		int numEstaciones = new Random().nextInt(amp) + min;
		ArrayList<Integer> posibleSolucion = generateStationList(numEstaciones);
		
		HashSet<Integer> nodosCubiertos = new HashSet<>();
		//Para cada nodo cogemos sus conexiones
		
		for (int j = 0 ; j < posibleSolucion.size(); j++)
		{
			int numEstacion = posibleSolucion.get(j)-1;
			for(int num : listaEstaciones.get(numEstacion)){
				nodosCubiertos.add(num);
			}
		}
		Collections.sort(posibleSolucion);
		solucion = new Solution(numEstaciones, posibleSolucion, nodosCubiertos.size(), nodosCubiertos.toString());
		
		valida = (nodosCubiertos.size() == 16);
		}while(!valida);

		
		return solucion;
	}
	
	/**
	 * Opcion bruta de alcanzar el maximo
	 */
	public static void bruteApproach(){
		Solution posibleSolucion = null;
		HashSet<Integer> nodosCubiertos = null;
		int numeroDePruebas = 1000000;
		for(int i = 0 ; i < numeroDePruebas; i++){
			posibleSolucion = generateSolution(15, 1);
			resultadosFinales.put(posibleSolucion, posibleSolucion.numNodosCubiertos);
		}
		int numeroEstacionesMinimo = 16;

		for (Map.Entry<Solution, Integer> entry : resultadosFinales.entrySet())
		{
			//Miramos si se consigue alcanzar el máximo global.
			if( entry.getValue() == 16){
				//Syso para revisar el numero de estaciones que tiene la solucion valida que acaba de ser insertada
				//System.out.println(entry.getKey().getTamano());
				if (entry.getKey().getTamano() < numeroEstacionesMinimo)
			    {
					numeroEstacionesMinimo = entry.getKey().getTamano();
			    }
			}
		}
		//Obtenemos todas las posibles soluciones con el minimo numero de estaciones ( variable numeroEstacionesMinimo)
		for (Map.Entry<Solution, Integer> entry : resultadosFinales.entrySet())
		{
			if(entry.getKey().getTamano() == numeroEstacionesMinimo && entry.getValue() == 16){
				System.out.println("----------------------------\nTamaño de solucion: " + entry.getKey().getTamano() + "\nNodos con estacion: "+entry.getKey().getEstaciones() + "\nNodos cubiertos: "+entry.getKey().getNodosCubiertos());
			}
		}
	}
}