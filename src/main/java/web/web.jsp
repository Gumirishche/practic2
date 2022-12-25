<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="practic3.Human" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Table</h1>
<Fieldset>
<table>
        <tHead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Salary</th>
                <th>Gender</th>
            </tr>
        </tHead>

        <%
        ArrayList<Human> humans = (ArrayList) request.getAttribute("humans");
        %>
        <% for(Human human : humans) { %>
        <tr>
        <td style="text-align:center"> <%= human.getId() %> </td>
        <td style="text-align:center"> <%= human.getFirstName() %> </td>
        <td style="text-align:center"> <%= human.getLastName() %> </td>
        <td style="text-align:center"> <%= human.getSalary() %> </td>
        <td style="text-align:center"> <%= human.getGender() %> </td>
        <tr>
        <% } %>
</table>
</Fieldset>
<li>
<br><br>
<a href="createFirst"> Create First </a><br><br>
<a href="createSecond"> Create Second </a><br><br>
<a href="deleteFirst"> Delete First </a><br><br>
<a href="deleteSecond"> Delete Second </a><br><br>
<a href="findFirst"> Find first </a><br><br>
</li>
</body>
</html>