


$(document).ready(() => {

    $("#fileuploadBtn")[0].addEventListener("click", () => {
        console.log("file upload");
        upload();
    });

});

async function test(){
    const response = await fetch("/fileupload",)
}

function upload() {
    const fileInput = $("#fileInput")[0];
//    console.log("fileInput: ", fileInput);

    if(fileInput.files.length === 0) {
        alert("no selected files");
        return;
    }

    let formData = new FormData();
    formData.append("file1", $("#fileInput")[0].files[0]);

    console.log(formData);


    $.ajax({
        type:"POST",
        url: "./fileupload",
        data: formData,
//        dataType : "json",
        processData : false,
        contentType : false,
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
        },
        success: function(response) {
            console.log(response);
        }
        ,
        error: function(jqXHR) {
            console.log("err = " , jqXHR.responseText)
        }
    })
}