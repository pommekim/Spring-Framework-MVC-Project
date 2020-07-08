<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 로그인 Modal-->
<div class="modal fade" id="log-in">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">
					<span style="color: #643691;">IZONE</span> 로그인
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">

				<form action="#" name="izone-sign-in" method="post" id="signInForm"
					style="margin-bottom: 0;">
					<table style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
						<tr>
							<td style="text-align: left">
								<p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="idCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="userId" id="signInId"
								class="form-control tooltipstered" maxlength="10"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="최대 10자"></td>
						</tr>
						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwCheck"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="signInPw"
								name="userPw" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="최소 8자"></td>
						</tr>
						<tr>
							<td style="padding-top: 10px; text-align: center">
								<p><strong>로그인하셔서 WIZONE이 되어보세요~~!</strong></p>
							</td>
						</tr>
						<tr>
							<td style="width: 100%; text-align: center; colspan: 2;"><input
								type="button" value="로그인" class="btn form-control tooltipstered" id="signIn-btn"
								style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">
							</td>
						</tr>
						<tr>
							<td
								style="width: 100%; text-align: center; colspan: 2; margin-top: 24px; padding-top: 12px; border-top: 1px solid #ececec">

								<a class="btn form-control tooltipstered" data-toggle="modal"
								href="#sign-up"
								style="cursor: pointer; margin-top: 0; height: 40px; color: white; background-color: orange; border: 0px solid #388E3C; opacity: 0.8">
									회원가입</a>
							</td>
						</tr>

					</table>
				</form>
			</div>
		</div>
	</div>
</div>

<!-- 회원가입 Modal -->
<div class="modal fade" id="sign-up" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">
					<span style="color: #643691;">IZONE</span> 회원 가입
				</h4>
				<button type="button" class="close" data-dismiss="modal">×</button>

			</div>

			<div class="modal-body">

				<form action="#" name="signup" id="signUpForm" method="post"
					style="margin-bottom: 0;">
					<table
						style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
						<tr>
							<td style="text-align: left">
								<p><strong>아이디를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;
								<span id="idChk"></span></p>
							</td>
								
							
						</tr>
						<tr>
							<td><input type="text" name="userId" id="user_id"
								class="form-control tooltipstered" maxlength="14"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="숫자와 영어로 4-10자">
								</td>
							
						</tr>

						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;
								<span id="pwChk"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="password"
								name="userPw" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="영문과 특수문자를 포함한 최소 8자"></td>
						</tr>
						<tr>
							<td style="text-align: left">
								<p><strong>비밀번호를 재확인해주세요.</strong>&nbsp;&nbsp;&nbsp;
								<span id="pwChk2"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="password" size="17" maxlength="20" id="password_check"
								name="pw_check" class="form-control tooltipstered" 
								maxlength="20" required="required" aria-required="true"
								style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
								placeholder="비밀번호가 일치해야합니다."></td>
						</tr>

						<tr>
							<td style="text-align: left">
								<p><strong>이름을 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="nameChk"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="text" name="userName" id="user_name"
								class="form-control tooltipstered" maxlength="6"
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="한글로 최대 6자"></td>
						</tr>
						
						<%--
						<tr>
							<td style="text-align: left">
								<p><strong>이메일을 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="emailChk"></span></p>
							</td>
						</tr>
						<tr>
							<td><input type="email" name="userEmail" id="user_email"
								class="form-control tooltipstered" 
								required="required" aria-required="true"
								style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
								placeholder="ex) izone@produce.com"></td>
						</tr>
						--%>

						<tr>
							<td style="padding-top: 10px; text-align: center">
								<p><strong>회원가입하셔서 WIZONE이 되어보세요~~!</strong></p>
							</td>
						</tr>
						<tr>
							<td style="width: 100%; text-align: center; colspan: 2;"><input
								type="button" value="회원가입" 
								class="btn form-control tooltipstered" id="signup-btn"
								style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">
							</td>
						</tr>

					</table>
				</form>
			</div>
		</div>
	</div>
</div>



<script>

//start jQuery
$(function() {
	
	let chk1 = false;
	
	//회원가입 검증!
	
	//ID 입력값 검증
	$("#user_id").on('keyup', function() {
		if($("#user_id").val() === "") {
			$("#user_id").css("background-color", "pink");
			$("#idChk").html('<b style="font-size:14px; color:red;">[아이디는 필수 정보입니다.]</b>');
			chk1 = false;
		} else {
			$("#user_id").css("background-color", "aqua");
			$("#idChk").html('<b style="font-size:14px; color:blue;">[아이디 사용이 가능합니다.]</b>');
		}
	});
	
	
	
	
	
	
	
	
	
	
	
	
	$('#signup-btn').click(function() {
		
		if(chk1) {
		
			//1. 사용자가 입력한 값을 각각 자바스크립트 변수에 담아줌
			//아이디 정보
			const id = $('#user_id').val();
			//패스워드 정보
			const pw = $('#password').val();
			//이름 정보
			const name = $('#user_name').val();
			
			//2. 자바스크립트 객체 생성 (JSON은 이 기법을 흉내낸 것뿐이지 자바스크립트 객체가 아님!!!)
			//왼쪽에 있는 키값을 멤버변수명과 똑같이 작성해주어야 함!!!
			const user = {
				account: id,
				password: pw,
				name: name
			};
			
			//3. 클라이언트에서 서버와 통신하는 ajax함수 (비동기 통신: 페이지가 넘어가지 않고 서버와 통신)
			$.ajax({
				type: "POST", //서버에 전송하는 HTTP 방식
				url: "/user/", //서버 요청 URL
				headers: {
					"Content-type": "application/json"
				}, //요청 헤더 정보 (내가 보내려는 정보의 타입이 무엇인지 명시!)
				dataType: "text", //서버로부터 응답받을 데이터의 형태
				data: JSON.stringify(user), //서버로 전송할 데이터 (자바스크립트 객체를 JSON의 문자열 형태로 변환해주는 메서드!!!)
				success: function(result) { //함수의 매개변수는 통신 성공 시 데이터가 저장될 곳
					console.log("통신 성공!: " + result);
					if(result === "joinSuccess") {
						alert("회원가입에 성공했습니다.");
						location.href="/";
					} else {
						alert("회원가입에 실패했습니다.");
					}
				}, //통신 성공 시 처리할 내용들을 익명함수 내부에 작성
				error: function() {
					console.log("통신 실패!");
				} //통신 실패 시 처리할 내용들을 익명함수 내부에 작성 (생략 가능)
				
			}); //ajax
		
		} else {
			alert("입력 정보를 다시 확인해 주세요.");
		}
		
		
	}); //signup-btn 이벤트 처리
	
}); //end jQuery



</script>









