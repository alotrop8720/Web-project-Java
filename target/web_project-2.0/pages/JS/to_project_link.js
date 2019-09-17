

function goToPageAddProject()
{
    document.location.href = "/web_project-1.0/pages/add_form_project.jsp";
}


function goToPageListProject()
{
    document.location.href = "/web_project-1.0/pages/projects.jsp";
}


document.getElementById('table_project').onclick = function (ev)
{
    var r, c, el;
    ev = ev || event;
    el = ev.target || event.srcElement;
    r= el.parentNode.rowIndex || el.parentElement.rowIndex;
    c= el.cellIndex;
    el=document.getElementById('table_project')

    var id = el.rows[r].cells[0].innerHTML;
    var title = el.rows[r].cells[1].innerHTML;
    var abbreviate = el.rows[r].cells[2].innerHTML;
    var information = el.rows[r].cells[3].innerHTML;
    document.location.href = "/web_project-1.0/pages/update_form_project.jsp?id="+ id +"&title="+ title +"&abbrev="+ abbreviate +"&inf=" + information;
}


