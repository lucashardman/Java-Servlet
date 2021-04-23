package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.AlteraEmpresa;
import br.com.alura.gerenciador.acoes.ListaEmpresas;
import br.com.alura.gerenciador.acoes.MostraEmpresa;
import br.com.alura.gerenciador.acoes.NovaEmpresa;
import br.com.alura.gerenciador.acoes.NovaEmpresaForm;
import br.com.alura.gerenciador.acoes.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String paramAcao = request.getParameter("acao");
		String rdirect = null;
		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			rdirect = acao.executa(request, response);
		} else if (paramAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			rdirect = acao.executa(request, response);
		} else if (paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			rdirect = acao.executa(request, response);
		} else if (paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			rdirect = acao.executa(request, response);
		} else if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			rdirect = acao.executa(request, response);
		} else if (paramAcao.equals("NovaEmpresaForm")) {
			NovaEmpresaForm acao = new NovaEmpresaForm();
			rdirect = acao.executa(request, response);
		}
		
		String[] fwd = rdirect.split(":");
		
		if(fwd[0].equals("foward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+fwd[1]);
			rd.forward(request, response);
		} else if(fwd[0].equals("redirect")){
			response.sendRedirect(fwd[1]);
		}
	}

}
