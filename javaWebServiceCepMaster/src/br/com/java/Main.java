package br.com.java;

import java.util.Scanner;

import br.com.java.dominio.Endereco;
import br.com.java.viacep.ServidorDeCep;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.out.print("Informe seu CEP:");
		String cep = new Scanner(System.in).nextLine();
		Endereco endereco = ServidorDeCep.buscaEnderecoPelo(cep);
		
		System.out.println("Logradouro: " + endereco.getLogradouro());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Localidade: " + endereco.getLocalidade());
	}

}
