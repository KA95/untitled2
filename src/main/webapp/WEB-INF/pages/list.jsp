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
  <style type="text/css">
    span,input {
      width: 100px;
    }
    .inline {
      display: inline-block;
    }
  </style>
</head>

<body>
<h1>LIST</h1>

<c:if test="${!empty teams}">
  <div class="data">
    <div>
      <span>id</span>
      <span>name</span>
    </div>
    <c:forEach items="${teams}" var="team">
      <div>
        <form action="/admin/update" method="post">
        <input type="text" name="id" value="${team.id}" readonly/>
        <input type="text" name="name" value="${team.name}" />
        <a href="delete/${team.id}">delete</a>
        <input type="submit" value="update">
        </form>
      </div>
    </c:forEach>
  </div>
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
