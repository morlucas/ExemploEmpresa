import java.util.Scanner;

public class ConsoleMenu {
	static private Scanner src = new Scanner(System.in);
	static int index = 0;
	
	
	//Menu de opcoes
	static void showMenu(){
		
		int opcaoSel=0;
		
		do{
			System.out.println(	"Bem vindo ao menu de seleção da \'Empresa Fictícia\'\n"+
							"Selecione uma opção do menu: \n"+
							"1. Registrar funcionário\n"+
							"2. Demitir funcionário\n"+
							"3. Definir salário\n" +
							"4. Definir comissão\n"+
							"5. Mostrar lista de funcionários\n"+
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
		System.out.println("Digite o nome do funcionário novo:");
		src.nextLine();
		String nome = src.nextLine();
		Principal.listaFuncs[index].setNome(nome);
		
		System.out.println("Digite o salário do funcionário novo:");
		if(src.hasNext()){
			int nv = src.nextInt();
			Principal.listaFuncs[index].setSalario(nv);
		}else{
			
		}
		System.out.println("Digite a porcentagem da comissão deste novo funcionário: ");
		if(src.hasNext()){
			float nv = src.nextInt();
			if(nv < 100 && nv > 0){
				nv /= 100;
				Principal.listaFuncs[index].setComissao(nv);
			}else{
				System.out.println("Valor digitado está incoerente. O valar da comissão do"
						+ "funcionário " + Principal.listaFuncs[index].getNome() + " foi ajustado para o valor padrão.\n");
			}
		}
		
		System.out.println("Funcionário criado");
		Principal.listaFuncs[index].mostraAtts();
		index++;
		
		showMenu();
		
	}
	
	//demite o funcionario selecionado
	static void deletarFunc(){
		Funcionario del = pesquisaFunc();
		if(del != null) del = null;
		System.out.println("Funcionário demitido.\n");
		showMenu();
	}
	
	//procura um funcionario pelo nome e retorna a sua instacia
	static Funcionario procuraFunc(String nome){
		for(int i = 0; i<index;i++){
			if(Principal.listaFuncs[i].getNome().startsWith(nome)) return Principal.listaFuncs[i];
		}
		System.out.println("Não encontramos funcionário com este nome. =(");
		return null;
		
	}
	
	//define salario de funcionario selecionado
	static void definirSalario(){
		Funcionario nS = pesquisaFunc();
		if(nS != null){
			System.out.println("Digite o novo salário deste funcionário: ");
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
			System.out.println("Digite o id do funcionário:");
			int id = src.nextInt();
			return Principal.listaFuncs[id];
		}else if(sel == 2){
			System.out.println("Digite o nome do funcionário:");
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
			System.out.println("Total de funcionários: " + index);
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
			System.out.println("Não foi possível alterar a comissão.\n");
			showMenu();
		}
		
		showMenu();
		
	}
	
	//calculo da folha de pagamento
	static void folhaPagamentos(){
		int valorTotalSalario = 0;
		float valorTotalComissoes = 0;
		
		System.out.println("ID   -   Salário   -    Comissão");
		for(int i = 0; i<index;i++){
			System.out.println(Principal.listaFuncs[i].getID() + "     " + Principal.listaFuncs[i].getSalario()
					+ "     " + ( Principal.listaFuncs[i].getComissao() * Principal.listaFuncs[i].getSalario() ) );
			
			valorTotalSalario += Principal.listaFuncs[i].getSalario();
			valorTotalComissoes += Principal.listaFuncs[i].getComissao()*Principal.listaFuncs[i].getSalario();
			
		}
		System.out.println("Valor total - salários: " + valorTotalSalario +
							" comissões: " + valorTotalComissoes + "\nTotal: " + (valorTotalComissoes+valorTotalSalario) + "\n\n");
		
		showMenu();
	}
}
