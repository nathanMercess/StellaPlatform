<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:alunoTemplate>
	<jsp:body>
	 <div class="jumbotron jumbotron-fluid">
			  <div class="container">
			    <h1 class="display-4">
							<span>${disciplina}</span>
						</h1>
			    <p class="lead"></p>
			  </div>
	</div>
	<div class="container-fluid">
		<jsp:useBean id="disciplina"
				class="br.com.linceit.stella.bean.Conteudo" />
		<h3>Conteúdo disponível</h3>
       	<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Nome</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<jsp:useBean id="encoder" class="br.com.linceit.stella.servlets.Utils"  scope = "session"/>
				  <c:forEach var="conteudo" items="${conteudosComProgressao}">
				    <tr id="${conteudo.cdConteudo}">
				      <td>${conteudo.tituloConteudo}</td>
				      <td>
					      <a href="${pageContext.request.contextPath}/aluno?action=VerConteudo&cdConteudo=${conteudo.cdConteudo}&tituloConteudo=${encoder.urlEncode(conteudo.tituloConteudo,'UTF-8')}">
					      		<i class="fas fa-eye rosa"></i>
					      </a>
				      </td>
				    </tr>
	           	  </c:forEach>
			  </tbody>
		</table>
		<h3>Avaliações</h3>
		<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Titulo</th>
			      <th scope="col">Num. Questões</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach var="avaliacao" items="${avaliacoes}">
				    <tr id="${avaliacao.cdAvaliacao}">
				      <td>${avaliacao.titulo}</td>
				      <td>${avaliacao.qtdeQuestao}</td>
				      <td>
					      <a href="${pageContext.request.contextPath}/aluno?action=VerAvaliacao&cdAvaliacao=${avaliacao.cdAvaliacao}">
					      		<i class="fas fa-eye rosa"></i>
					      </a>
				      </td>
				    </tr>
	           	  </c:forEach>
			  </tbody>
		</table>
	</div>
    </jsp:body>
</t:alunoTemplate>