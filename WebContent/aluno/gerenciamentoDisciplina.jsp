<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:alunoTemplate>
	<jsp:body>
		<div class="jumbotron jumbotron-fluid">
			  <div class="container">
			    <h1 class="display-4">
							<span>Gerenciar disciplinas</span>
						</h1>
			    <p class="lead"></p>
			  </div>
		</div>
		<div class="container-fluid">
			<c:forEach var="d" items="${disciplinas}">
				<div class="card" style="margin-top:20px;">
				  <h5 class="card-header">${d.nomeDisciplina}</h5>
				  <div class="card-body">
				  	<c:if test="${d.cdMatricula == 0 || !d.ativa}">
				    	<a href="${pageContext.request.contextPath}/aluno?action=SalvaMatricula&cdDisciplina=${d.cdDisciplina}&cdMatricula=${d.cdMatricula}&ativa=true" class="btn btn-success">Ativar</a>
				    </c:if>
				    <c:if test="${d.cdMatricula > 0 && d.ativa}">
				    	<a href="${pageContext.request.contextPath}/aluno?action=SalvaMatricula&cdDisciplina=${d.cdDisciplina}&cdMatricula=${d.cdMatricula}&ativa=false" class="btn btn-danger">Desativar</a>
				    </c:if>
				  </div>
				</div>
			</c:forEach>
		</div>
    </jsp:body>
</t:alunoTemplate>