<%--
  Created by IntelliJ IDEA.
  User: Sveta
  Date: 14.03.2019
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update PROJECT</title>
    <link rel="stylesheet" type="text/css" href="css/menu_style.css?1">
    <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
    <link rel="stylesheet" href="css/table_style.css?5">
    <link rel="stylesheet" href="css/form_style.css?3">
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>
<div>
    <span class="main_text_style">Project form</span>
    <form class="form_style" action="/web_project-1.0/pages/update_form_project" method="post">
        <input style="display: none" type="text" name="id" value="${old_project_id}"/>
        <label>Title project</label>
        <input type="text" name="title_project_imp" value="${title_project}">

        <label>Abbreviated title project</label>
        <input type="text" name="abbreviated_imp" value="${abbreviated}"/>

        <label>Information project</label>
        <textarea name="information_imp" cols="20" rows="5">${information}</textarea>
        <div class="contener_buttons">
            <button type="submit" class="button button_style">Save</button>
            <button type="reset" class="button button_style" onclick="goToPageListProject()">Cancel</button>
        </div>
    </form>



    <script src="JS/to_project_link.js?1"></script>
</div>
</body>
</html>
