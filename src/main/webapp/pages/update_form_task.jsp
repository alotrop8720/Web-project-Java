<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 26.03.2019
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update TASK</title>
    <link rel="stylesheet" type="text/css" href="css/menu_style.css?1">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/table_style.css?1">
    <link rel="stylesheet" href="css/form_style.css?2">
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
<div>
    <span class="main_text_style">Worker form</span>
    <form class="form_style" action="/web_project-1.0/pages/update_form_task" method="post">
        <input style="display: none;" type="text" name="id" value="${id}"/>
        <label>Title</label>
        <input type="text" name="title" value="${title}"/>

        <label>Time</label>
        <input type="text" name="time" value="${time}"/>

        <label>Date start</label>
        <input type="date" name="start" value="${start_1}"/>

        <label>Date finish</label>
        <input type="date" name="finish" value="${finish}"/>

        <label>Status</label>
        <select name="status" value="${status}">
            <option>in progress</option>
            <option>unbegun</option>
            <option>finish</option>
        </select>



        <label>Worker</label>
        <input style="display: none;" type="text" name="id_w" value="${id_w}"/>
        <select name="worker">
            <option>${surname}</option>
            <c:forEach items="${listWorker}" var="element">
                <option>${element.getSurname()} ${element.getName()}</option>
            </c:forEach>
        </select>



        <label>Project</label>
        <input style="display: none;" type="text" name="id_p" value="${id_p}"/>
        <select name="project">
            <option>${title_p}</option>
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
