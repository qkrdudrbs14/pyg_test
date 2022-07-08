


$(document).ready(() => {

    $("#logoutBtn")[0].addEventListener("click", () => {
        console.log("logout");
        document.location.href ="/logout";
    });

    $("#mainBtn")[0].addEventListener("click", () => {
        console.log("mainBtn");
        document.location.href ="/main";
     });

    $("#cdBtn")[0].addEventListener("click", () => {
        console.log("cdBtn");
        document.location.href ="/cd";
    });

    $("#mailBtn")[0].addEventListener("click", () => {
        console.log("mailBtn");
        document.location.href ="/mail";
    });

});