package main;

import java.util.ArrayList;

public class Solution {
	public int numeroEstaciones;
	public String nodosCubiertos;
	public ArrayList<Integer> nodosConEstacion;
	
	public Solution(int tamano,String nodosCubiertos,ArrayList<Integer> nodosConEstacion){
		this.numeroEstaciones = tamano;
		this.nodosCubiertos = nodosCubiertos;
		this.nodosConEstacion = nodosConEstacion;
	}
	public int getTamano() {
		return numeroEstaciones;
	}
	public String getNodosConEstacion() {
		StringBuilder sbStr = new StringBuilder();
	    for (int i = 0, il = nodosConEstacion.size(); i < il; i++) {
	        if (i > 0)
	            sbStr.append(" - ");
	        
	        sbStr.append(nodosConEstacion.get(i) + 1);
	    }
	    return sbStr.toString();
	}
	public String getNodosCubiertos() {
		return nodosCubiertos;
	}
}
