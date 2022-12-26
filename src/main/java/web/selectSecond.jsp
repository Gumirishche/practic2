<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="practic4.Second" %>
<html>
<head>
  <title>Second</title>
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
        Second human = (Second) request.getAttribute("human");
        %>
        <tr>
        <td style="text-align:center"> <%= human.getId() %> </td>
        <td style="text-align:center"> <%= human.getFirstName() %> </td>
        <td style="text-align:center"> <%= human.getLastName() %> </td>
        <tr>
</table>

<li>
<a href="findSecond"> insert id </a>
<br></br>
<a href="/practic2/"> back </a>
</li>
</body>
</html>