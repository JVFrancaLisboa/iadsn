$(document).ready(function() {
    $("#form-dizimo").submit(function(event) {
        event.preventDefault();
        // Limpar mensagens de erro anteriores
        $(".error-data-dizimo").html("").hide();
        $(".error-valor-dizimo").html("").hide();

        // Verificar se os campos foram preenchidos
        const dataDizimo = $("#data-dizimo").val();
        const valorDizimo = $("#valor-dizimo").val();
        const pessoaDizimista = $("#pessoa-dizimista").val();
        
        //dizimos
        if (!dataDizimo) {
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

    $("#form-oferta").submit(function(event) {
        event.preventDefault();
        // Limpar mensagens de erro anteriores
        $(".error-data-oferta").html("").hide();
        $(".error-valor-oferta").html("").hide();

        // Verificar se os campos foram preenchidos
        const dataOferta = $("#data-oferta").val();
        const valorOferta = $("#valor-oferta").val();

        if (!dataOferta) {
            $(".error-data-oferta").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
            return; // Impede o envio do formulário
        }

        if (!valorOferta) {
            $(".error-valor-oferta").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
            return; // Impede o envio do formulário
        }

        // Se passar pelas validações, permitir o envio do formulário
        $(this).unbind("submit").submit();
    });

    $("#form-gasto").submit(function(event) {
        event.preventDefault();
        // Limpar mensagens de erro anteriores
        $(".error-doc-gasto").html("").hide();
        $(".error-data-gasto").html("").hide();
        $(".error-valor-gasto").html("").hide();

        // Verificar se os campos foram preenchidos
        const docGasto = $("#doc-gasto").val();
        const dataGasto = $("#data-gasto").val();
        const valorGasto = $("#valor-gasto").val();

        if (!docGasto) {
            $(".error-doc-gasto").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
            return; // Impede o envio do formulário
        }

        if (!dataGasto) {
            $(".error-data-gasto").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
            return; // Impede o envio do formulário
        }

        if (!valorGasto) {
            $(".error-valor-gasto").html("*Campo obrigatório").show(); // Exibe a mensagem de erro
            return; // Impede o envio do formulário
        }

        // Se passar pelas validações, permitir o envio do formulário
        $(this).unbind("submit").submit();
    });
});