package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class BruteApproach {
	
	public static void main(String[] args) {
		HashMap<String, Integer> resultadosFinales = new HashMap<>();
		ArrayList<int[]> nombre = new ArrayList<>();
		int[] estacion1 = {2,4,5,1};
		nombre.add(estacion1);
		
		int[] estacion2 = {1,5,6,3,2};
		nombre.add(estacion2);
		
		int[] estacion3 = {2,6,7,3};
		nombre.add(estacion3);
		
		int[] estacion4 = {1,4,5,8,10,11};
		nombre.add(estacion4);
		
		int[] estacion5 = {1,2,4,5,6,8};
		nombre.add(estacion5);
		
		int[] estacion6 = {2,5,6,8,3,9,7};
		nombre.add(estacion6);
		
		int[] estacion7 = {3,6,7,9,13};
		nombre.add(estacion7);
		
		int[] estacion8 = {4,5,6,8,9,11,12};
		nombre.add(estacion8);
		
		int[] estacion9 = {6,8,7,9,12,13};
		nombre.add(estacion9);
		
		int[] estacion10 = {4,10,11,14};
		nombre.add(estacion10);
		
		int[] estacion11 = {4,8,10,11,12,14,15};
		nombre.add(estacion11);
		
		int[] estacion12 = {8,9,11,12,13,14,15,16};
		nombre.add(estacion12);
		
		int[] estacion13 = {7,9,12,13,15,16};
		nombre.add(estacion13);
		
		int[] estacion14 = {10,11,14,15};
		nombre.add(estacion14);

		int[] estacion15 = {11,12,13,14,15,16};
		nombre.add(estacion15);
		
		int[] estacion16 = {13,15,16};
		nombre.add(estacion16);
		
		for(int i = 0 ; i < 10000000; i++){
			int estacionN1 = new Random().nextInt(15);
			int estacionN2 = new Random().nextInt(15);
			int estacionN3 = new Random().nextInt(15);
			while(estacionN2 == estacionN1){
				estacionN2 = new Random().nextInt(15);
			}
			while(estacionN3 == estacionN1 || estacionN3 == estacionN2){
				estacionN3 = new Random().nextInt(15);
			}
//			System.out.println("Estaciones seleccionadas:" +(estacionN1+1) +"-"+(estacionN2+1)+"-"+(estacionN3+1));
			LinkedHashMap<Integer, Integer> estacionesCubiertas = new LinkedHashMap<>();
			for(int num : nombre.get(estacionN1)){
				estacionesCubiertas.put(num, num);
			}
			for(int num : nombre.get(estacionN2)){
				estacionesCubiertas.put(num, num);
			
			}
			for(int num : nombre.get(estacionN3)){
				estacionesCubiertas.put(num, num);

			}
			resultadosFinales.put((estacionN1+1) +"-"+(estacionN2+1)+"-"+(estacionN3+1), estacionesCubiertas.size());
		}
		Map.Entry<String, Integer> maxEntry = null;

		for (Map.Entry<String, Integer> entry : resultadosFinales.entrySet())
		{
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
