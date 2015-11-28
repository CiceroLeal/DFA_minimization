
public class Estado {
	private boolean inicial = false;
	private boolean aceitacao = false;
	
	public void setInicial(boolean inicial){
		this.inicial = inicial;
	}
	
	public void setAceitacao(boolean aceitacao){
		this.aceitacao = aceitacao;
	}
	
	public boolean aceitacao(){
		return aceitacao;
	}
	
	public boolean inicial(){
		return inicial;
	}
}
