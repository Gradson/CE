package br.org.gradson.ce.controller;

public interface ApiUrl {

	final static String API = "/api/";
	final static String CAIXAELETRONICO = API + "caixa-eletronico";
	final static String CAIXAELETRONICO_ID = API + "caixa-eletronico/{caixaId}";
	final static String CAIXAELETRONICO_SACAR = API + "caixa-eletronico/{nomeCaixa}";
	final static String USUARIO = API + "usuario";
	final static String USUARIO_ID = API + "usuario/{usuarioId}";
	final static String USUARIO_CONSULTA = API + "usuario/{nomeUsuario}/valor/{valor}";
}
