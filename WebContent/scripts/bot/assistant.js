window.onload = function() {
	callBot("");
}


function handleError(e) {
	console.log(e);
	unlockControls();
	createErrorMessage("Falha na comunicação","bot");
}

function addErrorListener(xhr) {
	xhr.addEventListener('error', handleError)
	xhr.addEventListener('abort', handleError)
}

function lockControls() {
	document.querySelector("#sendQuestion").disabled = true;
	document.querySelector("#recordButton").disabled = true;
	document.querySelector("#pauseButton").disabled = true;
	document.querySelector("#stopButton").disabled = true;
	setLoading(true);
}

function unlockControls() {
	document.querySelector("#sendQuestion").disabled = false;
	document.querySelector("#recordButton").disabled = false;
	document.querySelector("#pauseButton").disabled = true;
	document.querySelector("#stopButton").disabled = true;
	setLoading(false);
}

function setLoading(isLoading) {
	var loading = document.getElementById("loading");
	if(isLoading) {
		loading.className = "lds-ripple";
	} else {
		loading.className = "lds-ripple-invisible";
	}
}

function scrollDivDown(div) {
	for (var i = 0; i < div.offsetHeight; i++) {
		div.scrollTop++;
	}
}



function createMessage(message, type) {
	var chat = document.querySelector(".chat-container");
	var div = createDiv(message, type);
	chat.appendChild(div);
	scrollDivDown(chat);
}

function createErrorMessage(message, type) {
	var chat = document.querySelector(".chat-container");
	var div = createDiv(message, type, true);
	chat.appendChild(div);
	scrollDivDown(chat);
}

function createDiv(text, type, error) {
	var div = document.createElement("div");
	div.classList.add("chat");
	div.classList.add(type);
	if(error) {
		div.classList.add("chat-error");
	}
	div.textContent = text;
	return div;
}

var btnSendQuestion = document.querySelector("#sendQuestion");
btnSendQuestion.addEventListener("click", function(event) {
	event.preventDefault();
	var question = document.querySelector("#question");
	createMessage(question.value, "me");
	callBot(question.value);
	question.value = "";
});

function callBot(msg, comAudio) {
	lockControls();
	var xhr = new XMLHttpRequest();
	
	xhr.open("POST", getContextPath()+"/api/v1", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Codigo de sucesso
			var respostas = JSON.parse(xhr.responseText);
			respostas.forEach(function(resposta) {
				//var comVoz = document.getElementById("respostaVoz").checked;
				//console.log("Gerando mensagem com voz "+ comVoz);
				if(comAudio) {
					sendMessageToVoice(resposta);
				} else {
					createMessage(resposta, "bot");
					unlockControls();
				}
			});
		}else{
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
			createErrorMessage("Oooops.. Ocorreu um imprevisto", "bot");
			unlockControls();
		}
	});
	
	var data = "question=" + msg;
	xhr.send(data);
}












