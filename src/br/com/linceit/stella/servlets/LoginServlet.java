package br.com.linceit.stella.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.linceit.stella.bean.TipoCadastro;
import br.com.linceit.stella.bo.LoginBO;
import br.com.linceit.stella.dto.UsuarioLogado;
import br.com.linceit.stella.exception.BOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session.setAttribute("usuario", null);
		response.sendRedirect(request.getContextPath() + "/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		session = request.getSession();
		
		LoginBO login = LoginBO.getInstance();
		try {
			UsuarioLogado usuarioLogado = login.logar(email, senha);
			session.setAttribute("erro", "");
			session.setAttribute("usuario", usuarioLogado);
			if (usuarioLogado.getTipo() == TipoCadastro.ALUNO) {
				response.sendRedirect(request.getContextPath() + "/aluno/load.jsp");
			} else if (usuarioLogado.getTipo() == TipoCadastro.ADMIN) {
				response.sendRedirect(request.getContextPath() + "/admin/");
			}

		} catch (BOException e) {
			session.setAttribute("erro", "Nome de usuário e/ou senha invalidos");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.include(request, response);

		}
	}
}
