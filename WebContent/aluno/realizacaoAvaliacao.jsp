<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:alunoTemplate>
	<jsp:attribute name="lastScript">
		<script>
			$("#formQuestionario").submit(() => {
				event.preventDefault();
				let questoesDiv = $("#formQuestionario").children(".questao");
				
				let avaliacaoRespondida = {
					cdAvaliacao: ${cdAvaliacao},
					cdDisciplina:${cdDisciplina},
					cdMatricula:${cdMatricula},
				}
				
				let questoes = [];
				let cdAv = avaliacaoRespondida.cdAvaliacao;
				for(let questao of questoesDiv) {
					let q = {};
					q.cdQuestao = questao.id.replace("q","");
					let idInput = "#"+cdAv+"_"+q.cdQuestao+"_";
					let idInputA = idInput+"A";
					let idInputB = idInput+"B";
					let idInputC = idInput+"C";
					let idInputD = idInput+"D";
					
					if($(idInputA).is(":checked")) {
						q.resposta = "A"
					} else if($(idInputB).is(":checked")) {
						q.resposta = "B"
					} else if($(idInputC).is(":checked")) {
						q.resposta = "C"
					} else {
						q.resposta = "D"
					}
					
					questoes.push(q);
				}
				
				avaliacaoRespondida.respostas = questoes;
				console.log(avaliacaoRespondida);
				axios.post(getContextPath()+"/aluno?action=SalvarRespostasAvaliacao", avaliacaoRespondida).then(()=> {
					window.location= getContextPath()+"/aluno?action=VerAvaliacao&cdAvaliacao="+${cdAvaliacao};
				}).catch(err => {
					alert("Ocorreu um imprevisto!");
				});
			});
		</script>
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
			<form id="formQuestionario">
			<c:forEach var="q" items="${listaQuestionario}" varStatus="loop">
			<div class="questao" id="q${q.cdQuestao}">
				<h3>${loop.index+1}º Pergunta</h3>
				<div class="pergunta">
								<strong>${q.pergunta}</strong>
							</div>
				<div class="resposta">
					<span>A) </span>
					<input type="radio" id="${q.cdAvaliacao}_${q.cdQuestao}_A" required
									name="${q.cdAvaliacao}_${q.cdQuestao}">
					<label for="${q.cdAvaliacao}_${q.cdQuestao}_A">${q.respostaA}</label>
				</div>
				<div class="resposta">
					<span>B) </span>
					<input type="radio" id="${q.cdAvaliacao}_${q.cdQuestao}_B" required
									name="${q.cdAvaliacao}_${q.cdQuestao}">
					<label for="${q.cdAvaliacao}_${q.cdQuestao}_B">${q.respostaB}</label>
				</div>
				<div class="resposta">
					<span>C) </span>
					<input type="radio" id="${q.cdAvaliacao}_${q.cdQuestao}_C" required
									name="${q.cdAvaliacao}_${q.cdQuestao}">
					<label for="${q.cdAvaliacao}_${q.cdQuestao}_C">${q.respostaC}</label>
				</div>
				<div class="resposta">
					<span>D) </span>
					<input type="radio" id="${q.cdAvaliacao}_${q.cdQuestao}_D" required
									name="${q.cdAvaliacao}_${q.cdQuestao}">
					<label for="${q.cdAvaliacao}_${q.cdQuestao}_D">${q.respostaD}</label>
				</div>
			</div>
			</c:forEach>
				<input style="margin-top:25px;" class="btn btn-primary" type="submit" value="Enviar respostas"/>
			</form>
		</section>
	</div>
    </jsp:body>
</t:alunoTemplate>
</html>