package br.com.linceit.stella.servlets.admin.logica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Administrador;
import br.com.linceit.stella.bean.Conteudo;
import br.com.linceit.stella.bean.Disciplina;
import br.com.linceit.stella.bo.DisciplinaBO;
import br.com.linceit.stella.dto.UsuarioLogado;
import br.com.linceit.stella.service.bucket.StellaBucket;
import br.com.linceit.stella.servlets.Logica;
import br.com.linceit.stella.servlets.Utils;

public class CadastraDisciplina implements Logica {
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		UsuarioLogado usuarioLogado = (UsuarioLogado) req.getSession().getAttribute("usuario");
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
		
		// Upload AWS S3 Bucket
		new StellaBucket().uploadFile(newConteudo);
		// Cria Disciplina Bean
		Disciplina disciplina = new Disciplina();
		disciplina.setAdministrador(new Administrador(usuarioLogado.getIdentificador(), usuarioLogado.getNome()));
		disciplina.setDtAbertura(new Date(System.currentTimeMillis()));
		disciplina.setAtiva(true);
		disciplina.setDtEncerramento(new Date(0l));
		disciplina.setNome(Utils.toUTF8(req.getParameter("nomeDisciplina")));
		// Cria Conteudo Bean
		Conteudo primeiroCapitulo = new Conteudo();
		primeiroCapitulo.setLocalDoc(fileName);
		primeiroCapitulo.setNome(Utils.toUTF8(req.getParameter("nomePrimeiroCapitulo")));
		
		try {
			new DisciplinaBO().salvarDisciplina(disciplina, primeiroCapitulo);
			req.setAttribute("mensagem", "Disciplina salva com sucesso!");
			req.setAttribute("redirect", "/admin/info.jsp");
			return "/admin/redirect";
		} catch (Exception e) {
			req.setAttribute("mensagem", "Ocorreu um imprevisto!");
			req.setAttribute("mensagemErro", true);
			req.setAttribute("redirect", "/admin/info.jsp");
			System.out.println(e.getLocalizedMessage());
			return "/admin/redirect";
		}
	}

}
