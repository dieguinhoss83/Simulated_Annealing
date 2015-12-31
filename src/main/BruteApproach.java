package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import util.DistributionGenerator;
/**
 * Clase que la seleccion que permite que todos los nodos sean cubiertos por el minimo numero de estaciones de incendio.
 * @author javier
 *
 */
public class BruteApproach {
	static //Mapa que contiene los resultados para cada ejecuci�n con el n� de estaciones conectadas
	HashMap<Solution, Integer> resultadosFinales = new HashMap<>();
			
	static //Arraylist con todas las estaciones
	ArrayList<int[]> listaEstaciones = new ArrayList<>();
	
	public static void main(String[] args) {
		addStations();
		bruteApproach();
	}
	/**
	 * Metodo que a�ade las conexiones entre los nodos.
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
	 * Comprueba que la soluci�n da servicio a los 16 distritos
	 * 
	 * @param posible_sol_y_object
	 * @return
	 */
	public static boolean sol_y_es_valida(Solution posible_sol_y_object){
		
		//Miramos si se consigue alcanzar el m�ximo global.
		if(posible_sol_y_object.nodosCubiertos.size() == 16)
			return true;
		else
			return false;
	}
	
	/**
	 * Devuelve los distritos cubiertos por esa solucion
	 * 
	 * @param posible_sol
	 * @return
	 */
	public static HashSet<Integer> obtener_distritos_cubiertos(ArrayList<Integer> posible_sol){
		HashSet<Integer> nodosCubiertos = new HashSet<>();
		
		for (int j = 0 ; j < posible_sol.size(); j++)
		{
			for(int num : listaEstaciones.get(posible_sol.get(j))){
				nodosCubiertos.add(num);
			}
		}
		
		return nodosCubiertos;
	}
	
	/**
	 * Opcion bruta de alcanzar el maximo
	 */
	public static void bruteApproach(){
		
		double ALFA = 0.999; //tasa de enfriamiento
		
		ArrayList<Integer> posible_sol_y = null;
		Solution posible_sol_y_object = null;
		
		HashSet<Integer> nodosCubiertos = new HashSet<>();
		
		// Mejor solucion de las visitadas hasta el momento
		ArrayList<Integer> mejor_sol = null;
		Solution mejor_sol_object = null;
		
		// Valor de la f(xi) => numero de estaciones de la solucion xi
		int f_xi = 16;
		// Valor de la f(y) => numero de estaciones de la solucion y
		int f_y = 0;
		// Valor de la f(x_mejor) => numero de estaciones de la mejor solucion solucion
		int f_mejor_sol = 0;
		
		
		//TODO hay que calcular T tal y como lo explic� Antonio en clase,
		//es decir, tal que la probabilidad inicial de aceptaci�n de soluciones peores sea por ej 0.9
        double temperatura = 5000; // para las pruebas iniciales vale este valor
        
        // 2 - Escogemos una soluci�n inicial x, 
        // perteneciente al conjunto de soluciones
        ArrayList<Integer> posible_sol_xi = generateInitialSolution();
        
        // 3 - La configuramos como la mejor soluci�n hasta el momento
        mejor_sol = posible_sol_xi;
        f_mejor_sol=mejor_sol.size();
        
        mejor_sol_object = new Solution(f_mejor_sol, obtener_distritos_cubiertos(mejor_sol) ,mejor_sol);
        
        // xi --> solucion actual
 		// y  --> nueva solucion
 		// p_i --> probabilidad de aceptacion
 		// u  --> valor de la uniforme
 		double p_i = 1.0;
 		double u = 0.0;
				
 		int contador = 0;
 		
 		//TODO cambiar for por while(!hemosConvergido)
		while(temperatura > 1){
			contador++;
			nodosCubiertos = new HashSet<>();

			// 4 - Generamos aleatoriamente una nueva solucion
			//Numero de estaciones con las que cubriremos el problema
			// Lo calculamos con el valor de una uniforme(1,16)
			int numeroDeEstacion = new Random().nextInt(15) + 1;
						
			// Creamos aleatoriamente una nueva solucion y
			posible_sol_y = generateSolution(numeroDeEstacion);
			f_y = posible_sol_y.size();
			
			//Calculamos los nodos cubiertos por la posible solucion
			nodosCubiertos = obtener_distritos_cubiertos(posible_sol_y);
			Collections.sort(posible_sol_y);
			
			posible_sol_y_object = new Solution(f_y, nodosCubiertos ,posible_sol_y);
			
			// 5 - Comprobamos si sol_y es mejor a sol_xi
			// xi --> solucion actual
     		// y  --> nueva solucion
     		// pi --> probabilidad de aceptacion
     		// u  --> valor de la uniforme
			if(sol_y_es_valida(posible_sol_y_object)){
				if(f_y < f_xi){
					posible_sol_xi = posible_sol_y;
					f_xi = posible_sol_xi.size();
					
					// si f_y es mejor que cualquiera de las anteriores,
					// actualizamos la mejor solucion encontrada
					if(f_y < f_mejor_sol){
						mejor_sol = posible_sol_y;
						f_mejor_sol=mejor_sol.size();
						
						mejor_sol_object = posible_sol_y_object;
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
			}
     		     		
            // TODO method to Update T (only every L iterations, i.e. L=50)
        	temperatura *= ALFA;	
		}
		if(mejor_sol_object.nodosCubiertos.size() < 16){
			System.out.println("\n NO SE HA ENCONTRADO UNA SOLUCI�N �PTIMA\n");
		}
		else{
			System.out.println("\n SOLUCI�N �PTIMA ENCONTRADA\n");
		}
		System.out.println("\n Mejor Solucion Encontrada en "+contador+" iteraciones = " +mejor_sol_object.getNodosConEstacion());
		System.out.println("\n Nodos cubiertos = " +mejor_sol_object.nodosCubiertos.toString());
		System.out.println("\n N�mero de Distritos cubiertos = " +mejor_sol_object.nodosCubiertos.size());
	}
}