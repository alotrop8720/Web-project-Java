<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 12.03.2019
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Projects list</title>
    <link rel="stylesheet" type="text/css" href="css/menu_style.css?9">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/table_style.css">
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
    <div>
        <span class="main_text_style">Table Project</span>
        <table id="table_project">
            <tr>
                <th>Title</th>
                <th>Abbreviate</th>
                <th>Information</th>
            </tr>
            <c:forEach items="${listProject}" var="element">
                <tr>
                    <td style="display: none;">${element.getId()}</td>
                    <td>${element.getTitle()}</td>
                    <td>${element.abbreviate}</td>
                    <td>${element.information}</td>
                    <td>
                        <form action="/web_project-1.0/pages/projects" method="post">
                        <input style="display: none" type="text" name="id" value="${element.getId()}"/>
                        <button type="submit"  class="button_delete button_style">Delete</button>
                    </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <button class="button button_style button_add_style" onclick="goToPageAddProject()"> Add new PROJECT</button>

    <script src="JS/to_project_link.js?4"></script>
</body>
</html>
