<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>


<%-- メイン画面を出力するビュー --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p>
<c:out value ="${loginUser.name}" />さんはログイン中です
<a href ="/docoTsubu/Logout">ログアウト</a>
</p>

<p><a href="/docoTsubu/Main">更新</a></p>
<form action="/docoTsubu/Main" method ="post">
<input type="text" name ="text">
<input type ="submit" value="つぶやく" >
</form>
<%-- エラーメッセージerrorMsgがnullじゃないならerrorMsgを出力 --%>

<c:if test ="${not empty errorMsg}">
	<p>${erorMsg}</p>
</c:if>
<%-- 配列を回す、拡張for文 --%>
<c:forEach var= "mutter" items = "${mutterList}">
  <p> <c:out value="{mutter.userName}" />:
  	<c:out value = "${mutter.text}" /></p>
</c:forEach>

</body>
</html>