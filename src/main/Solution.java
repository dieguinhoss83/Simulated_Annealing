package main;

public class Solution {
	public int numeroEstaciones;
	public String nodosConEstacion;
	public String nodosCubiertos;
	
	public Solution(int tamano,String nodosCubiertos,String nodosConEstacion){
		this.numeroEstaciones = tamano;
		this.nodosCubiertos = nodosCubiertos;
		this.nodosConEstacion = nodosConEstacion;
	}
	public int getTamano() {
		return numeroEstaciones;
	}
	public String getNodosCubiertos() {
		return nodosCubiertos;
	}
	public String getNodosConEstacion() {
		return nodosConEstacion;
	}
}
