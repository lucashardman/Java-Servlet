package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;

public class RemoveEmpresa {

	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer Id = Integer.valueOf(paramId);
		
		Banco banco  = new Banco();
		banco.removeEmpresa(Id);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
