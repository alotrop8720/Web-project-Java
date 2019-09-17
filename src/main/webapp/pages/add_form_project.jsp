<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 14.03.2019
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add PROJECT</title>
    <link rel="stylesheet" type="text/css" href="css/menu_style.css?2">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/table_style.css?1">
    <link rel="stylesheet" href="css/form_style.css">
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
<div>
    <span class="main_text_style">Project form</span>
    <form class="form_style" action="/web_project-1.0/pages/add_form_project" method="post">
        <label>Title project</label>
        <input type="text" name="title_project">

        <label>Abbreviated title project</label>
        <input type="text" name="abbreviated">

        <label>Information project</label>
        <textarea name="information" cols="20" rows="5"></textarea>
        <div class="contener_buttons">
            <button type="submit" class="button button_style">Save</button>
            <button type="reset" class="button button_style" onclick="goToPageListProject()">Cancel</button>
        </div>
    </form>

    <script src="JS/to_project_link.js"></script>
</div>
</body>
</html>
