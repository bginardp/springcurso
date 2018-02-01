var app={
  iniciFactura: function(){
    this.iniciControls();
  },

  iniciControls: function(){
	  $("#btnAddlin").on("click", function(){
		  $('#frmAddLin').submit();  
	  });
	  $("#cliente").autocomplete({
					source : '/ajax/clientes',
					minLength:2,
					select : function(event, ui) {
						event.preventDefault();
						$("#clienteId").val(ui.item.value);
						$("#cliente").val(ui.item.label);
						$("#dadesCli").html(
								'<strong>' + ui.item.cif +  '</strong><br/>' 
										+ ui.item.direccion + '<br/>' 
										+ ui.item.postal + ' ' + ui.item.municipio + '<br/>' + ui.item.provincia				
						);
					},					
				    focus: function(event, ui) {
				        event.preventDefault();
				        $("#cliente").val(ui.item.label);
				    }
		});
		$("#empresa").autocomplete(
				{
					source : '/ajax/empresas',
					select : function(event, ui) {
						var id = ui.item.value;
						var nom = ui.item.label;
						event.preventDefault();
						$("#empresaId").val(id);
						$("#empresa").val(nom);
						$("#dadesEmp").html(
								'<strong>' + ui.item.nif + '</strong><br/>' 
										+ ui.item.direccion + '<br/>' 
										+ ui.item.postal + ' ' + ui.item.municipio + '<br/>' + ui.item.provincia
						);
					},					
				    focus: function(event, ui) {
				        event.preventDefault();
				        $("#empresa").val(ui.item.label);
				    }
		});
		$("#producte").autocomplete(
				{
					source : '/ajax/productos',
					select : function(event, ui) {
						var id = ui.item.value;
						var nom = ui.item.label;
						event.preventDefault();
						$("#linea\\.producto\\.id").val(id);
						$("#linea\\.dem").val(nom);
						/* $("#dadesPro").html(
								'<strong>' + ui.item.label + '</strong><br/>' 
										+ ui.item.cif + '<br/>' 
										+ ui.item.direccion + '<br/>' 
										+ ui.item.value); */
					},					
				    focus: function(event, ui) {
				        event.preventDefault();
				        $("#producte").val(ui.item.label);
				    }
				});
  },
 
};

//if ('addEventListener' in document) {
//    document.addEventListener('DOMContentLoaded', function() {
//        app.iniciFactura();
//    }, false);
//}

$(document).ready(function(){
	app.iniciFactura();
});

