console.log("Abriu o arquivo!");

var botaoAddAutor = document.querySelector("#add-autor");

botaoAddAutor.addEventListener("click", function(event) {
    event.preventDefault();
    console.log("O botão foi clicado!");
});