<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<t:adminTemplate title="Painel Administrativo">
	<jsp:body>
	<div class="container-fluid">
		 <c:if test="${!mensagemErro}">
		 	<div class="alert alert-success" role="alert">
  				${mensagem}
			</div>
		</c:if>
		
		<c:if test="${mensagemErro}">
			<div class="alert alert-danger" role="alert">
  				${mensagem}
			</div>
		</c:if>
		
	</div>
    </jsp:body>
</t:adminTemplate>