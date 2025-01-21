//    $(".atualizar_membro").click(function(event){
//        event.preventDefault();
//
//        var id = $(this).attr('id');
//        alert(id);
//        $.ajax({
//            url: 'http://localhost:8080/membros_api/pesquisar/37',
//            method: 'get',
//            dataType: 'json',
//            success: function(membro) {
//                console.log("Resposta do servidor:", membro); // Confirme que este log aparece
//                alert("Nome do membro: " + membro.nome); // Verifica se o nome é exibido
//                $(".nome_atual").val(membro.nome); // Atualiza o input
//            },
//            error: function(jqXHR, textStatus, errorThrown) {
//                console.error("Erro na requisição: ", textStatus, errorThrown);
//                console.error("Resposta do servidor: ", jqXHR.responseText);
//                console.log('Algo deu errado ao procurar membro id: ' + id);
//            }
//        });
//    });
