import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class TextReader {
	private FileReader arq;
	private BufferedReader lertxt;
	
	public TextReader(String end){
		try{
			//abre o arquivo para leitura
			this.arq = new FileReader(new File(end).getAbsolutePath()); 
			this.lertxt = new BufferedReader(arq);
		}catch(IOException e){
			System.out.println("Erro ao ler o arquivo:"+ e.getMessage());
		}
	}
	
	public String ler_por_linha(int qtd_lin){
		String linha = null;
		try{
			linha = lertxt.readLine(); //le primeira linha
			String lin_aux = linha;
			int i = 1;
			while (lin_aux != null && i < qtd_lin){ //le as demais linhas
				lin_aux = lertxt.readLine();
				linha += ("\n" + lin_aux);
				i++;
			}
		} catch(IOException e){
			System.out.println("Erro na abertura do arquivo:"+ e.getMessage());
		}
		return linha;
	}
	
	public int[] ler_numeros_de_linha(){
		int[] palavras = null;
		try{
			String linha = lertxt.readLine(); //le primeira linha
			if (linha == null) return null;
			String[] aux = linha.split(Pattern.quote(" "));
			int[] palav_aux = new int[aux.length];
			for(int i = 0; i < aux.length; i++){
				palav_aux[i] = Integer.parseInt(aux[i]);
			}
			palavras = palav_aux;
		} catch(IOException e){
			System.out.println("Erro na abertura do arquivo:"+ e.getMessage());
		}
		return palavras;
	}
	
	public String ler_tudo(){
		String linha = null;
		try{
			linha = lertxt.readLine(); // le primeira linha
			String lin_aux = linha;
			while (lin_aux != null){ // le as demais linhas
				lin_aux = lertxt.readLine(); 
				linha += ("\n" + lin_aux);
			}
		} catch(IOException e){
			System.out.println("Erro na abertura do arquivo:"+ e.getMessage());
		}
		return linha;
	}
	
	//fecha o leitor
	public void fecha_leitor(){
		try{
			arq.close();
		}catch(IOException e){
			System.out.println("Erro ao fechar o arquivo:"+ e.getMessage());
		}
	}
}
