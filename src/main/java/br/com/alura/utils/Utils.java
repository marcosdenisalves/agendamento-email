package br.com.alura.utils;

import br.com.alura.entidade.AgendamentoEmail;

public class Utils {

	public static AgendamentoEmail preencherEmail(String[] email) {
		AgendamentoEmail preparaEmail = new AgendamentoEmail();
		preparaEmail.setEmail(email[0]);
		preparaEmail.setAssunto(email[1]);
		preparaEmail.setMensagem(email[2]);
		return preparaEmail;
	}
}
