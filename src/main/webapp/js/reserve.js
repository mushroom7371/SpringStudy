/**
 * 백신 예약 스크립트
 */

var reserve = {};

reserve.doReserve = function(){
	$('#reserveindex').load('doReserve.reserve');	
}

reserve.sc = function(){
	$('#reserveindex').load('sc.reserve');	
}

reserve.init = function(){
	
	//메일전송
	$('#reserve #btnMailSend').on('click', function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();

		$.ajax({
			type    : 'POST',
			url     : '../mailSender.reserve',
			data    : param,
			dataType : "json",
			success : function(resp) {
				alert('메일이 전송되었습니다.');
				alert(resp.chkNum)
			},
			error : function(resp){
				alert('메일 전송을 실패했습니다.');
			}
		});
	})
	
	$('#reserve #btnMeReserve').on('click', function(){
		$('#reserveindex').load('me.reserve');		
	})
	
	$('#reserve #btnOtherReserve').on('click', function(){
		$('#reserveindex').load('other.reserve');		
	})
	
	$('#reserve #btnSc').on('click', function(){
		alert('예약이 완료되었습니다. 조회화면으로 넘어갑니다.');
		$('#reserveindex').load('sc.reserve');	
	})
	
	$('#reserve #btnSearch').on('click', function(){
		$('#reserveindex').load('search.reserve');		
	})
	
	$('#reserve #btnCancle').on('click', function(){
		$('#reserveindex').load('cancle.reserve');		
	})
	
	$('#reserve #btnCancleR').on('click', function(){
		alert('예약이 취소되었습니다. 예약페이지로 넘어갑니다')
		$('#reserveindex').load('doReserve.reserve');		
	})
	
	$('#reserve #btnSend').on('click', function(){
		$('#reserveindex').load('mail.reserve');		
	})
	
}

