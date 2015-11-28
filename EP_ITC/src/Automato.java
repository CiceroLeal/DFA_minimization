

public class Automato {
	private Estado[] estados;
	private int[][] delta;
	private int estadoInicial = -1;
	
	public void insereEstados(int q){
		estados = new Estado[q];
		
		for(int i=0; i<q; i++){
			estados[i] = new Estado();
		}	
	}
	
	public void insereEstadoInicial(int n){
		estados[n].setInicial(true);
		estadoInicial = n;
	}
	
	public int consultaEstadoInicial(){
		return estadoInicial;
	}
	
	public int[] consultaEstadosAceitacao(){
		int[] aceitacao = new int[estados.length];
		int j = 0;
		for(int i = 0; i<estados.length; i++){
			if (estados[i].aceitacao()){
				aceitacao[j] = i;
				j++;
			}
		}
		if(j==0) return null;
		return aceitacao;
	}
	
	public void insereEstadoAceitacao(int n){
		estados[n].setAceitacao(true);
	}
	
	public void criaTabelaDelta(int s){
		delta = new int[estados.length][s];
	}
	
	public void insereNaTabela(int i, int j, int v){
		delta[i][j] = v;
	}
	
	public void minimizaAutomato(){
		for(int i = 0; i <estados.length; i++){
			if(estados[i].aceitacao() || estados[i].inicial())
			System.out.println(i);
		}
	}
}
