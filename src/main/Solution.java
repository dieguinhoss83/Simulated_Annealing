package main;

import java.util.ArrayList;

public class Solution {
	public int numeroEstaciones;
	public ArrayList<Integer> estaciones;
	public String nodosCubiertos;
	public int numNodosCubiertos;
	
	public Solution(int numeroEstaciones, ArrayList<Integer> estaciones, int numNodosCubiertos, String nodosCubiertos){
		this.numeroEstaciones = numeroEstaciones;
		this.estaciones = estaciones;
		
		this.numNodosCubiertos = numNodosCubiertos;
		this.nodosCubiertos = nodosCubiertos;
	}
	public int getTamano() {
		return numeroEstaciones;
	}
	public String getEstaciones() {
		StringBuilder sbStr = new StringBuilder();
	    for (int i = 0, il = estaciones.size(); i < il; i++) {
	        if (i > 0)
	            sbStr.append(" - ");
	        
	        sbStr.append(estaciones.get(i) + 1);
	    }
	    return sbStr.toString();
	}
	public String getNodosCubiertos() {
		return nodosCubiertos;
	}
}
