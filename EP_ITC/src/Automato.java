

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
		
		removeEstadoInacessivel();
		
		removeEstadoInutil();
		
		for(int i = 0; i < delta.length; i++){
			for(int j = 0; j < delta[i].length; j++){
				System.out.print(delta[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	private void removeEstadoInutil(){
		//Define os estados de aceitacao como uteis
		for(int i = 0; i < estados.length; i++){
			if(estados[i].aceitacao()){
				estados[i].setUtil(true);
			}
		}
		
		//Encontra todos os estados uteis
		for(int i = 0; i < estados.length; i++){
			if(estados[i].isUtil() && !estados[i].isFinalizado()){
				for(int l = 0; l < delta.length; l++){
					for(int c = 0; c < delta[c].length; c++){
						if(delta[l][c] == i){
							estados[l].setUtil(true);
							break;
						}
					}
				}
				estados[i].setFinalizado(true);
				i = 0;
			}
		}
		
		int[] inuteis = new int[estados.length];
		int cont = 0;
		
		//Conta os estados inuteis
		for(int i = 0; i < estados.length; i++){
			if(!estados[i].isUtil()){
				inuteis[cont] = i;
				cont++;
			}
		}
		
		removeEstados(cont, inuteis);
	}
	
	private void removeEstadoInacessivel(){
		int est = 0;
		boolean achei = false;
		
		//Determina estados inacessiveis
		while(est < estados.length){
			if(estados[est].inicial()){
				estados[est].setAcessivel(true);
				est++;
				continue;
			}
			
			for(int i = 0; i < delta.length; i ++){
				achei = false;
				//verifica se é o estado que eu estou verificando
				if(i == est){
					continue;
				}
				
				//percorre as colunas procurando alguém que faça referencia ao estado
				//se alguem faz referencia, ele é acessivel, podemos partir para o proximo estado
				for(int j = 0; j<delta[i].length; j++){
					if(delta[i][j] == est){
						estados[est].setAcessivel(true);
						achei = true;
						break;
					}
				}
				//se nenhuma coluna dessa linha faz referencia, parte para a proxima linha
				if(achei) break;
			}
			est++;
		}
		
		int[] inac = new int[delta.length];
		int cont = 0;
		
		//preenche um array com o numero dos estados inacessiveis
		for(int n = 0; n < estados.length; n++){
			if(!estados[n].acessivel()){
				inac[cont] = n;
				cont++;
 			}
		}
		
		removeEstados(cont, inac);		
	}
	
	public void removeEstados(int cont, int[] est){
		int[][] newDelta = new int[delta.length - cont][delta[0].length];
		Estado[] newEstados = new Estado[estados.length - cont];
		int cont2 = 0;
		boolean achei = false;
		
		//cria uma nova tabela e um novo array de estados somente com estados que devem ficar
		for(int i=0; i < delta.length; i++){
			achei = false;
			for(int n=0; n<cont; n++){
				if(i == est[n]){
					achei = true;
					break;
				}
			}
			if(achei) continue;
			
			for(int j = 0; j < delta[i].length; j++){
				newDelta[cont2][j] = delta[i][j];
				newEstados[cont2] = estados[i];
			}
			cont2++;
		}
		
		delta = newDelta;
		estados = newEstados;
	}
	
}
