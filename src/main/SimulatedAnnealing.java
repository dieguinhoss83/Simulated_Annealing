package main;

import java.util.ArrayList;
import java.util.Random;

public class SimulatedAnnealing {
	// 1 - Set initial temp
	
	//TODO hay que calcular T tal y como lo explicó Antonio en clase,
	//es decir, tal que la probabilidad inicial de aceptación de soluciones peores sea por ej 0.9
	public final double tInicial=162, tMin=1;
	public final int L=400, maxItEstables=500;
	public final double factorConv = 0.9;
	
	public double T=tInicial;
	public int iteracion=0;

	public int nEstacionesAnterior=0, itEstables=0;
	public Solution solucionFinal;
	
	public void execute() {
        Random random = new Random();
        
        // 2 - Escogemos una solución inicial x, 
        // perteneciente al conjunto de soluciones
        BruteApproach.addStations();
		Solution solucionInicial = BruteApproach.generateSolution(15, 1);
        
        // 3 - La configuramos como la mejor solución hasta el momento
		Solution mejorSolucion = solucionInicial;
		int tamannoNueva, tamannoMejor = mejorSolucion.numeroEstaciones;
        // Loop until stop criteria
        while (T>tMin && itEstables<maxItEstables) {
        	// 4 - implementar algoritmo recocido simulado
        	
        	// Create new solution y
        	boolean valida = false;
        	
        	Solution solucionNueva = BruteApproach.generateSolution(2, mejorSolucion.numeroEstaciones-1);
            
            // check if y best than x
            // Keep track of the best solution found
        	tamannoNueva = solucionNueva.numeroEstaciones;
    		
    		if(tamannoNueva<tamannoMejor)
    			mejorSolucion = solucionNueva;
    		else{
    			double probabilidad = Math.exp(-(tamannoNueva-tamannoMejor)/T);
    			double probabilidadIntento = random.nextDouble();
    			
    			if(probabilidadIntento < probabilidad)
    				mejorSolucion = solucionNueva;
    		}
			tamannoMejor = mejorSolucion.numeroEstaciones;
    		iteracion++;
    		
            // Update T (every L iterations, i.e. L=50)
        	// T = alfa*T (alfa=0.9)
    		if(iteracion%L == 0)
    			T = factorConv * T;
    		
    		if(nEstacionesAnterior==mejorSolucion.numeroEstaciones){
    			itEstables++;
    		}else{
    			itEstables=0;
    			nEstacionesAnterior = mejorSolucion.numeroEstaciones;
    		}
    		
    		
//       	System.out.println(iteracion+"\t"+itEstables+"\t"+T+"\t"+mejorSolucion.numeroEstaciones+"\t"+mejorSolucion.estaciones);
        }
        
        this.solucionFinal = mejorSolucion;
        
		System.out.println("Solución: "+mejorSolucion.estaciones);

        
	}// end of main
}