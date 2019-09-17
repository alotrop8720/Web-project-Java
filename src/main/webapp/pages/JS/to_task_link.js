function goToPageAddTask()
{
    document.location.href = "/web_project-1.0/pages/add_form_task.jsp";
}

function goToPageListTask()
{
    document.location.href = "/web_project-1.0/pages/tasks.jsp";
}

document.getElementById('table_task').onclick = function (ev)
{
    var r, c, el;
    ev = ev || event;
    el = ev.target || event.srcElement;
    r= el.parentNode.rowIndex || el.parentElement.rowIndex;
    c= el.cellIndex;
    el=document.getElementById('table_task')

    var id = el.rows[r].cells[0].innerHTML;
    var title = el.rows[r].cells[1].innerHTML;
    var time = el.rows[r].cells[2].innerHTML;
    var start = el.rows[r].cells[3].innerHTML;
    var finish = el.rows[r].cells[4].innerHTML;
    var status = el.rows[r].cells[5].innerHTML;
    var id_p = el.rows[r].cells[6].innerHTML;
    var title_p = el.rows[r].cells[7].innerHTML;
    var id_w = el.rows[r].cells[8].innerHTML;
    var surname = el.rows[r].cells[9].innerHTML;
    document.location.href = "/web_project-1.0/pages/update_form_task.jsp?id="
        + id +"&title="+ title +"&time="+ time +"&start="+ start +"&finish="+ finish +
        "&status="+ status +"&id_w="+ id_w +"&surname="+ surname +"&id_p="+ id_p +"&title_p="+ title_p;
}