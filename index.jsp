<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- トップ画面を出力するビュー --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<form action="/docoTsubu/Login" method = "post">
ユーザー名:<input type="text" name ="name"><br>
パスワード:<input type="password" name ="pass"><br>
<input type ="submit" value="ログイン">
</form>
</body>
</html>