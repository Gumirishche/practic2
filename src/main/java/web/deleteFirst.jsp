<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="practic4.First" %>
<html>
<head>
  <title>Delete First</title>
</head>
<body>
<h1>Table First</h1>
<table>
        <tHead>
            <tr>
                <th>ID</th>
                <th>ID human</th>
                <th>Salary</th>
                <th>Gender</th>
            </tr>
        </tHead>

        <%
        ArrayList<First> humans = (ArrayList) request.getAttribute("humans");
        %>
        <% for(First human : humans) { %>
        <tr>
        <td style="text-align:center"> <%= human.getId() %> </td>
        <td style="text-align:center"> <%= human.getIdHuman() %> </td>
        <td style="text-align:center"> <%= human.getSalary() %> </td>
        <td style="text-align:center"> <%= human.getGender() %> </td>
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