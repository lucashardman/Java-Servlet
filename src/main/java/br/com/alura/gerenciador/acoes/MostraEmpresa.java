package br.com.alura.gerenciador.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.model.Banco;
import br.com.alura.gerenciador.model.Empresa;

public class MostraEmpresa {

	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer Id = Integer.valueOf(paramId);
		
		Banco banco  = new Banco();
		Empresa emp = banco.buscaEmpresa(Id);
		
		request.setAttribute("empresa", emp);
		
		return "foward:formAlteraEmpresa.jsp";
	}
}
