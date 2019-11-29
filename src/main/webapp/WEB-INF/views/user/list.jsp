<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/res/bt/js/jquery-3.4.1.min.js"></script>
<script src="/res/bt/js/bootstrap.min.js"></script>
<script src="/res/bt/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="/res/bt/css/bootstrap.min.css" />
<link rel="stylesheet" href="/res/bt/css/bootstrap-reboot.min.css" />
<link rel="stylesheet" href="/res/bt/css/bootstrap-grid.min.css" />
</head>
<body>
	<h1 align="center">USER LIST</h1>
	<div class="search">
		<label for="uiName">이름</label> <input type="checkbox" id="uiName"
			name="search" value="ui_name"> <label for="uiNum">번호</label>
		<input type="checkbox" id="uiNum" name="search" value="ui_num">
		<label for="uiId">아이디</label> <input type="checkbox" id="uiId"
			name="search" value="ui_id"> <input type="text"
			id="searchStr">
		<button>검색</button>
	</div>
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>생성날짜</th>
			<th>생성시간</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<tbody id="tBody">

			<c:forEach items="${List}" var="list">
				<tr>
					<td>${list.uiNum}</td>
					<td>${list.uiName}</td>
					<td>${list.uiId}</td>
					<td>${list.credat}</td>
					<td>${list.cretim}</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<button onclick="showBtn()">가입</button>
	<div id="rDiv"></div>
	<script>
		function getUserList(param) {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/user/list/ajax?' + param);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == xhr.DONE) {
					if (xhr.status == 200) {
						var list = JSON.parse(xhr.responseText);
						var html = '';
						for ( var i in list) {
							html += '<tr>';
							html += '<td>' + list[i].uiNum + '</td>';
							html += '<td>' + list[i].uiName + '</td>';
							html += '<td>' + list[i].uiId + '</td>';
							html += '<td>' + list[i].credat + '</td>';
							html += '<td>' + list[i].cretim + '</td>';
							html += '<td><button onclick="upShowBtn(' + i + ')">수정</button></td>';
							html += '<td><button onclick="deleteBtn('+ list[i].uiNum + ')">삭제</button></td>';
							html += '</tr>';
						}
						document.querySelector('#tBody').innerHTML = html;
					}
				}
			}
			xhr.send();
		}

		window.onload = function() {

			getUserList('');
			var btn = document.querySelector('button');
			btn.onclick = function() {
				var checks = document.querySelectorAll('[name=search]:checked');
				if (checks.length == 0) {
					alert('검색 대상을 한개 이상 선택해 주세요');
					return;
				}
				var searchStr = document.querySelector('#searchStr');
				if (searchStr.value.trim().length < 1) {
					alert('검색어를 입력해주세요');
					return;
				}

				var search = '';
				for (var i = 0; i < checks.length; i++) {
					search += 'search=' + checks[i].value + '&';
				}
				search += 'searchStr=' + searchStr.value;
				getUserList(search);
			}
		}

		function showBtn() {
			var html = '';
			html += '이름 : <input type="text" id="insertName" placeholder="이름">';
			html += '아이디 : <input type="text" id="insertId" placeholder="아이디">';
			html += '비밀번호 : <input type="text" id="insertPwd" placeholder="비밀번호">';
			html += '<button onclick="insertBtn()">회원가입</button>'
			document.querySelector('#rDiv').innerHTML = html;
		}

		function insertBtn() {
			var param = {
				uiName : document.querySelector('#insertName').value,
				uiId : document.querySelector('#insertId').value,
				uiPwd : document.querySelector('#insertPwd').value
			}
			console.log(param);
			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/user/list/ajax');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == xhr.DONE) {
					if (xhr.status == 200) {
						alert('가입이 완료 되었습니다');
						document.querySelector('#rDiv').innerHTML = '';
						getUserList('');
					}
				}
			}
			xhr.send(JSON.stringify(param));
		}

		function upShowBtn(num) {
			var xhr = new XMLHttpRequest();
			xhr.open('GET', '/user/list/ajax');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == xhr.DONE) {
					if (xhr.status == 200) {
						var list = JSON.parse(xhr.responseText);
						var html = '';
						for ( var i in list) {
							if (i == num) {
								html += '<tr>';
								html += '<td>' + list[i].uiNum + '</td>';
								html += '<td><input type="text" id="updateName" value="' + list[i].uiName + '"></td>';
								html += '<td><input type="text" id="updateId" value="' + list[i].uiId + '"></td>';
								html += '<td>' + list[i].credat + '</td>';
								html += '<td>' + list[i].cretim + '</td>';
								html += '<td><button onclick="updateBtn('+ list[i].uiNum + ')">확인</button></td>';
								html += '<td><button onclick="getUserList()">취소</button></td>';
								html += '</tr>';
							} else {
								html += '<tr>';
								html += '<td>' + list[i].uiNum + '</td>';
								html += '<td>' + list[i].uiName + '</td>';
								html += '<td>' + list[i].uiId + '</td>';
								html += '<td>' + list[i].credat + '</td>';
								html += '<td>' + list[i].cretim + '</td>';
								html += '<td><button onclick="upShowBtn('+ list[i].uiNum + ')">수정</button></td>';
								html += '<td><button onclick="deleteBtn('
										+ list[i].uiNum + ')">삭제</button></td>';
								html += '</tr>';
							}
						}
						document.querySelector('#tBody').innerHTML = html;
					}
				}
			}
			xhr.send();
		}

		function updateBtn(un) {
			var xhr = new XMLHttpRequest();
			var param = {
					uiName : document.querySelector('#updateName').value,
					uiId : document.querySelector('#updateId').value,
					uiNum : un
			}
			xhr.open('PUT', '/user/list/ajax');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == xhr.DONE) {
					if (xhr.status == 200) {
						alert('수정이 완료 되었습니다');
						getUserList('');
					}
				}

			}
			xhr.send(JSON.stringify(param));
		}

		function deleteBtn(un) {
			var param = {
				uiNum : un
			}
			console.log(param);
			var xhr = new XMLHttpRequest();
			xhr.open('DELETE', '/user/list/ajax');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == xhr.DONE) {
					if (xhr.status == 200) {
						alert('삭제가 완료 되었습니다');
						getUserList('');
					}
				}

			}
			xhr.send(JSON.stringify(param));
		}
	</script>
</body>
</html>