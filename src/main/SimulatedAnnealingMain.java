package main;

import java.util.ArrayList;

public class SimulatedAnnealingMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create our possible Fireman Stations
		
		// List of districts served by a station in district 01
		ArrayList<Integer> districtsServed_by_01 = new ArrayList<Integer>();
		districtsServed_by_01.add(1);
		districtsServed_by_01.add(2);
		districtsServed_by_01.add(4);
		districtsServed_by_01.add(5);
		// Fireman Station in district 01 and its districts served
		FiremanStation fireman_station_01 = new FiremanStation(districtsServed_by_01);
		
		// List of districts served by a station in district 02
		ArrayList<Integer> districtsServed_by_02 = new ArrayList<Integer>();
		districtsServed_by_02.add(1);
		districtsServed_by_02.add(2);
		districtsServed_by_02.add(3);
		districtsServed_by_02.add(5);
		districtsServed_by_02.add(6);
		// Fireman Station in district 02 and its districts served
		FiremanStation fireman_station_02 = new FiremanStation(districtsServed_by_02);
		
		// List of districts served by a station in district 03
		ArrayList<Integer> districtsServed_by_03 = new ArrayList<Integer>();
		districtsServed_by_03.add(2);
		districtsServed_by_03.add(3);
		districtsServed_by_03.add(6);
		districtsServed_by_03.add(7);
		// Fireman Station in district 03 and its districts served
		FiremanStation fireman_station_03 = new FiremanStation(districtsServed_by_03);
		
		// List of districts served by a station in district 04
		ArrayList<Integer> districtsServed_by_04 = new ArrayList<Integer>();
		districtsServed_by_04.add(1);
		districtsServed_by_04.add(4);
		districtsServed_by_04.add(5);
		districtsServed_by_04.add(8);
		districtsServed_by_04.add(10);
		districtsServed_by_04.add(11);
		// Fireman Station in district 04 and its districts served
		FiremanStation fireman_station_04 = new FiremanStation(districtsServed_by_04);
		
		// List of districts served by a station in district 05
		ArrayList<Integer> districtsServed_by_05 = new ArrayList<Integer>();
		districtsServed_by_05.add(1);
		districtsServed_by_05.add(2);
		districtsServed_by_05.add(4);
		districtsServed_by_05.add(5);
		districtsServed_by_05.add(6);
		districtsServed_by_05.add(8);
		// Fireman Station in district 05 and its districts served
		FiremanStation fireman_station_05 = new FiremanStation(districtsServed_by_05);
		
		// List of districts served by a station in district 06
		ArrayList<Integer> districtsServed_by_06 = new ArrayList<Integer>();
		districtsServed_by_06.add(2);
		districtsServed_by_06.add(3);
		districtsServed_by_06.add(5);
		districtsServed_by_06.add(6);
		districtsServed_by_06.add(7);
		districtsServed_by_06.add(8);
		districtsServed_by_06.add(9);
		// Fireman Station in district 06 and its districts served
		FiremanStation fireman_station_06 = new FiremanStation(districtsServed_by_06);
		
		// List of districts served by a station in district 07
		ArrayList<Integer> districtsServed_by_07 = new ArrayList<Integer>();
		districtsServed_by_07.add(3);
		districtsServed_by_07.add(6);
		districtsServed_by_07.add(7);
		districtsServed_by_07.add(9);
		districtsServed_by_07.add(13);
		// Fireman Station in district 07 and its districts served
		FiremanStation fireman_station_07 = new FiremanStation(districtsServed_by_07);
		
		// List of districts served by a station in district 08
		ArrayList<Integer> districtsServed_by_08 = new ArrayList<Integer>();
		districtsServed_by_08.add(4);
		districtsServed_by_08.add(5);
		districtsServed_by_08.add(6);
		districtsServed_by_08.add(8);
		districtsServed_by_08.add(9);
		districtsServed_by_08.add(11);
		districtsServed_by_08.add(12);
		// Fireman Station in district 08 and its districts served
		FiremanStation fireman_station_08 = new FiremanStation(districtsServed_by_08);
		
		// List of districts served by a station in district 09
		ArrayList<Integer> districtsServed_by_09 = new ArrayList<Integer>();
		districtsServed_by_09.add(6);
		districtsServed_by_09.add(7);
		districtsServed_by_09.add(8);
		districtsServed_by_09.add(9);
		districtsServed_by_09.add(12);
		districtsServed_by_09.add(13);
		// Fireman Station in district 09 and its districts served
		FiremanStation fireman_station_09 = new FiremanStation(districtsServed_by_09);
				
		// List of districts served by a station in district 10
		ArrayList<Integer> districtsServed_by_10 = new ArrayList<Integer>();
		districtsServed_by_10.add(4);
		districtsServed_by_10.add(11);
		districtsServed_by_10.add(14);
		// Fireman Station in district 10 and its districts served
		FiremanStation fireman_station_10 = new FiremanStation(districtsServed_by_10);
		
		// List of districts served by a station in district 11
		ArrayList<Integer> districtsServed_by_11 = new ArrayList<Integer>();
		districtsServed_by_11.add(4);
		districtsServed_by_11.add(8);
		districtsServed_by_11.add(10);
		districtsServed_by_11.add(11);
		districtsServed_by_11.add(12);
		districtsServed_by_11.add(14);
		// Fireman Station in district 11 and its districts served
		FiremanStation fireman_station_11 = new FiremanStation(districtsServed_by_11);
		
		// List of districts served by a station in district 12
		ArrayList<Integer> districtsServed_by_12 = new ArrayList<Integer>();
		districtsServed_by_12.add(8);
		districtsServed_by_12.add(9);
		districtsServed_by_12.add(11);
		districtsServed_by_12.add(12);
		districtsServed_by_12.add(13);
		districtsServed_by_12.add(15);
		// Fireman Station in district 12 and its districts served
		FiremanStation fireman_station_12 = new FiremanStation(districtsServed_by_12);
		
		// List of districts served by a station in district 13
		ArrayList<Integer> districtsServed_by_13 = new ArrayList<Integer>();
		districtsServed_by_13.add(7);
		districtsServed_by_13.add(9);
		districtsServed_by_13.add(12);
		districtsServed_by_13.add(13);
		districtsServed_by_13.add(15);
		districtsServed_by_13.add(16);
		// Fireman Station in district 13 and its districts served
		FiremanStation fireman_station_13 = new FiremanStation(districtsServed_by_13);
		
		// List of districts served by a station in district 14
		ArrayList<Integer> districtsServed_by_14 = new ArrayList<Integer>();
		districtsServed_by_14.add(10);
		districtsServed_by_14.add(11);
		districtsServed_by_14.add(14);
		districtsServed_by_14.add(15);
		// Fireman Station in district 14 and its districts served
		FiremanStation fireman_station_14 = new FiremanStation(districtsServed_by_14);
		
		// List of districts served by a station in district 15
		ArrayList<Integer> districtsServed_by_15 = new ArrayList<Integer>();
		districtsServed_by_15.add(12);
		districtsServed_by_15.add(13);
		districtsServed_by_15.add(15);
		districtsServed_by_15.add(16);
		// Fireman Station in district 15 and its districts served
		FiremanStation fireman_station_15 = new FiremanStation(districtsServed_by_15);
		
		// List of districts served by a station in district 16
		ArrayList<Integer> districtsServed_by_16 = new ArrayList<Integer>();
		districtsServed_by_16.add(13);
		districtsServed_by_16.add(15);
		districtsServed_by_16.add(16);
		// Fireman Station in district 16 and its districts served
		FiremanStation fireman_station_16 = new FiremanStation(districtsServed_by_16);
		
		// 1 - Set initial temp
		
		//TODO hay que calcular T tal y como lo explicó Antonio en clase,
		//es decir, tal que la probabilidad inicial de aceptación de soluciones peores sea por ej 0.9
        double temp = 10000; // para las pruebas iniciales vale este valor

        // 2 - Escogemos una solución inicial x, 
        // perteneciente al conjunto de soluciones
        
        // 3 - La configuramos como la mejor solución hasta el momento
        
        // Loop until stop criteria
        while (condition) {
        	// 4 - implementar algoritmo recocido simulado
        	
        	// Create new solution y
            
            // check if y best than x

            // Keep track of the best solution found
            
            // Update T (every L iterations, ie L=50)
        	// T = alfa*T (alfa=0.9)
		
	}// end of main
}
