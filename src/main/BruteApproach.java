package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class BruteApproach {
	static //Mapa que contiene los resultados para cada ejecución con el nº de estaciones conectadas
	HashMap<String, Integer> resultadosFinales = new HashMap<>();
			
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
		int[] estacion1 = {2,4,5,1};
		listaEstaciones.add(estacion1);
		
		int[] estacion2 = {1,5,6,3,2};
		listaEstaciones.add(estacion2);
		
		int[] estacion3 = {2,6,7,3};
		listaEstaciones.add(estacion3);
		
		int[] estacion4 = {1,4,5,8,10,11};
		listaEstaciones.add(estacion4);
		
		int[] estacion5 = {1,2,4,5,6,8};
		listaEstaciones.add(estacion5);
		
		int[] estacion6 = {2,5,6,8,3,9,7};
		listaEstaciones.add(estacion6);
		
		int[] estacion7 = {3,6,7,9,13};
		listaEstaciones.add(estacion7);
		
		int[] estacion8 = {4,5,6,8,9,11,12};
		listaEstaciones.add(estacion8);
		
		int[] estacion9 = {6,8,7,9,12,13};
		listaEstaciones.add(estacion9);
		
		int[] estacion10 = {4,10,11,14};
		listaEstaciones.add(estacion10);
		
		int[] estacion11 = {4,8,10,11,12,14,15};
		listaEstaciones.add(estacion11);
		
		int[] estacion12 = {8,9,11,12,13,14,15,16};
		listaEstaciones.add(estacion12);
		
		int[] estacion13 = {7,9,12,13,15,16};
		listaEstaciones.add(estacion13);
		
		int[] estacion14 = {10,11,14,15};
		listaEstaciones.add(estacion14);

		int[] estacion15 = {11,12,13,14,15,16};
		listaEstaciones.add(estacion15);
		
		int[] estacion16 = {13,15,16};
		listaEstaciones.add(estacion16);
	}
	
	/**
	 * Opcion bruta de alcanzar el maximo
	 */
	public static void bruteApproach(){
		for(int i = 0 ; i < 10000000; i++){
			//Seleccionamos tres estaciones diferentes
			int estacionSeleccionadaN1 = new Random().nextInt(15);
			int estacionSeleccionadaN2 = new Random().nextInt(15);
			int estacionSeleccionadaN3 = new Random().nextInt(15);
			while(estacionSeleccionadaN2 == estacionSeleccionadaN1){
				estacionSeleccionadaN2 = new Random().nextInt(15);
			}
			while(estacionSeleccionadaN3 == estacionSeleccionadaN1 || estacionSeleccionadaN3 == estacionSeleccionadaN2){
				estacionSeleccionadaN3 = new Random().nextInt(15);
			}
			//System.out.println("Estaciones seleccionadas:" +(estacionN1+1) +"-"+(estacionN2+1)+"-"+(estacionN3+1));
			LinkedHashMap<Integer, Integer> estacionesCubiertas = new LinkedHashMap<>();
			//Para cada nodo cogemos sus conexiones
			for(int num : listaEstaciones.get(estacionSeleccionadaN1)){
				estacionesCubiertas.put(num, num);
			}
			for(int num : listaEstaciones.get(estacionSeleccionadaN2)){
				estacionesCubiertas.put(num, num);
			}
			for(int num : listaEstaciones.get(estacionSeleccionadaN3)){
				estacionesCubiertas.put(num, num);
			}
			resultadosFinales.put((estacionSeleccionadaN1+1) +"-"+(estacionSeleccionadaN2+1)+"-"+(estacionSeleccionadaN3+1), estacionesCubiertas.size());
		}
		Map.Entry<String, Integer> maxEntry = null;

		for (Map.Entry<String, Integer> entry : resultadosFinales.entrySet())
		{
			//Miramos si se consigue alcanzar el máximo global.
			if( entry.getValue() == 16){
				System.out.println("Solución óptima alcanzada con los valores "+entry.getKey());
			}
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		    }
		}
		System.out.println(maxEntry.getKey() + "-Resultado: "+maxEntry.getValue());
	}
}