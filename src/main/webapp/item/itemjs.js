/**
 * 
 */

var item = {};

item.init = function(){
	$('#btnFindStr').on('click',function(){
		var frm = $('#frm_item')[0];
		var param = $(frm).serialize();
		
		$('#item').load('../search.item', param);
	})
	
	$('#btnUpdate').on('click',function(){
		var frm = $('#frm_sql')[0];
		var param = $(frm).serialize();
		
		$('#item').load('../update.item', param);
	})
	
	$('#btnDelete').on('click',function(){
		var frm = $('#frm_sql')[0];
		var param = $(frm).serialize();
		
		$('#item').load('../delete.item', param);
	})
	
	
}