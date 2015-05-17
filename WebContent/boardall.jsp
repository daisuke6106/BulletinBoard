<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>スレッド一覧</title>
</head>
<body>
<table>
<% java.util.List<jp.co.valtech.bulletinboard.model.board.Board> boardList = (java.util.List<jp.co.valtech.bulletinboard.model.board.Board>)request.getAttribute("boardall");%>
<% for (jp.co.valtech.bulletinboard.model.board.Board board : boardList) {%>
	<tr>
		<td>
			<a href="./select_board?boardid=<%=board.getBoardId() %>"><%=board.getTitle() %></a>
		</td>
	</tr>
<% }%>
</table>
</body>
</html>