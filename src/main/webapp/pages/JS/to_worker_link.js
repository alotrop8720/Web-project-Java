function goToPageAddWorker()
{
    document.location.href = "/web_project-1.0/pages/add_form_worker.jsp";
}

function goToPageListWorker()
{
    document.location.href = "/web_project-1.0/pages/workers.jsp";
}

document.getElementById('table_worker').onclick = function (ev)
{
    var r, c, el;
    ev = ev || event;
    el = ev.target || event.srcElement;
    r= el.parentNode.rowIndex || el.parentElement.rowIndex;
    c= el.cellIndex;
    el=document.getElementById('table_worker')

    var id = el.rows[r].cells[0].innerHTML;
    var surname = el.rows[r].cells[1].innerHTML;
    var name = el.rows[r].cells[2].innerHTML;
    var third_name = el.rows[r].cells[3].innerHTML;
    var post = el.rows[r].cells[4].innerHTML;
    document.location.href = "/web_project-1.0/pages/update_form_worker.jsp?id="+ id +"&surname="+ surname +"&name="+ name +"&third_name="+ third_name +"&post="+ post;
}