package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import model.Cliente;
import model.Entrada;
import model.Fornecedor;
import model.Produto;
import model.Saida;
import view.Tela;

public class Principal {

	//public static ArrayList<Produto> produtos;
	public static final String ARQUIVO_PRODUTOS = "C:/Users/muril/git/JavaProgrammer/Kardex/db/Produtos.csv";

	public static void main(String[] args) {

		//produtos = seedProdutoManual();
		seedProdutoCSV();
		seedFornecedor();
		ArrayList<Cliente> clientes = seedCliente();

		Tela frame = new Tela();
		frame.setVisible(true);

		/*
		 * Kardex n�o pode ser instanciado pois � uma classe abstrata - gerada por
		 * heran�a Kardex k = seedKardex(p);
		 * 
		 * 
		 * Produto p = produtos.get(3); Fornecedor f = fornecedores.get(0); Cliente c =
		 * clientes.get(0); System.out.println(p); Entrada e = seedEntrada(p,f);
		 * System.out.println(e); System.out.println(p); Saida s = seedSaida(p,c);
		 * System.out.println(s); System.out.println(p);
		 * 
		 */

	}

	public static Saida seedSaida(Produto p, Cliente c) {
		int id = 1;
		Date data = new Date("01/21/2021");
		String doc = "NF 888";
		int qtde = 5;
		double valor = 450.00;
		Saida s = new Saida(id, p, c, data, doc, qtde, valor);
		return s;
	}

	public static Entrada seedEntrada(Produto p, Fornecedor f) {
		int id = 1;
		Date data = new Date("01/20/2021");
		String doc = "NF 999";
		int qtde = 20;
		double valor = 350.00;
		Entrada e = new Entrada(id, p, f, data, doc, qtde, valor);
		return e;
	}

	public static ArrayList<Cliente> seedCliente() {
		ArrayList<Cliente> lista = new ArrayList<>();

		lista.add(new Cliente(1, "005.421.980-96", "William Gates III", "(11) 91111-2222", "bill@microsoft.com"));
		lista.add(new Cliente(2, "034.750.010-20", "Elon Musk", "(11) 99999-9999", "elon@spacex.com"));
		lista.add(new Cliente(3, "393.892.870-06", "Nikola Tesla", "(11) 98765-4321", "nikola@tesla.com"));

		return lista;
	}

	public static void seedFornecedor() {
		new Fornecedor(1, "46.388.927/0001-41", "Microsoft Corporation", "1112345678", "vendas@microsoft.com");
		new Fornecedor(2, "13.433.432/0001-38", "Kingston Cards", "2122225555", "vendas@kingston.com");
		new Fornecedor(3, "07.720.304/0001-72", "Samsung Inc.", "1199999999", "sales@samsung.com");
	}

	public static void seedProdutoCSV() {
		try {
			FileReader fr = new FileReader(ARQUIVO_PRODUTOS);
			BufferedReader br = new BufferedReader(fr);
			// desprezar cabe�alho do arquivo
			String linha = br.readLine();
			do {
				linha = br.readLine();
				if (linha != null) {
					String[] campos = linha.split(",");
					int id = Integer.parseInt(campos[0]);
					String nome = campos[1];
					String localizacao = campos[2];
					int qtdeMaxima = Integer.parseInt(campos[3]);
					int qtdeMinima = Integer.parseInt(campos[4]);
					int qtdeEstoque = Integer.parseInt(campos[5]);
					new Produto(id, nome, localizacao, qtdeMaxima, qtdeMinima, qtdeEstoque);
				}
			} while (linha != null);
			br.close();
			fr.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static ArrayList<Produto> seedProdutoManual() {
		ArrayList<Produto> lista = new ArrayList<>();

		int id = 1;
		String nome = "Pente de mem�ria 16GB DDR4 2666Mhz";
		String localizacao = "Prateleira 3 Caixa 5";
		int qtdeMaxima = 100;
		int qtdeMinima = 20;
		int qtdeEstoque = 80;
		Produto p = new Produto(id, nome, localizacao, qtdeMaxima, qtdeMinima, qtdeEstoque);
		lista.add(p);

		lista.add(new Produto(2, "Teclado ABNT para notebook", "Prateleira 4 Caixa 2", 200, 10, 10));
		lista.add(new Produto(3, "Monitor Full HD IPS 23.4", "Prateleira 7", 50, 5, 5));
		lista.add(new Produto(4, "Mouse Gamer 2400 5 bot�es", "Prateleira 4 Caixa 5", 200, 10, 30));
		lista.add(new Produto(5, "Headset BM800", "Prateleira 2 Caixa 10", 100, 10, 20));

		return lista;
	}

//	public static Kardex seedKardex(Produto p) {
//		int id = 1;
//		Date data = new Date("19/01/2021");
//		String doc = "NF 1234";
//		int qtde = 10;
//		double valor = 1000;	
//		Kardex k = new Kardex(id,p,data,doc,qtde,valor);
//		return k;
//	}

}