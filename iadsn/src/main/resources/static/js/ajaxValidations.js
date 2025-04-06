$(document).ready(function() {
    $(".form").submit(function(event) {
        event.preventDefault();
        // Limpar mensagens de erro anteriores
        $(".error-data-dizimo").html("").hide(); // Esconde a mensagem de erro  
        $(".error-valor-dizimo").html("").hide(); // Esconde a mensagem de erro

        // Verificar se os campos foram preenchidos
        const dataEntrada = $("#data-dizimo").val();
        const valorDizimo = $("#valor-dizimo").val();
        const pessoaDizimista = $("#pessoa-dizimista").val();

        if (!dataEntrada) {
            $(".error-data-dizimo").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
            return; // Impede o envio do formulário
        }

        if (!valorDizimo) {
            $(".error-valor-dizimo").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
            return; // Impede o envio do formulário
        }

        if (pessoaDizimista === "selecionar") {
            $(".error-pessoa-dizimista").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
            return; // Impede o envio do formulário
        }

        // Se passar pelas validações, permitir o envio do formulário
        $(this).unbind("submit").submit();
    });
});