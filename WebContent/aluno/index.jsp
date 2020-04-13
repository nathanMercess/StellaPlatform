<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:alunoTemplate>
	<jsp:body>
		
	        <div class="jumbotron jumbotron-fluid">
			  <div class="container">
			    <h1 class="display-4">
							<span>Bem vindo ${usuario.nome}</span>
						</h1>
			    <p class="lead">Acesse nossos conteudos e estude com a Stella :)</p>
			  </div>
			</div>
		<div class="container">
			<h3><i class="fas fa-book rosa"></i> Suas disciplinas</h3>
			<div class="row">
			<jsp:useBean id="encoder" class="br.com.linceit.stella.servlets.Utils"  scope = "session"/>
			<c:forEach var="disciplina" items="${disciplinas}">
				<div class="col-lg-4 col-sm-12">
					<div class="card" style="width: 18rem; margin-top: 15px;">
					  <div class="card-body">
					    <h5 class="card-title"><span>${disciplina.nome}</span></h5>
					    <a href="${pageContext.request.contextPath}/aluno?action=ListaConteudo&disciplina=${encoder.urlEncode(disciplina.nome,'UTF-8')}&cdDisciplina=${disciplina.cdDisciplina}"
					     class="card-link">Ver conteudo</a>
					  </div>
					</div>	
				</div>
	        </c:forEach>
	        </div>
			<div style="margin-top:45px;margin-left:10px;" >
			<a href="${pageContext.request.contextPath}/aluno?action=GerenciarDisciplinas">Gerenciar disciplinas</a>
			</div>
		</div>
    </jsp:body>
</t:alunoTemplate>