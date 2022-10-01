package br.edu.ifpb.linkedlistdescriptornode.ListaEncadeadaNoDescritor;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProgramaListaMiniProjeto implements CommandLineRunner {
	private static String[] opcoes = {"1 - adicionar", "2 - excluir índice", "3 - excluir elemento", 
			"4 - anterior","5 - consultar posição de um elemento", "6 - consultar elemento de uma posição", 
			"7 - consultar tamanho", "8 - imprimir o primeiro", "9 - imprimir o último","0 - imprimir a lista", 
			"s - sair"};	
	
	private static String menu(Scanner leitor) {
		for(String s : opcoes) {
			System.out.println(s);
		}
		System.out.print("opção: ");
		return leitor.nextLine().toLowerCase();
	}
	
	public static String lerString(Scanner leitor) {
		System.out.print("entrada: ");
		return leitor.nextLine().toLowerCase();
	}

	public static int lerInteiro(Scanner leitor) {
		System.out.print("entrada: ");
		return Integer.parseInt(leitor.nextLine());
	}

	public static void escolha(Scanner leitor, String opcao, TListaMiniProjeto lista) throws Exception{
		switch (opcao) {
		case "1":
			lista.add(lerString(leitor));
			System.out.println("Inserido com sucesso!");
			break;
		case "2":
			System.out.println("Excluído com sucesso: " + lista.removeIndex(lerInteiro(leitor)));
			break;
		case "3":
			lista.removeElem(lerString(leitor));
			System.out.println("Excluído com sucesso!");
			break;
		case "4":
			System.out.println("Você quer saber quem vem antes de quem?");
			System.out.println(lista.previous(lerString(leitor)));
			break;
		case "5":
			System.out.println(lista.index(lerString(leitor)));
			break;
		case "6":
			System.out.println(lista.elemen(lerInteiro(leitor)));
			break;
		case "7":
			System.out.println("Atualmente há " + lista.size() + " elementos na lista.");
			break;
		case "8":
			System.out.println("Primeiro: " + lista.first());
			break;
		case "9":
			System.out.println("Último: " + lista.last());
			break;
		case "0":
			lista.print();
			break;
		default:
			throw new Exception("Opção inválida");
		}
	}

	@Override
	public void run(String... args) throws Exception {
		TListaMiniProjeto lista = new ListaEncadeadaComNoDescritor();
		Scanner leitor = new Scanner(System.in);	
		
		String opcao = menu(leitor);
		
		while (opcao.equals("s") == false) {
		
			try {
				escolha(leitor, opcao, lista);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			opcao = menu(leitor);
			
		}
		
		System.out.println("Fim de Programa");
		lista.print();
		leitor.close();
	}
}
