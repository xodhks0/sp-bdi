<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/common/head.jsp" />
<style>
div.container {
	height: 200px;
	width: 500px;
	border: 1px solid #ab1100;
}
</style>
</head>
<body>
	<div class="container" id="loginForm">
		<script>
			window.onload = function() {
				var dhWin = new dhx.Window({
					width : 500,
					height : 200,
					title : 'Login'
				});
				//	dhWin.show();
				var form = new dhx.Form("loginForm", {
					cellCss : "dhx_widget--bordered",
					rows : [ {
						type : "input",
						label : "아이디",
						icon : "dxi dxi-magnify",
						placeholder : "아이디를 넣어주세요",
						id : "uiId"
					}, {
						type : "input",
						inputType : "password",
						label : "Password",
						placeholder : "비밀번호를 적어주세요",
						id : "uiPwd"
					}, {
						type : "button",
						value : "Send",
						size : "medium",
						view : "flat",
						submit : true,
						color : "primary",
						id : "loginBtn"
					}, ]
				});
				form.events.on("ButtonClick", function(id, e) {
					if (id === 'loginBtn') {
						doLogin();
					}
				});

			}
			function doLogin() {
				var param = {
					uiId : document.querySelector('#uiId').value,
					uiPwd : document.querySelector('#uiPwd').value
				}
				var xhr = new XMLHttpRequest();
				xhr.open('POST', '/user/login');
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.onreadystatechange = function() {
					if (xhr.readyState == xhr.DONE) {
						if (xhr.status == 200) {
							if (xhr.responseText) {
								var user = JSON.parse(xhr.responseText);
								alert(user.uiName + '님 반갑습니다.');
								location.href = '/views/userinfo/list';
							}
						}
					}
				}
				xhr.send(JSON.stringify(param));
			}
		</script>
</body>
</html>