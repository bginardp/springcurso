var app={
  iniciFactura: function(){
    this.iniciControls();
  },

  iniciControls: function(){
//	  $("#empresa").autocomplete({
//			source: '/ajax/search',
//			select: function( event, ui ) {
//				 var value = ui.item.value;
//				 var id = ui.item.id;
//				 console.log("id:"+id + "  value:"+value);
//			 }
//		});
	
	  $("#cliente").autocomplete({
					source : '/ajax/clientes',
					select : function(event, ui) {
						var id = ui.item.value;
						var nom = ui.item.label;
						// $( "#divAjax" ).html( data.message+" "+data.timestamp );
						event.preventDefault();
						$("#clienteId").val(id);
						$("#cliente").val(nom);
						$("#dadesCli").html(
								'<strong>' + ui.item.label + '</strong><br/>' 
										+ ui.item.cif + '<br/>' 
										+ ui.item.direccion + '<br/>' 
										+ ui.item.value);
					}
				});
		$("#empresa").autocomplete(
				{
					source : '/ajax/empresas',
					select : function(event, ui) {
						var id = ui.item.value;
						var nom = ui.item.label;
						// $( "#divAjax" ).html( data.message+" "+data.timestamp );
						event.preventDefault();
						$("#clienteId").val(id);
						$("#cliente").val(nom);
						$("#dadesCli").html(
								'<strong>' + ui.item.label + '</strong><br/>' 
										+ ui.item.cif + '<br/>' 
										+ ui.item.direccion + '<br/>' 
										+ ui.item.value);
					}
				});
		$("#concepto").autocomplete(
				{
					source : '/ajax/productos',
					select : function(event, ui) {
						var id = ui.item.value;
						var nom = ui.item.label;
						// $( "#divAjax" ).html( data.message+" "+data.timestamp );
						event.preventDefault();
						$("#productoId").val(id);
						$("#producto").val(nom);
						/* $("#dadesPro").html(
								'<strong>' + ui.item.label + '</strong><br/>' 
										+ ui.item.cif + '<br/>' 
										+ ui.item.direccion + '<br/>' 
										+ ui.item.value); */
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

