 package br.com.alura.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.servico.AgendamentoEmailServico;
import br.com.alura.utils.Utils;

@WebServlet("emails")
public class AgendamentoEmailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AgendamentoEmailServico servico;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		servico.listar().forEach(resultado ->
		pw.print("E-mails: " + resultado.getEmail() + "\n"));
		pw.close();
	}
	
	@Override
	// email, assunto, mensagem
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		BufferedReader reader = req.getReader();
		String[] email = reader.readLine().split(",");
		servico.inserir(Utils.preencherEmail(email));
	}
}
