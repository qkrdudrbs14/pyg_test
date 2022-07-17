
$(document).ready(() => {


});

let voices = [];
function getSynth() {
    return new Promise((resolve, reject) => {
        const synth = window.speechSynthesis;
        setTimeout(() => {
            voices = synth.getVoices();
            resolve(synth);
        },300)
    })
}

function sResult(_synth) {
    const lang = "ko-KR";
    const utterThis = new SpeechSynthesisUtterance(_result);
    utterThis.onend = (event) => {
        console.log("end")
        console.log("event : " , event);
    }

    utterThis.onerror = (error) => {
        console.log("error : " , error);
    }

    let voiceFound = false;
    for(let i=0; i < voices.length; i++) {
        if(voices[i].lang.indexOf(lang) >= 0 || voices[i].lang.indexOf(lang.replace('-', '_')) >= 0) {
            utterThis.voice = voices[i];
            voiceFound = true;
        }
    }

    if(!voiceFound) {
        alert("voice not found");
        return;
    }

    utterThis.lang = lang;
    utterThis.pitch = 1;
    utterThis.rate = 1;

    _synth.speak(utterThis)
}

let _result = "";
function getSText() {

    $.get("/getSText",{sl_id: 1} , (_data) => {
        _result = _data;
        getPlay()
    },"json")
    .done(() => {
    })
    .fail((error) => {
        console.log("error = " , error)
    })
}

function getPlay() {

    getSynth().then((_synth) => {
        sResult(_synth);
    })
}