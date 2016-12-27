var SIGAV = SIGAV || {};

SIGAV.Mask = (function(){
	
	function Mask(){
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}
	
	Mask.prototype.enable = function(){
		this.decimal.maskMoney({ thousands: '.' });
		this.plain.maskMoney({ precision: 0, thousands: '.' });
	}
	
	return Mask;
	
}());

$(function() {
	var mask = new SIGAV.Mask();
	mask.enable();
});