<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>スレッド内容</title>
</head>
<body>

<% jp.co.valtech.bulletinboard.model.thread.Thread thread = (jp.co.valtech.bulletinboard.model.thread.Thread)request.getAttribute("thread");%>
<% java.util.List<jp.co.valtech.bulletinboard.model.entry.Entry> entryList = thread.getEntrys();%>
<% for (jp.co.valtech.bulletinboard.model.entry.Entry entry : entryList) {%>
	<u>No:<%=entry.getSeq() %>&nbsp;ID:<%=entry.getId() %>&nbsp;タイトル:<%=entry.getHtmlTitle() %></u>
	<br/>
	<br/>
	<%=entry.getHtmlEntry() %>
	<hr/>
<% }%>

<form method="post" action="./create_entry">
	<input type="hidden" name="boardid"  value="<%=request.getAttribute("boardid") %>"/>
	<input type="hidden" name="threadid" value="<%=request.getAttribute("threadid") %>"/>
	<table border="1">
		<tr>
			<td>タイトル</td>
			<td><input type="text" name="title"/></td>
		</tr>
		<tr>
			<td>内容</td>
			<td><textarea name="entry" cols="20" rows="20"></textarea></td>
		</tr>
	</table>
	<input type="submit" value="書き込み"/>
</form>
</body>
</html>