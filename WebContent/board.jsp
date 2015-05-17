<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>スレッド一覧</title>
</head>
<body>
<table>
<% jp.co.valtech.bulletinboard.model.board.Board board = (jp.co.valtech.bulletinboard.model.board.Board)request.getAttribute("board");%>
<% java.util.List<jp.co.valtech.bulletinboard.model.thread.Thread> threadList = board.getThreads();%>
<% for (jp.co.valtech.bulletinboard.model.thread.Thread thread : threadList) {%>
	<tr>
		<td>
			<a href="./select_thread?boardid=<%=board.getBoardId() %>&threadid=<%=thread.getThreadId() %>"><%=thread.getTitle() %></a>
		</td>
	</tr>
<% }%>
</table>
<form method="post" action="./create_thread">
	タイトル:<input type="text" name="title"/>
	<input type="hidden" name="boardid" value="<%=board.getBoardId() %>"/>
	<input type="submit" value="作成"/>
</form>
</body>
</html>