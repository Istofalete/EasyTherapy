package br.com.easy_therapy.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Criptografia {
	public static String encriptarSenha(String senha) throws Exception{
		
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(senha.getBytes(), 0, senha.length());
		
		return new BigInteger(1,m.digest()).toString(16);
		
	}
	//teste
	
	public static void main(String[] args) {
		
		try {
			System.out.println(Criptografia.encriptarSenha("2222"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
