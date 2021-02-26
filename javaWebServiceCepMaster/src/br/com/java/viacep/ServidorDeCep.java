package br.com.java.viacep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.java.dominio.Endereco;
import br.com.java.util.Util;
import com.google.gson.Gson;

public class ServidorDeCep {
	static String webservice = "http://viacep.com.br/ws/";
	static int codigoSucesso = 200;
	
	public static Endereco buscaEnderecoPelo(String cep) throws Exception{
		String urlParaChamada = webservice + cep + "/json";
		
		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			
			if (conexao.getResponseCode() != codigoSucesso) 
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
				
				BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
				String jsonEmString = Util.converteJsonEmString(resposta);
				
				Gson gson = new Gson();
				Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);
				
				return endereco;
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro:  " + e);
		}
	}

}
