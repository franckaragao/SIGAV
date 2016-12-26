$(function(){
	var number = $('.js-number');
	number.maskMoney({precision: 0 });
});

$(function(){
	var number = $('.js-number-only');
	number.maskMoney('destroy');
});