<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 21.05.2015
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>your submission id: ${submission.id}</p>
<p>your team: ${submission.team.name}</p>
<p><textarea rows="80" cols="80" readonly>${submission.text}</textarea></p>
</body>
</html>
