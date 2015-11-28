
public class Estado {
	private boolean inicial = false;
	private boolean aceitacao = false;
	private boolean acessivel = false;
	
	public boolean acessivel() {
		return acessivel;
	}

	public void setAcessivel(boolean acessivel) {
		this.acessivel = acessivel;
	}

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
