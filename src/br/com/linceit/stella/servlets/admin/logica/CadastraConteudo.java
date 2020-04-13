package br.com.linceit.stella.servlets.admin.logica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Conteudo;
import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bo.ConteudoBO;
import br.com.linceit.stella.service.bucket.StellaBucket;
import br.com.linceit.stella.servlets.Logica;
import br.com.linceit.stella.servlets.Utils;

public class CadastraConteudo implements Logica {
	

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		String realPath = req.getServletContext().getRealPath("/");
		File conteudoPath = new File(realPath+"/conteudo");
		if(!conteudoPath.isDirectory()) {
			conteudoPath.mkdir();
		}
		
		// Cria arquivo do conteudo
		UUID rdmUUID = UUID.randomUUID();
		String fileName= rdmUUID+".txt";
		File newConteudo = new File(conteudoPath.getAbsolutePath()+"/"+fileName);
		OutputStreamWriter fw;
		try {
			fw = new OutputStreamWriter(new FileOutputStream(newConteudo), StandardCharsets.ISO_8859_1);
			fw.write(req.getParameter("conteudoCapitulo"));
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			
		}
		
		new StellaBucket().uploadFile(newConteudo);
		
		// Cria Disciplina Bean
		Disciplina disciplina = new Disciplina(Integer.valueOf(req.getParameter("cdDisciplina")));
		// Cria Conteudo Bean
		Conteudo capitulo = new Conteudo();
		capitulo.setLocalDoc(fileName);
		capitulo.setNome(Utils.toUTF8(req.getParameter("nomeCapitulo")));
		capitulo.setDisciplina(disciplina);
		try {
			ConteudoBO.getInstance().salvarConteudo(capitulo);
			req.setAttribute("mensagem", "Conteudo salvo com sucesso!");
			req.setAttribute("redirect", "/admin/info.jsp");
			return "/admin/redirect";
		} catch (Exception e) {
			req.setAttribute("mensagem", "Ocorreu um imprevisto!");
			req.setAttribute("mensagemErro", true);
			req.setAttribute("redirect", "/admin/info.jsp");
			
			return "/admin/redirect";
		}
	}

}
