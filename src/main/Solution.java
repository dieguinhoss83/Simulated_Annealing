package main;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
	public int numeroEstaciones;
	public HashSet<Integer> nodosCubiertos;
	public ArrayList<Integer> nodosConEstacion;
	
	public Solution(int tamano, HashSet<Integer> nodosCubiertos,ArrayList<Integer> nodosConEstacion){
		this.numeroEstaciones = tamano;
		this.nodosCubiertos = nodosCubiertos;
		this.nodosConEstacion = nodosConEstacion;
	}
	public int getTamano() {
		return numeroEstaciones;
	}
	public String getNodosConEstacion() {
		StringBuilder sbStr = new StringBuilder("[");
	    for (int i = 0, il = nodosConEstacion.size(); i < il; i++) {
	        if (i > 0)
	            sbStr.append(" - ");
	        
	        sbStr.append(nodosConEstacion.get(i) + 1);
	    }
	    sbStr.append("]");
	    return sbStr.toString();
	}
}
