var btnGetVoice = document.querySelector("#getVoiceButton");
btnGetVoice.addEventListener("click", function(event) {
	event.preventDefault();
	var question = document.querySelector("#question");
	if(question.value != "") {
		sendMessageToVoice(question.value);
	} else {
		alert("Preencher com a questão");
	}
	
	question.value = "";
});

function sendMessageToVoice(msg) {
	console.log(msg);
	var xhr = new XMLHttpRequest();
	addErrorListener(xhr);
	xhr.open("POST", getContextPath()+"/api/tts", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Codigo de sucesso
			var blob = new Blob([xhr.response], {type : "audio/wav"});
			createAudioElement(blob);
			console.log("Create audio element")
			unlockControls();
		}else {
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
			unlockControls();
			createErrorMessage("Oooops.. Ocorreu um imprevisto", "bot");
		}
	});
	xhr.responseType = 'blob';
	var data = "question=" + msg;
	xhr.send(data);
}

function createAudioElement(blob) {
	var url = URL.createObjectURL(blob);
	var audio = document.createElement("audio");
	var div = document.createElement("div");
	
	audio.controls = true;
	audio.autoplay = true;
	audio.src = url;
	
	div.appendChild(audio);
	var chat = document.querySelector(".chat-container");
	chat.appendChild(div);
	scrollDivDown(chat);
}






