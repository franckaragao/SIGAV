var SIGAV = SIGAV || {};

SIGAV.UploadFoto = (function(){
	
	function UploadFoto(){
		
		this.inputNomeFoto = $('input[name=foto]');
		this.inputContentType = $('input[name=contentType]');
		
		this.htmlFotoTemplate = $('#foto-veiculo').html();
		this.template = Handlebars.compile(this.htmlFotoTemplate);

		this.containerFoto = $('.js-local-foto');
		this.uploadDrop = $('#upload-drop');
		
	};
	
	UploadFoto.prototype.iniciar = function(){
		
		var settings = {
			type: 'json',
			filelimit: 1,
			allow: '*.(jpg|jpeg|png)',
			action: this.containerFoto.data('url-fotos'),
			complete: onUploadCompleto.bind(this)
		};
		
		UIkit.uploadSelect($('#upload-select'), settings);
		UIkit.uploadDrop(this.uploadDrop, settings);
		
	};
	
	function onUploadCompleto(response){
		this.inputNomeFoto.val(response.nome);
		this.inputContentType.val(response.contentType);
		
		this.uploadDrop.addClass('hidden');
		var htmlFoto = this.template({nomeFoto: response.nome});
		this.containerFoto.append(htmlFoto);
		
		$('.js-remove-foto').on('click', onRemoverFoto.bind(this));
		
	};
	
	function onRemoverFoto(){
		$('.js-foto-veiculo').remove();
		this.uploadDrop.removeClass('hidden');
		this.inputNomeFoto.val('');
		this.inputContentType.val('');
	}
	
	return UploadFoto;
	
})();

$(function(){
	
	uploadFoto = new SIGAV.UploadFoto();
	uploadFoto.iniciar();
	
});