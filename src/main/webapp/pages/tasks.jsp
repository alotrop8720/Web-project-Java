<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 21.03.2019
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tasks list</title>
    <link rel="stylesheet" type="text/css" href="css/menu_style.css?9">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/table_style.css">
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
<div>
    <span class="main_text_style">Table Task</span>
    <table id="table_task">
        <tr>
            <th>Title</th>
            <th>Time</th>
            <th>Start</th>
            <th>Finish</th>
            <th>Status</th>
            <th>Project</th>
            <th>Worker</th>
        </tr>
        <c:forEach items="${listTask}" var="element">
            <tr>
                <td style="display: none;">${element.getTask().getId()}</td>
                <td>${element.getTask().getTitle()}</td>
                <td>${element.getTask().getTime()}</td>
                <td>${element.getTask().getStart()}</td>
                <td>${element.getTask().getFinish()}</td>
                <td>${element.getTask().getStatus()}</td>
                <td style="display: none;">${element.getTask().getProject().getId()}</td>
                <td>${element.getTask().getProject().getTitle()}</td>
                <td style="display: none;">${element.getWorker().getId()}</td>
                <td>${element.getWorker().getSurname()}</td>
                <td>
                    <form action="/web_project-1.0/pages/tasks" method="post">
                        <input style="display: none" type="text" name="id" value="${element.getTask().getId()}"/>
                        <button type="submit"  class="button_delete button_style">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<button class="button button_style button_add_style" onclick="goToPageAddTask()"> Add new PROJECT</button>

<script src="JS/to_task_link.js"></script>

</body>
</html>
