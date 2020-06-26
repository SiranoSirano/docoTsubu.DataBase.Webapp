<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.User,model.Mutter,java.util.List" %>

public void init(Servlet config config)throws ServletException{
	super.inti(config);//
}

<%-- メイン画面を出力するビュー --%>

<%
//セッションスコープに保存されたユーザー情報を取得
User loginUser = (User) session.getAttribute("loginUser");

//アプリケーションスコープに保存されたつぶやきリストを取得
List<Mutter> mutterList =(List<Mutter>)application.getAttribute("mutterList");

//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶメイン</h1>
<p><%= loginUser.getName() %>さんはログイン中です
<a href ="/docoTsubu/Logout">ログアウト</a>
</p>

<p><a href="/docoTsubu/Main">更新</a></p>
<form action="/docoTsubu/Main" method ="post">
<input type="text" name ="text">
<input type ="submit" value="つぶやく" >
</form>
<%-- エラーメッセージerrorMsgがnullじゃないならerrorMsgを出力 --%>
<% if(errorMsg != null)  { %>
<p><%= errorMsg %><p>
<% } %>

</body>
</html>