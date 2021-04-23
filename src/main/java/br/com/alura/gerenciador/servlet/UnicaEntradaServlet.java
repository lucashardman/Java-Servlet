package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		String rdirect;
		
		try {
			Class classe = Class.forName("br.com.alura.gerenciador.acoes."+paramAcao);
			Acao acao = (Acao) classe.newInstance();
			rdirect = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
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
