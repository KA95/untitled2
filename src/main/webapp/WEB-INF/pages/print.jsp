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
    <title>PRINT</title>
</head>
<body>
<h1>PRINT</h1>

<form action="/print" method="post">
  <p>Team id: <input type="text" name="teamId" /></p>
  <p style="vertical-align: top">Source: <textarea rows="80" cols="80" name="text" wrap="hard"></textarea></p>
  <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
</form>

</body>
</html>
