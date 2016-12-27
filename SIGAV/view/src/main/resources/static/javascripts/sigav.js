$(function() {
	var decimal = $('.js-decimal');
	decimal.maskMoney({ thousands: '.' });
	
	var plain = $('.js-plain');
	plain.maskMoney({ precision: 0,thousands: '.' });
});