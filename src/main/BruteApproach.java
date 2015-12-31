package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

import util.DistributionGenerator;
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
		
		//int[] estacion11 = {4,8,10,11,12,14,15}; => la 15 no es adyacente
		int[] estacion11 = {4,8,10,11,12,14};
		listaEstaciones.add(estacion11);
		
		//int[] estacion12 = {8,9,11,12,13,14,15,16}; => la 14 y 16 no son adyacentes
		int[] estacion12 = {8,9,11,12,13,15};
		listaEstaciones.add(estacion12);
		
		int[] estacion13 = {7,9,12,13,15,16};
		listaEstaciones.add(estacion13);
		
		int[] estacion14 = {10,11,14,15};
		listaEstaciones.add(estacion14);

		//int[] estacion15 = {11,12,13,14,15,16}; => la 11 no es adyacente
		int[] estacion15 = {12,13,14,15,16};
		listaEstaciones.add(estacion15);
		
		int[] estacion16 = {13,15,16};
		listaEstaciones.add(estacion16);
	}
	
	/**
	 * Calcula la probabilidad de aceptacion
	 * 
	 * @param f_xi => numero de estaciones de la solucion xi
	 * @param f_y => numero de estaciones de la solucion y
	 * @param temperatura
	 * @return
	 */
	public static double calcular_probabilidad_aceptacion(int f_xi, int f_y, double temperatura) {
        return Math.exp(-(f_y - f_xi) / temperatura);
    }
	
	/**
	 * Metodo que genera una posible solucion inicial, la cual es una lista de estaciones.
	 * @param numeroEstaciones
	 * @return
	 */
	public static ArrayList<Integer> generateInitialSolution(){
		//Numero de estaciones con las que cubriremos el problema [1,16]
		int numeroDeEstacion = new Random().nextInt(15) + 1;
		
		int[] estaciones = new Random().ints(0,15).distinct().limit(numeroDeEstacion).toArray();
		ArrayList<Integer> posibleSolucion = new ArrayList<>();

	    for (int index = 0; index < estaciones.length; index++)
	    {
	    	posibleSolucion.add(estaciones[index]);
	    }
	    
		return posibleSolucion; 
	}
	
	/**
	 * Metodo que genera una posible solucion, la cual es una lista de estaciones.
	 * @param numeroEstaciones
	 * @return
	 */
	public static ArrayList<Integer> generateSolution(int numeroEstaciones){
		int[] estaciones = new Random().ints(0,15).distinct().limit(numeroEstaciones).toArray();
		ArrayList<Integer> posibleSolucion = new ArrayList<>();

	    for (int index = 0; index < estaciones.length; index++)
	    {
	    	posibleSolucion.add(estaciones[index]);
	    }
	    
		return posibleSolucion; 
	}
	
	/**
	 * Opcion bruta de alcanzar el maximo
	 */
	public static void bruteApproach(){
		ArrayList<Integer> posible_sol_y = null;
		HashSet<Integer> nodosCubiertos = null;
		
		// Mejor solucion de las visitadas hasta el momento
		ArrayList<Integer> mejor_sol = null;
		
		// Valor de la f(xi) => numero de estaciones de la solucion xi
		int f_xi = 0;
		// Valor de la f(y) => numero de estaciones de la solucion y
		int f_y = 0;
		// Valor de la f(x_mejor) => numero de estaciones de la mejor solucion solucion
		int f_mejor_sol = 0;
		
		
		//TODO hay que calcular T tal y como lo explicó Antonio en clase,
		//es decir, tal que la probabilidad inicial de aceptación de soluciones peores sea por ej 0.9
        double temperatura = 10000; // para las pruebas iniciales vale este valor
        
        // 2 - Escogemos una solución inicial x, 
        // perteneciente al conjunto de soluciones
        ArrayList<Integer> posible_sol_xi = generateInitialSolution();
        
        // 3 - La configuramos como la mejor solución hasta el momento
        mejor_sol = posible_sol_xi;
        f_mejor_sol=mejor_sol.size();
        
        // xi --> solucion actual
 		// y  --> nueva solucion
 		// p_i --> probabilidad de aceptacion
 		// u  --> valor de la uniforme
 		double p_i = 1.0;
 		double u = 0.0;
				
 		int numeroDePruebas = 1000000;
 		
 		//TODO cambiar for por while(!hemosConvergido)
		for(int i = 0 ; i < numeroDePruebas; i++){
			nodosCubiertos = new HashSet<>();

			// 4 - Generamos aleatoriamente una nueva solucion
			//Numero de estaciones con las que cubriremos el problema
			// Lo calculamos con el valor de una uniforme(1,16)
			int numeroDeEstacion = new Random().nextInt(15) + 1;
						
			// Creamos aleatoriamente una nueva solucion y
			posible_sol_y = generateSolution(numeroDeEstacion);
			
			//Para cada nodo cogemos sus conexiones
			for (int j = 0 ; j < posible_sol_y.size(); j++)
			{
				for(int num : listaEstaciones.get(posible_sol_y.get(j))){
					nodosCubiertos.add(num);
				}
			}
			Collections.sort(posible_sol_y);
			
			// 5 - Comprobamos si sol_y es mejor a sol_xi
			// xi --> solucion actual
     		// y  --> nueva solucion
     		// pi --> probabilidad de aceptacion
     		// u  --> valor de la uniforme
			if(f_y < f_xi){
				posible_sol_xi = posible_sol_y;
				
				// si f_y es mejor que cualquiera de las anteriores,
				// actualizamos la mejor solucion encontrada
				if(f_y < f_mejor_sol){
					mejor_sol = posible_sol_y;
					f_mejor_sol=mejor_sol.size();
				}
			}else{
				// generamos un valor de la uniforme
				u = DistributionGenerator.uniform();
				
				// calculamos la probabilidad de aceptacion de la nueva solucion
				p_i = calcular_probabilidad_aceptacion(f_xi, f_y, temperatura);
				
				if(p_i > u){// si pi > u --> hacemos sol_actual = y
					posible_sol_xi = posible_sol_y;
				}
				
			}
     		     		
			//Posible solucion contiene las estaciones.
			resultadosFinales.put(new Solution(numeroDeEstacion, nodosCubiertos.toString(),posible_sol_y), nodosCubiertos.size());
            
            
        	            
            // TODO Update T (every L iterations, i.e. L=50)
        	// T = alfa*T (alfa=0.9)		
		}
		int numeroEstacionesMinimo = 16;
		ArrayList<ArrayList<Integer>> soluciones_encontradas = new ArrayList<>();

		for (Map.Entry<Solution, Integer> solucion : resultadosFinales.entrySet())
		{
			//Miramos si se consigue alcanzar el máximo global.
			if( solucion.getValue() == 16){
				//Syso para revisar el numero de estaciones que tiene la solucion valida que acaba de ser insertada
				//System.out.println(entry.getKey().getTamano());
				if (solucion.getKey().getTamano() < numeroEstacionesMinimo)
			    {
					numeroEstacionesMinimo = solucion.getKey().getTamano();
			    }
			}
		}
		
		//Obtenemos todas las posibles soluciones con el minimo numero de estaciones ( variable numeroEstacionesMinimo)
		for (Map.Entry<Solution, Integer> solucion : resultadosFinales.entrySet())
		{
			if(solucion.getKey().getTamano() == numeroEstacionesMinimo && solucion.getValue() == 16 
					&& !soluciones_encontradas.contains(solucion.getKey().nodosConEstacion)){
				soluciones_encontradas.add(solucion.getKey().nodosConEstacion);
				System.out.println("----------------------------\nTamaño de solucion: " + solucion.getKey().getTamano() + "\nNodos con estacion: "+solucion.getKey().getNodosConEstacion() + "\nNodos cubiertos: "+solucion.getKey().getNodosCubiertos());
			}
		}
		System.out.println("\n Soluciones Encontradas = " +soluciones_encontradas.size());
	}
}