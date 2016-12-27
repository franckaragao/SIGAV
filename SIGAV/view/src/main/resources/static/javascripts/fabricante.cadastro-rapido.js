var SIGAV = SIGAV || {};

SIGAV.CadastroFabricante = (function() {
	
	function CadastroFabricante(){
		this.modal = $('#cadastroRapidoFab');
		this.btnSave = this.modal.find('.js-btn-save-fabricante');
		this.form = this.modal.find('form');
		this.url = this.form.attr('action');
		this.inputModal = $('#nomeFabricante');
		this.containerError = $('.js-message');
	};
	
	CadastroFabricante.prototype.iniciar = function(){
		this.modal.on('shown.bs.modal', onModalShow.bind(this));
		this.modal.on('hide.bs.modal', onModalClose.bind(this));
		this.btnSave.on('click', onSaveFabricante.bind(this));
	};
	
	function onSaveFabricante(){
		var nomeFabricante = this.inputModal.val().trim();
		$.ajax({
			url: this.url,
			method : 'POST',
			contentType: "application/json",
			data: JSON.stringify({'nome': nomeFabricante}),
			error: onSaveError.bind(this),
			success: onSaveSuccess.bind(this)
		});
	};
	
	function onSaveSuccess(fabricante){
		var selectFab = $('#fabricante');
		selectFab.append('<option value=' + fabricante.id + '>' + fabricante.nome + '</option>');
		selectFab.val(fabricante.id);
		this.modal.modal('hide');
	};
	
	function onSaveError(response){
		this.form.on('submit', function(event){event.preventDefault()});
		this.containerError.removeClass('hidden');
		this.containerError.html('<span>' +response.responseText+ '</span>');
		this.form.find('.form-group').addClass('has-error');
	};
	
	function onModalShow(){
		this.inputModal.focus();
	};
	
	function onModalClose(){
		this.inputModal.val('');
		this.containerError.addClass('hidden');
		this.form.find('.form-group').removeClass('has-error');
		
	};
	
	return CadastroFabricante;
	
})();

$(function(){

	cadastroFabricante = new SIGAV.CadastroFabricante();
	cadastroFabricante.iniciar();
	
});