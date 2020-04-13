package br.com.linceit.stella.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.linceit.stella.bean.Aluno;
import br.com.linceit.stella.bo.AlunoBO;

@WebServlet("/cadastro")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String retorno = "";
		try {
			cadastrarAluno(request);
			retorno = "index.jsp";
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			request.setAttribute("erro", e.getMessage());
			retorno = "cadastro.jsp";
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(retorno);
		requestDispatcher.forward(request, response);
	}
	
	public void cadastrarAluno(HttpServletRequest request) throws Exception {
		String nome = Utils.toUTF8(request.getParameter("nome"));
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String dataNsc = request.getParameter("data");
		Calendar dataNasc = Calendar.getInstance();
		SimpleDateFormat ptParser = new SimpleDateFormat("dd-MM-yyy");
		SimpleDateFormat enParser = new SimpleDateFormat("MM-dd-yyyy");
		try {
			dataNasc.setTime(ptParser.parse(dataNsc));
		} catch (ParseException e) {
			dataNasc.setTime(enParser.parse(dataNsc));
		}
		
		String endereco = request.getParameter("endereco");
		int telefone = Integer.parseInt(request.getParameter("telefone"));
		AlunoBO alunoBO = new AlunoBO();
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setSenha(senha);
		aluno.setEmail(email);
		aluno.setDtNascimento(new Date(dataNasc.getTimeInMillis()));
		aluno.setEndereco(endereco);
		aluno.setTelefone(telefone);
		aluno.setDtCriacao(new Date(System.currentTimeMillis()));
		aluno.setCdRecuperacaoUtilizado(false);
		alunoBO.salvarAluno(aluno);
		request.setAttribute("Cadastrado com sucesso !", aluno.getNome());
	}

}
