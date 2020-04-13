package br.com.linceit.stella.servlets.aluno.logica;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.linceit.stella.bo.AvaliacaoBO;
import br.com.linceit.stella.dto.AvaliacaoRespondida;
import br.com.linceit.stella.servlets.Logica;
import br.com.linceit.stella.servlets.Utils;

public class SalvarRespostasAvaliacao implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {

		try {
			AvaliacaoRespondida avaliacaoRespondida = new Gson().fromJson(Utils.convert(req.getInputStream(), StandardCharsets.UTF_8), AvaliacaoRespondida.class);
			AvaliacaoBO.getInstance().salvarAvaliacaoRespondida(avaliacaoRespondida);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/aluno/afterJob";
	}
	
}
