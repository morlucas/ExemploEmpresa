
public class Funcionario {
	private int salario;
	private int idFunc;
	private float comissao;
	private String nomeFunc;
	
	public Funcionario(){
		this.salario = 1000;
		this.comissao = 0.1f;
		this.idFunc = ConsoleMenu.index;
	}
	
	void setSalario(int salario){
		this.salario = salario;
		System.out.println("Salário de " + this.nomeFunc + " foi modificado para " + this.salario+"\n");
	}
	
	void setNome(String novoNome){
		nomeFunc = null;
		this.nomeFunc = novoNome;
		System.out.println("O nome do funcionário de id " + this.idFunc + " foi modificado para " + this.nomeFunc+"\n");
	}
	
	String getNome(){
		return nomeFunc;
	}
	
	int getSalario(){
		return this.salario;
	}
	
	void setComissao(float nv){
		this.comissao = nv;
		System.out.println("A comissão do funcionário(a) " + this.nomeFunc + " foi modificada para " + this.comissao+"\n");
		
	}

	float getComissao(){
		return this.comissao;
	}
	
	int getID(){
		return this.idFunc;
	}
	
	//mostra lista de todos os atributos da instancia do funcionario
	void mostraAtts(){
		System.out.println("Informações do funcionário " + this.idFunc + "\n"+
							"Nome: " + this.nomeFunc + "\n" +
							"Id: " + this.idFunc + "\n" +
							"Salario: " + this.salario + "\n"+
							"Comissão: " + this.comissao * 100 + "\n\n");
	}
	
}
