public class d8515972 {
	public static void main (String[] args){
		//Abre leitura de arquivo
		TextReader leitura = new TextReader("src\\teste1.txt");
		
		//Ler os numeros presentes na linha e guarda no arranjo
		int[] dados = leitura.ler_numeros_de_linha();
		
		//cria um automato
		Automato a1 = new Automato();
		
		//cria os estados do automato
		a1.insereEstados(dados[0]);
		
		//insere o estado inicial
		a1.insereEstadoInicial(dados[2]);
		
		//cria a tabela de caminhos
		a1.criaTabelaDelta(dados[1]);
		
		//le a segunda linha do arquivo
		int[] aceitacao = leitura.ler_numeros_de_linha();
		
		//insere os estados de aceitacao
		for(int i=0; i < aceitacao.length; i++){
			if (aceitacao[i] == 1) a1.insereEstadoAceitacao(i);
		}
		
		//le a terceira linha do arquivo
		int[] tabela = leitura.ler_numeros_de_linha();
		int cont = 0;
		
		//cria a tabela de caminhos
		while (tabela != null){
			for(int i = 0; i<tabela.length; i++){
				a1.insereNaTabela(cont, i, tabela[i]);
			}
			tabela = leitura.ler_numeros_de_linha();
			cont++;
		}
		
		//minimiza o automato
		a1.minimizaAutomato();
		
		//fecha o leitor
		leitura.fecha_leitor();
	}
}
