<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="practic4.First" %>
<html>
<head>
  <title>First</title>
</head>
<body>
<h1>First</h1>
<table>
        <tHead>
            <tr>
                <th>ID</th>
                <th>ID Human</th>
                <th>Salary</th>
                <th>Gender</th>
            </tr>
        </tHead>

        <%
        First human = (First) request.getAttribute("human");
        %>
        <tr>
        <td style="text-align:center"> <%= human.getId() %> </td>
        <td style="text-align:center"> <%= human.getIdHuman() %> </td>
        <td style="text-align:center"> <%= human.getSalary() %> </td>
        <td style="text-align:center"> <%= human.getGender() %> </td>
        <tr>
</table>

<li>
<a href="findFirst"> insert id </a>
<br></br>
<a href="/practic2/"> back </a>
</li>
</body>
</html>