
public class Principal {
	/*
	 * Este programa foi feito para registrar apenas 200 funcionários.
	 * Mas caso queira aumentar, mude a variavel abaixo: NUM_MAX_DE_FUNC
	 * e é apenas um exemplo de classes, modificadores de acesso, menus.
	 * Escrito por Lucas Moreira
	 */
	
	private final static int NUM_MAX_DE_FUNC = 200;
	
	
	
	
	
	
	static Funcionario listaFuncs[] = new Funcionario[NUM_MAX_DE_FUNC];
	
	
	
	
	
	public static void main(String[] args) {
		ConsoleMenu.showMenu();
		
	}

}
