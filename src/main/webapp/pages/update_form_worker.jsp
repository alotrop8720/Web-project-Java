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
    <title>Update WORKER</title>
    <link rel="stylesheet" type="text/css" href="css/menu_style.css?1">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/table_style.css?1">
    <link rel="stylesheet" href="css/form_style.css?2">
</head>
<body>
<span class="main_text_style">Worker form</span>
<form class="form_style" action="/web_project-1.0/pages/update_form_worker" method="post">
    <input style="display: none" type="text" name="id" value="${id_worker}"/>
    <label>Surname</label>
    <input type="text" name="surname_imp" value="${surname_worker}">

    <label>Name</label>
    <input type="text" name="name_imp" value="${name_worker}">

    <label>Third name</label>
    <input type="text" name="third_name_imp" value="${third_name_worker}">

    <label>Post</label>
    <select name="post_worker_imp" value="${post_worker}">
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

</body>
</html>
