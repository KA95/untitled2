<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 21.05.2015
  Time: 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIST</title>
</head>

<body>
<h1>LIST</h1>
<c:if test="${!empty teams}">
  <table class="data">
    <tr>
      <th>id</th>
      <th>name</th>
    </tr>
    <c:forEach items="${teams}" var="team">
      <tr>
        <td>${team.id}</td>
        <td>${team.name}</td>
        <td><a href="delete/${team.id}">delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<form  method="POST" action="/admin/add">
  <table>
    <tr>
      <td>Type team name:</td>
      <td><input type="text" name="name"/></td>
    </tr>
    <tr align="center">
      <td colspan="2"><input type="submit" value="Add"/></td>
    </tr>
  </table>
</form>
</body>
</html>
