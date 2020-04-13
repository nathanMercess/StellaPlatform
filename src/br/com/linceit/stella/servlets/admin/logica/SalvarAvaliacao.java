package br.com.linceit.stella.servlets.admin.logica;

import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.linceit.stella.bean.Avaliacao;
import br.com.linceit.stella.bo.AvaliacaoBO;
import br.com.linceit.stella.servlets.Logica;
import br.com.linceit.stella.servlets.Utils;

public class SalvarAvaliacao implements Logica {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		try {
			ServletInputStream inputStream = req.getInputStream();
			String convert = Utils.convert(inputStream, StandardCharsets.UTF_8);
			Gson gson = new Gson();
			Avaliacao avaliacao = gson.fromJson(convert, Avaliacao.class);
			AvaliacaoBO avaliacaoBO = AvaliacaoBO.getInstance();
			avaliacaoBO.salvarAvaliacao(avaliacao);
			req.setAttribute("mensagem", "Avaliacao salva com sucesso!");
			return "/admin/afterJob";
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			req.setAttribute("mensagem", "Ocorreu um imprevisto!");
			req.setAttribute("mensagemErro", true);
			return "/admin/afterJob";
		}
	}
	
}
