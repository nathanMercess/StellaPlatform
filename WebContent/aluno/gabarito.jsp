<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:alunoTemplate>
	<jsp:attribute name="lastScript">

	</jsp:attribute>
	<jsp:body>
	<div class="jumbotron jumbotron-fluid">
			  <div class="container">
			    <h1 class="display-4">
							<span>${tituloAvaliacao}</span>
						</h1>
			    <p class="lead"></p>
			  </div>
		</div>
	<div class="container">
		<section style="margin-top: 25px;">
			<c:forEach var="q" items="${listaQuestionario}" varStatus="loop">
			<div class="questao" id="q${q.cdQuestao}">
				<h3>${loop.index+1}º Pergunta</h3>
				<div class="pergunta">
								<strong>${q.pergunta}</strong>
				</div>
				<div class="resposta">
					<span>A) </span>
					<input ${q.respostaAluno =='A' ? "checked" :""} type="radio" id="${q.cdAvaliacao}_${q.cdQuestao}_A" disabled
									name="${q.cdAvaliacao}_${q.cdQuestao}_A">
					<label style="${q.respostaCorreta=='A' ? 'font-weight:bold;color:green' : ''}" for="${q.cdAvaliacao}_${q.cdQuestao}_A">${q.respostaA}</label>
				</div>
				<div class="resposta">
					<span>B) </span>
					<input ${q.respostaAluno =='B' ? "checked" :""} type="radio" id="${q.cdAvaliacao}_${q.cdQuestao}_B" disabled
									name="${q.cdAvaliacao}_${q.cdQuestao}_B">
					<label style="${q.respostaCorreta=='B' ? 'font-weight:bold;color:green' : ''}" for="${q.cdAvaliacao}_${q.cdQuestao}_B">${q.respostaB}</label>
				</div>
				<div class="resposta">
					<span>C) </span>
					<input ${q.respostaAluno =='C' ? "checked" :""} type="radio" id="${q.cdAvaliacao}_${q.cdQuestao}_C" disabled
									name="${q.cdAvaliacao}_${q.cdQuestao}_C">
					<label style="${q.respostaCorreta=='C' ? 'font-weight:bold;color:green' : ''}" for="${q.cdAvaliacao}_${q.cdQuestao}_C">${q.respostaC}</label>
				</div>
				<div class="resposta">
					<span>D) </span>
					<input ${q.respostaAluno =='D' ? "checked" :""} type="radio" id="${q.cdAvaliacao}_${q.cdQuestao}_D" disabled 
						 name="${q.cdAvaliacao}_${q.cdQuestao}">
					<label style="${q.respostaCorreta=='D' ? 'font-weight:bold;color:green' : ''}" for="${q.cdAvaliacao}_${q.cdQuestao}_D">${q.respostaD}</label>
				</div>
			</div>
			</c:forEach>
		</section>
	</div>
    </jsp:body>
</t:alunoTemplate>
</html>