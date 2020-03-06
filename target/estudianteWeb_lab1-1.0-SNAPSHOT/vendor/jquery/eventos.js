/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 
  


/* global id */

$(document).ready(function() {
		$('#btn_modal').click(function(event) {
			var action ='mostrar';
			
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.post('MostrarMateriaServlet', {
				action : action,
				idEstu : id
			}, function(responseText) {
				$('#modal_body').html(responseText);
			});
		});
	});
        
$(document).ready(function() {
		$('#add-matricula').click(function(event) {
                    console.log("entrando en add-matricula");
			var action ='add-matricula';
			var codMater = $(this).attr('valor');
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.post('MatriculasServlet', {
				action : action,
				codMatri : codMater,
                                idEstu : id
			}, function(responseText) {
				$('#modal_body').html(responseText);
			});
		});
	});
$(document).ready(function() {
		$('#quitar-matricula').click(function(event) {
			var action ='quitar-matricula';
			var codMatri = $(this).attr('valor')
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
			$.post('MatriculasServlet', {
				action : action,
				codMatri :codMatri,
                                idEstu : id
			}, function(responseText) {
				$('#modal_body').html(responseText);
			});
		});
	});
        
 function enviarMatri(){
    
            var action ='add-matricula';
            var codMatri = $(this).attr('valor');
            // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
            $.post('MatriculasServlet', {
                    action : action,
                    codMatri :codMatri,
                    idEstu : id
            }, function(responseText) {
                    $('#modal_body').html(responseText);
            });  
}

