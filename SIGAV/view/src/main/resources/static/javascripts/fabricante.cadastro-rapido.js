$(function(){
	var modal = $('#cadastroRapidoFab');
	var btnSave = modal.find('.js-btn-save-fabricante');
	var form = modal.find('form');
	var url = form.attr('action');
	var inputModal = $('#nomeFabricante');
	var containerError = $('.js-message');
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	btnSave.on('click', onSaveFabricante)
	
	/**
	 * 
	 */
	function onSaveFabricante(){
		var nomeFabricante = inputModal.val().trim();
		$.ajax({
			url: url,
			method : 'POST',
			contentType: "application/json",
			data: JSON.stringify({'nome': nomeFabricante}),
			error: onSaveError,
			success: onSaveSuccess
		});
	};
	
	/**
	 * 
	 */
	function onSaveSuccess(fabricante){
		var selectFab = $('#fabricante');
		selectFab.append('<option value=' + fabricante.id + '>' + fabricante.nome + '</option>');
		selectFab.val(fabricante.id);
		modal.modal('hide');
	};
	
	/**
	 * 
	 */
	function onSaveError(response){
		containerError.removeClass('hidden');
		containerError.html('<span>' +response.responseText+ '</span>');
		form.find('.form-group').addClass('has-error');
	};
	
	function onModalShow(){
		inputModal.focus();
	};
	
	function onModalClose(){
		inputModal.val('');
	};
	
	form.on('submit', function(event){
		event.preventDefault();
	});
});