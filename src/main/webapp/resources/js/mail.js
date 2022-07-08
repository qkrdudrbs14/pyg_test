
$(document).ready(() => {

    $("#mailSendBtn")[0].addEventListener("click", () => {

        if(confirm("메일을 보내시겠습니까?")) {
            console.log("mail processing...")

            
            /*
            mailServer = smtplib.SMTP_SSL('smtp.gmail.com', 465)
            mailServer.login('qkrdudrbs14@gmail.com','pxvjrtobuzxvzhrf')
            mailServer.send_message(msg)
            mailServer.quit()
            */

//            $.get("/sendMail",() => {
            $.get("/sendMailAndFile",() => {
                console.log("mail send seccessed")
                alert("메일이 성공적으로 발송되었습니다.")
            })
            .done(() => {
                
            })
            .fail((err) => {
                console.log(`error = ${err}`)
            })

            return
        }

        console.log("메일 안보냄");
       
    });
});

