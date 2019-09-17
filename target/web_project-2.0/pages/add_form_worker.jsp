<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 20.03.2019
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add WORKER</title>
    <link rel="stylesheet" type="text/css" href="css/menu_style.css">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/table_style.css?3">
    <link rel="stylesheet" href="css/form_style.css?3">
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
<div>
    <span class="main_text_style">Worker form</span>
    <form class="form_style" action="/web_project-1.0/pages/add_form_worker" method="post">
        <label>Surname</label>
        <input type="text" name="surname">

        <label>Name</label>
        <input type="text" name="name">

        <label>Third name</label>
        <input type="text" name="third_name">

        <label>Post</label>
        <select name="post_worker">
            <option>Junior</option>
            <option>Middle</option>
            <option>Senior</option>
        </select>
        <div class="contener_buttons">
            <button type="submit" class="button button_style">Save</button>
            <button type="reset" class="button button_style" onclick="goToPageListWorker()">Cancel</button>
        </div>
    </form>

    <script src="JS/to_worker_link.js"></script>
</div>
</body>
</html>
