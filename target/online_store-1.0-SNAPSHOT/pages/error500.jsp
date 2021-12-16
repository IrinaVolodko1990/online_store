<%--
  Created by IntelliJ IDEA.
  User: 82327
  Date: 14.12.2021
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>

<%--Request from: ${}<br/>--%>
Status code: ${pageContext.errorData.statusCode} <br/>
Exception: ${pageContext.exception}<br/>
Message from exception: ${pageContext.exception.message}<br/>
<a href="index.jsp">Back to index</a>
</body>
</html>
