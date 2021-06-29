/**
 * 백신 예약 스크립트
 */

var reserve = {};
var checkNumber;
var tomail;

reserve.doReserve = function(){
	$('#reserveindex').load('doReserve.reserve');	
}

reserve.sc = function(){
	$('#reserveindex').load('sc.reserve');	
}

reserve.init = function(){
	
	//메일전송
	$('#reserve #btnMailSend').unbind("click").bind('click', function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();

		$.ajax({
			type    : 'POST',
			url     : '../mailSender.reserve',
			data    : param,
			dataType : "json",
			success : function(resp) {
				alert('메일이 전송되었습니다.');
				
				checkNumber = resp.chkNum;
				tomail = resp.tomail;
				
			},
			error : function(resp){
				alert('메일 전송을 실패했습니다.');
			}
		});
	})
	
	$('#reserve #btnChkNum').on('click', function(){
		
		var key = document.getElementById("key").value;
		
		if(key == checkNumber){
			alert('인증되었습니다.')
			self.close();
			opener.document.getElementById("Email").value = document.getElementById("tomail").value;
			opener.document.getElementById("reserveOk").value = "인증되었습니다";
			
		}else(
			alert('인증번호를 다시 확인해 주세요.')
		)
	})
	
	$('#reserve #btnMyReserve').on('click', function(){
		$('#reserveindex').load('my.reserve');		
	})
	
	$('#reserve #btnOtherReserve').on('click', function(){
		$('#reserveindex').load('other.reserve');		
	})
	
	$('#reserve #btnReserve').unbind("click").bind("click", function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();
		
		if(document.getElementById("reserveOk").value != "인증되었습니다"){
			alert('인증을 완료하여 주세요.')
		}else{
			$.ajax({
				type    : 'POST',
				url     : 'insert.reserve',
				data    : param,
				success : function(resp){
					alert('예약이 완료되었습니다. 조회화면으로 넘어갑니다.');
					$('#reserveindex').load('sc.reserve');	
				}
			});	
		}
	})
	
	$('#reserve #btnReserveOther').unbind("click").bind("click", function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();
		
		var frm2 = $('#frm_otherReserve')[0];
		var phone = document.getElementById("myPhone").value;

		var param2 = $(frm2).serialize();
		var param3 = param2+"&myPhone="+phone

		if(document.getElementById("reserveOk").value != "인증되었습니다"){
			alert('인증을 완료하여 주세요.')
		}else{
			$.ajax({
				type    : 'POST',
				url     : 'insert.reserve',
				data    : param,
				success : function(resp){
					$.post('otherInsert.reserve', param3, function(data){
					$('#reserveindex').html(data);
					
					alert('예약이 완료되었습니다. 조회화면으로 넘어갑니다.');
				})
				}
			});	
		}
	})
	
	$('#reserve #btnSearch').on('click', function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();
		
		if(document.getElementById("myName").value == "" || document.getElementById("myJumin").value == "" || document.getElementById("reserveNum").value == ""){
			alert('예약정보를 모두 입력해 주세요.')
		
		}else{
			$.ajax({
				type    : 'POST',
				url     : 'search.reserve',
				data    : param,
				success : function(resp){
					if(resp.jumin == null){
						alert('조회 화면으로 이동합니다.');
						$('#reserveindex').load('search.reserve', param);
					}
				},
				
				error : function(xhr, resp, status){
				alert('입력하신 정보를 조회 할 수 없습니다.');
				}
			});

		}

	})
	
	$('#reserve #btnCancle').on('click', function(){
		$('#reserveindex').load('canclePage.reserve');		
	})
	
	$('#reserve #btnCancleR').on('click', function(){
		var frm = $('#frm_reserve')[0];
		var param = $(frm).serialize();
		
		$.ajax({
				type    : 'POST',
				url     : 'cancle.reserve',
				data    : param,
				success : function(resp){
					if(resp.jumin == null){
						alert('예약이 취소되었습니다. 조회 화면으로 이동합니다.');
						$('#reserveindex').load('sc.reserve');
					}
				},
				
				error : function(xhr, resp, status){
				alert('입력하신 정보를 삭제 할 수 없습니다.');
				}
			});
	})
	
	$('#reserve #btnSend').on('click', function(){
		$('#reserveindex').load('mail.reserve');		
	})
	
}

