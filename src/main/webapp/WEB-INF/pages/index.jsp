<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <div>
            <h1>Home</h1>
            <sec:authorize access="isAnonymous()">
                <p>
                    <a href="/login">Sign In</a>
                </p>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <p>
                    Hello, ${userDetails.username}!
                    <a href="/logout">Log Out</a>
                </p>
            </sec:authorize>
            <p>
                <a href="/print">Print</a>
            </p>
            <sec:authorize access="hasRole('ROLE_ADMINISTRATOR')">
                <p>
                    <a href="/admin">Admin page</a>
                </p>
            </sec:authorize>
        </div>
    </body>
</html>