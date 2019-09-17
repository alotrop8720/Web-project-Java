<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 04.03.2019
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>HomePage</title>
    <link rel="stylesheet" type="text/css" href="pages/css/menu_style.css?1">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
</head>

<nav class="topnav">
    <ul >
        <li><a href="${pageContext.request.contextPath}/index.jsp" >Home</a></li>
        <li><a href="" >Lists</a>
            <ul>
                <li><a href="/web_project-1.0/pages/projects.jsp">List projects</a></li>
                <li><a href="/web_project-1.0/pages/workers.jsp">List workers</a></li>
                <li><a href="/web_project-1.0/pages/tasks.jsp">List tasks</a></li>
            </ul>
        </li>
    </ul>
</nav>

<script>

</script>
</html>
