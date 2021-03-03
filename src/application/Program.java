package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Cliente;
import entities.Encomenda;
import entities.ItemEncomenda;
import entities.Produto;
import entities.enums.EstadoEncomenda;



public class Program {
	public static void main(String args[]) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat nascimento = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduza informação do cliente:");
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();
		System.out.print("Email:");
		String emailCliente = sc.nextLine();
		while (verifyEmail(emailCliente)==false) {
			System.out.print("Email:");
			emailCliente = sc.nextLine();
		}
		System.out.print("Data de nascimento dd/MM/yyyy:");
		Date dataNascimento = nascimento.parse(sc.next());
		Cliente cliente = new Cliente(nomeCliente, emailCliente,dataNascimento);
		System.out.println("Introduza informações da encomenda:");
		System.out.print("Estado do Pedido:");
		EstadoEncomenda estado = EstadoEncomenda.valueOf(sc.next());
		System.out.print("Quantos Produtos deseja comprar:");
		int numero = sc.nextInt();
		Encomenda encomenda = new Encomenda(new Date(), estado, cliente);
		for (int i = 1; i <= numero; i++) {
			System.out.println("Introduzir Produto " +i+":");
			System.out.print("Nome do Produto:");
			sc.nextLine();
			String nomeProduto = sc.nextLine();			
			System.out.print("Preço do Produto:");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantidade do Produto:");
			int quantidadeProduto = sc.nextInt();	
			Produto produto = new Produto(nomeProduto,precoProduto);
			ItemEncomenda itemencomenda = new ItemEncomenda(quantidadeProduto, precoProduto, produto);
			encomenda.additems(itemencomenda);
		}	
		System.out.println("Encomenda:");
		System.out.println(encomenda);
		sc.close();			
	}
	
	public static boolean verifyEmail(String emailCliente) {
		if(emailCliente.contains("@")&&emailCliente.contains(".")){
			System.out.println("Valid Email!");
			return true;
		}
		else{
			System.out.println("Email not Valid!");
			return false;
		}	
	}
}
