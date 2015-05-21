<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</body>
</html>
