<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:adminTemplate title="Nova avaliação">
	<jsp:attribute name="lastScript">
			<script>
				function createLabel(htmlFor, text) {
					let label = document.createElement("label");
					label.htmlFor = htmlFor;
					label.innerHTML = text;
					return label
				}
				
				function showMessage(message, type) {
					let div = document.createElement("div");
					div.className = "alert " + type;
					div.innerHTML = message;
					$("#messages").append(div);
				}
				
				function createInput(id) {
					let input = document.createElement("input");
					input.id = id;
					input.className = "form-control";
					input.type = "text";
					input.required = true;
					return input;
				}
				
				function createFormCheck(id, value) {					
					let radioDiv = document.createElement("div")
					radioDiv.className="form-check form-check-inline"
					let check = document.createElement("input")
					check.type = "radio"
					check.name = "inlineRadioOptions"+id
					check.id = id
					check.value = value;
					let checkLabel = document.createElement("label");
					checkLabel.className ="form-check-label";
					checkLabel.htmlFor= id;
					checkLabel.innerHTML = value;
					radioDiv.appendChild(check);
					radioDiv.appendChild(checkLabel);
					return radioDiv;
				}
				
				function addQuestao(questaoId) {
					let questaoDiv = document.createElement("div");
					questaoDiv.id = "questao"+questaoId;
					
					let formGroup = document.createElement("div");
					formGroup.className = "form-group";
					// Pergunta
					formGroup.appendChild(createLabel("inputPergunta"+questaoId,"Pergunta Num." + questaoId));
					formGroup.appendChild(createInput("inputPergunta"+questaoId));
					// Letra A
					formGroup.appendChild(createLabel("inputLetraA"+questaoId,"Letra A"));
					formGroup.appendChild(createInput("inputLetraA"+questaoId));
					// Letra B
					formGroup.appendChild(createLabel("inputLetraB"+questaoId,"Letra B"));
					formGroup.appendChild(createInput("inputLetraB"+questaoId));
					// Letra C
					formGroup.appendChild(createLabel("inputLetraC"+questaoId,"Letra C"));
					formGroup.appendChild(createInput("inputLetraC"+questaoId));
					// Letra D
					formGroup.appendChild(createLabel("inputLetraD"+questaoId,"Letra D"));
					formGroup.appendChild(createInput("inputLetraD"+questaoId));
					// Resposta
					let span = document.createElement("span");
					span.innerHTML = "Resposta";
					formGroup.appendChild(span);
					formGroup.appendChild(document.createElement("br"));
					formGroup.appendChild(createFormCheck("checkA"+questaoId,"A"));
					formGroup.appendChild(createFormCheck("checkB"+questaoId,"B"));
					formGroup.appendChild(createFormCheck("checkC"+questaoId,"C"));
					formGroup.appendChild(createFormCheck("checkD"+questaoId,"D"));
					$("#questoes").append(questaoDiv);
					$("#"+questaoDiv.id).append(formGroup);
				}
				
				function removeQuestao(id) {
					$("#questao"+id).remove()
				}
				
				$("#inputQtdeQuestoes").blur(function(){
					if(this.value > 0 && this.value <= 10) {
						const questoesLen = $("#questoes").children().length;
						if(questoesLen < this.value) {
							for(var i = questoesLen; i < this.value;i++) {
								var questaoId = i+1;
								addQuestao(questaoId);
							}
						} else if(questoesLen > this.value) {
							for(let i = questoesLen; i > this.value ;i--) {
								removeQuestao(i);
							}
						}
					}
				});
				
				$("#formAvaliacao").submit(function() {
					 event.preventDefault();
					 const avaliacao = {};
					 avaliacao.disciplina = {cdDisciplina:Number($("#cdDisciplina").children("option:selected").val())};
					 avaliacao.qtdeQuestao = Number($("#inputQtdeQuestoes").val());
					 avaliacao.titulo = $("#inputTitulo").val();
					 let questoesDiv = $("#questoes").children();
					 let questoes = [];
					 for(let i = 0 ; i < avaliacao.qtdeQuestao;i++) {
						 let questao = {};
						 questao.descricao = $("#inputPergunta"+(i+1)).val();
						 questao.respostaA = $("#inputLetraA"+(i+1)).val();
						 questao.respostaB = $("#inputLetraB"+(i+1)).val();
						 questao.respostaC = $("#inputLetraC"+(i+1)).val();
						 questao.respostaD = $("#inputLetraD"+(i+1)).val();
						 if($("#checkA"+(i+1)).is(":checked")) {
							 questao.correta = "A";
						 } else if($("#checkB"+(i+1)).is(":checked")) {
							 questao.correta = "B";
						 } else if($("#checkC"+(i+1)).is(":checked")) {
							 questao.correta = "C";
						 } else if($("#checkD"+(i+1)).is(":checked")) {
							 questao.correta = "D";
						 } else {
							 alert("Preencher a resposta da pergunta "+ (i+1));
							 return;
						 }
						 
						 questoes.push(questao);
					 }
					 avaliacao.questoes = questoes;
					 
					 axios.post(getContextPath()+"/admin?action=SalvarAvaliacao", avaliacao).then((res) => {
						 showMessage("Avaliacao salva com sucesso","alert-success");
						 clearForm();
					 }).catch((err) => {
						 showMessage("Ocorreu um imprevisto", "alert-danger");
					 });
				});
				
				function clearForm() {
					$("#inputQtdeQuestoes").val("");
					$("#inputTitulo").val("");
					const questoesLen = $("#questoes").children().length;
					for(let i = 0; i < questoesLen ;i++) {
						removeQuestao((i+1));
					}
				}
			</script>
	</jsp:attribute>

	<jsp:body>	
	<div class="container-fluid">
		<div id="messages"></div>
       	<form id="formAvaliacao">
       	<h4>Disciplina</h4>
		  <div class="form-group">
		    <select class="form-control" name="cdDisciplina" id="cdDisciplina">
		        <c:forEach items="${disciplinas}" var="d">
		            <option value="${d.cdDisciplina}">${d.nome}</option>
		        </c:forEach>
    		</select>
		  </div>
		
		<div class="form-group">
			<label for="inputTitulo">Titulo da avaliação</label>
			<input required name="titulo" type="text" class="form-control"
						id="inputTitulo" />
		</div>  
		
		<div class="form-group">
			<label for="inputQtdeQuestoes">Quantidade de questões</label>
			<input name="qtdeQuestoes" type="number" min="1" max="10" required
						class="form-control" id="inputQtdeQuestoes" />
		</div>
		
		<div id="questoes">
			
		</div>
		
		<button type="submit" class="btn btn-primary">Salvar</button>
		</form>
	</div>
    </jsp:body>


</t:adminTemplate>