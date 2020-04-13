<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:adminTemplate title="${disciplina}">
	<jsp:body>
	<div class="container-fluid">
		<jsp:useBean id="disciplina"
				class="br.com.linceit.stella.bean.Conteudo" />
		<h3>Lista de conteudos</h3>
       	<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">CD</th>
			      <th scope="col">Nome</th>
			      <th scope="col">Ações</th>
			    </tr>
			  </thead>
			  <tbody>
				  <c:forEach var="conteudo" items="${conteudos}">
				    <tr id="${conteudo.cdConteudo}">
				      <th scope="row">${conteudo.cdConteudo}</th>
				      <td>${conteudo.nome}</td>
				      
				      <td>
					      <a href="${pageContext.request.contextPath}/admin?action=EditarConteudo&cdConteudo=${conteudo.cdConteudo}">
					      		<i class="fas fa-eye"></i>
					      </a>
					      <a href="${pageContext.request.contextPath}/admin?action=DeletarConteudo&id=${conteudo.cdConteudo}">
					      		<i class="fas fa-trash"></i>
					      </a>
				      </td>
				    </tr>
	           	  </c:forEach>
			  </tbody>
		</table>
	</div>
    </jsp:body>
</t:adminTemplate>