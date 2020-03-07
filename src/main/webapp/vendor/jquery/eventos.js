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
        
 function enviarMatri(m){
    
            var action ='add-matricula';
            var codMater = m;
            // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
            $.post('MatriculasServlet', {
                    action : action,
                    codMater :codMater,
                    idEstu : id
            }, function(responseText) {
                    $('#modal_body').html(responseText);
            });  
}
 function quitarMatri(m){
    
            var action ='quitar-matricula';
            var codMatri = m;
            // Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
            $.post('MatriculasServlet', {
                    action : action,
                    codMatri :codMatri,
                    idEstu : id
            }, function(responseText) {
                    $('#modal_body').html(responseText);
            });  
}

