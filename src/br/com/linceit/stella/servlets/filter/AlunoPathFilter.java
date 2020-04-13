package br.com.linceit.stella.servlets.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.TipoCadastro;
import br.com.linceit.stella.dto.UsuarioLogado;

@WebFilter(urlPatterns = {"/aluno/*"})
public class AlunoPathFilter implements Filter {
	
	@Override
	public void destroy() {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest servR = (HttpServletRequest) request;
		UsuarioLogado usuarioLogado = (UsuarioLogado) servR.getSession().getAttribute("usuario");
		if(usuarioLogado != null && usuarioLogado.getTipo() == TipoCadastro.ALUNO) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect(servR.getContextPath() + "/");
		}			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
