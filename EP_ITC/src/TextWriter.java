import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TextWriter {
	
	//Escreve no final do arquivo
	public void escrever_arq_fim(String texto, String end_arq){
		try{
			FileWriter arq = new FileWriter(end_arq, true); 
			PrintWriter gravarArq = new PrintWriter(arq); 
			gravarArq.print(texto);
			arq.close();
		}catch(IOException e){
			System.out.println("Erro na escrita do arquivo:"+ e.getMessage());
		}
	}
	
	//Substitui o texto presente no arquivo por um novo
	public void escrever_arq_sub(String texto, String end_arq){
		try{
			FileWriter arq = new FileWriter(end_arq); 
			PrintWriter gravarArq = new PrintWriter(arq); 
			gravarArq.print(texto);
			arq.close();
		}catch(IOException e){
			System.out.println("Erro na escrita do arquivo:"+ e.getMessage());
		}
	}
	
}
