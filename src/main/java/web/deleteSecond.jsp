<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="practic4.Second" %>
<html>
<head>
  <title>Delete Second</title>
</head>
<body>
<h1>Table Second</h1>
<table>
        <tHead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
        </tHead>

        <%
        ArrayList<Second> humans = (ArrayList) request.getAttribute("humans");
        %>
        <% for(Second human : humans) { %>
        <tr>
        <td style="text-align:center"> <%= human.getId() %> </td>
        <td style="text-align:center"> <%= human.getFirstName() %> </td>
        <td style="text-align:center"> <%= human.getLastName() %> </td>
        <tr>
        <% } %>
</table>
<form method="post">
       <input type="text" name="id" placeholder="Введите id" size="18" /><br><br>
       <input type="submit" value="Delete!" />
</form>
<li>
<a href="/practic2/"> back </a>
</li>
</body>
</html>