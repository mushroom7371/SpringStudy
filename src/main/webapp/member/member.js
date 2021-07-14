/**
 * 
 */
var member = {};

member.init = function(){
	$('#btnSearch').on('click', function(){
		var frm = $('#frm_member')[0];
		var param = $(frm).serialize();
		
		$('#member').load('../search.test', param);
		
		/*$.ajax({
			type	:	'POST',
			url		:	'../search.test',
			data	:	param,
			success	: function(resp){
				
			},
			error : function(resp){
				alert('해당하는 정보의 회원이 없습니다');
			}
		
			
		})*/
		
	})
	
}