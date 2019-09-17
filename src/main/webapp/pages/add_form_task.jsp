<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 22.03.2019
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add TASK</title>
    <link rel="stylesheet" type="text/css" href="css/menu_style.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/table_style.css?6">
    <link rel="stylesheet" href="css/form_style.css?6">
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
<div>
    <span class="main_text_style">Worker form</span>
    <form class="form_style" action="/web_project-1.0/pages/add_form_task" method="post">
        <label>Title</label>
        <input type="text" name="title">

        <label>Time</label>
        <input type="text" name="time">

        <label>Date start</label>
        <input type="date" name="start"/>

        <label>Date finish</label>
        <input type="date" name="finish"/>

        <label>Status</label>
        <select name="status">
            <option>in progress</option>
            <option>unbegun</option>
            <option>finish</option>
        </select>

        <label>Worker</label>
        <select name="worker">
            <c:forEach items="${listWorker}" var="element">
                <option>${element.getSurname()} ${element.getName()}</option>
            </c:forEach>
        </select>

        <label>Project</label>
        <select name="project">
            <c:forEach items="${listProject}" var="element">
                <option>${element.getTitle()} ${element.getAbbreviate()}</option>
            </c:forEach>
        </select>


        <div class="contener_buttons">
            <button type="submit" class="button button_style">Save</button>
            <button type="reset" class="button button_style" onclick="goToPageListWorker()">Cancel</button>
        </div>
    </form>

    <script src="JS/to_worker_link.js?3"></script>
</div>
</body>
</html>
