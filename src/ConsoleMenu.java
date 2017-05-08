import java.util.Scanner;

public class ConsoleMenu {
	static private Scanner src = new Scanner(System.in);
	static int index = 0;
	
	
	//Menu de opcoes
	static void showMenu(){
		
		int opcaoSel=0;
		
		do{
			System.out.println(	"Bem vindo ao menu de sele��o da \'Empresa Fict�cia\'\n"+
							"Selecione uma op��o do menu: \n"+
							"1. Registrar funcion�rio\n"+
							"2. Demitir funcion�rio\n"+
							"3. Definir sal�rio\n" +
							"4. Definir comiss�o\n"+
							"5. Mostrar lista de funcion�rios\n"+
							"6. Calcular folha de pagamento\n" +
							"7. Sair");
			opcaoSel = src.nextInt();
		}while((opcaoSel > 8) || (opcaoSel <= 0));
		
		operacaoMenu(opcaoSel);
		
	}
	
	//analisa a opcao selecionada
	static void operacaoMenu(int opcaoSel){
		switch(opcaoSel){
		case 1:
			registrarFunc();
			break;
		case 2:
			deletarFunc();
			break;
		case 3:
			definirSalario();
			break;
		case 4:
			definirComissao();
			break;
		case 5:
			mostrarLista();
			break;
		case 6:
			folhaPagamentos();
			break;
		}
	}
	
	//registra novo funcionario
	static void registrarFunc(){
		Principal.listaFuncs[index] = new Funcionario();
		System.out.println("Digite o nome do funcion�rio novo:");
		src.nextLine();
		String nome = src.nextLine();
		Principal.listaFuncs[index].setNome(nome);
		
		System.out.println("Digite o sal�rio do funcion�rio novo:");
		if(src.hasNext()){
			int nv = src.nextInt();
			Principal.listaFuncs[index].setSalario(nv);
		}else{
			
		}
		System.out.println("Digite a porcentagem da comiss�o deste novo funcion�rio: ");
		if(src.hasNext()){
			float nv = src.nextInt();
			if(nv < 100 && nv > 0){
				nv /= 100;
				Principal.listaFuncs[index].setComissao(nv);
			}else{
				System.out.println("Valor digitado est� incoerente. O valar da comiss�o do"
						+ "funcion�rio " + Principal.listaFuncs[index].getNome() + " foi ajustado para o valor padr�o.\n");
			}
		}
		
		System.out.println("Funcion�rio criado");
		Principal.listaFuncs[index].mostraAtts();
		index++;
		
		showMenu();
		
	}
	
	//demite o funcionario selecionado
	static void deletarFunc(){
		Funcionario del = pesquisaFunc();
		if(del != null) del = null;
		System.out.println("Funcion�rio demitido.\n");
		showMenu();
	}
	
	//procura um funcionario pelo nome e retorna a sua instacia
	static Funcionario procuraFunc(String nome){
		for(int i = 0; i<index;i++){
			if(Principal.listaFuncs[i].getNome().startsWith(nome)) return Principal.listaFuncs[i];
		}
		System.out.println("N�o encontramos funcion�rio com este nome. =(");
		return null;
		
	}
	
	//define salario de funcionario selecionado
	static void definirSalario(){
		Funcionario nS = pesquisaFunc();
		if(nS != null){
			System.out.println("Digite o novo sal�rio deste funcion�rio: ");
			int novoSalario = src.nextInt();
			nS.setSalario(novoSalario);
			
		}else{
			showMenu();
		}
		showMenu();
	}
	
	//selecao de funcionario pelo nome ou pelo id
	static Funcionario pesquisaFunc(){
		System.out.println("1. Pesquisar por id \n2. Pesquisar por nome\n3. Sair");
		int sel = src.nextInt();
		
		if(sel == 1){
			System.out.println("Digite o id do funcion�rio:");
			int id = src.nextInt();
			return Principal.listaFuncs[id];
		}else if(sel == 2){
			System.out.println("Digite o nome do funcion�rio:");
			if(src.hasNext()){
				String nome = src.next();
				Funcionario coi = procuraFunc(nome);
				return coi;
			}
		}else{
			
		}
		return null;
	}
	
	//mostra a lista de funcionarios registrados
	static void mostrarLista(){
		for(int i = 0; i < index; i++){
			Principal.listaFuncs[i].mostraAtts();
			System.out.println("Total de funcion�rios: " + index);
		}
		showMenu();
	}
	
	//define comissao do funcionario selecionado
	static void definirComissao(){
		Funcionario nC = pesquisaFunc();
		if(nC != null){
			int nv = src.nextInt();
			nC.setComissao(nv);
		}else {
			System.out.println("N�o foi poss�vel alterar a comiss�o.\n");
			showMenu();
		}
		
		showMenu();
		
	}
	
	//calculo da folha de pagamento
	static void folhaPagamentos(){
		int valorTotalSalario = 0;
		float valorTotalComissoes = 0;
		
		System.out.println("ID   -   Sal�rio   -    Comiss�o");
		for(int i = 0; i<index;i++){
			System.out.println(Principal.listaFuncs[i].getID() + "     " + Principal.listaFuncs[i].getSalario()
					+ "     " + ( Principal.listaFuncs[i].getComissao() * Principal.listaFuncs[i].getSalario() ) );
			
			valorTotalSalario += Principal.listaFuncs[i].getSalario();
			valorTotalComissoes += Principal.listaFuncs[i].getComissao()*Principal.listaFuncs[i].getSalario();
			
		}
		System.out.println("Valor total - sal�rios: " + valorTotalSalario +
							" comiss�es: " + valorTotalComissoes + "\nTotal: " + (valorTotalComissoes+valorTotalSalario) + "\n\n");
		
		showMenu();
	}
}
