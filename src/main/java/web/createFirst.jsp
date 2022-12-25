<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="practic3.Human" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form method="post" action="createFirst">
       <input type="text" name="idHuman" placeholder="Введите idHuman" size="18" /><br><br>
       <input type="text" name="salary" placeholder="Введите salary" size="18" /><br><br>
       <input type="text" name="gender" placeholder="Введите gender" size="18" /><br><br>
       <input type="submit" value="Create!" />
</form>
<li>
<a href="/practic2/"> back </a>
</li>
</body>
</html>