<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 20.03.2019
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Workers list</title>
    <link rel="stylesheet" type="text/css" href="css/menu_style.css?9">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/table_style.css">
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
<div>
    <span class="main_text_style">Table Worker</span>
    <table id="table_worker">
        <tr>
            <th>Surname</th>
            <th>Name</th>
            <th>Thrid name</th>
            <th>Post</th>
        </tr>
        <c:forEach items="${listWorker}" var="element">
            <tr>
                <td style="display: none;">${element.getId()}</td>
                <td>${element.getSurname()}</td>
                <td>${element.getName()}</td>
                <td>${element.getThrid_name()}</td>
                <td>${element.getPost()}</td>
                <td>
                    <form action="/web_project-1.0/pages/workers" method="post">
                        <input style="display: none" type="text" name="id" value="${element.getId()}"/>
                        <button type="submit"  class="button_delete button_style">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<button class="button button_style button_add_style" onclick="goToPageAddWorker()"> Add new WORKER</button>

<script src="JS/to_worker_link.js?1"></script>

</body>
</html>
