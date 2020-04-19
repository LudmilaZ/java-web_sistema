function modifyDisciplina() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Please select a discipline");
        return;
    }
    if (items.length >1) {
        alert("Please select just one discipline");
        return;
    }

    var idDisciplina = $(items[0]).attr("value");
    $('#idModifyDisc').val(idDisciplina);
    $('#formDisciplinaModify').submit();

}


function modifyStudent(){
    var items =$("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Please select a student");
        return;
    }
    if (items.length >1) {
        alert("Please select just one student");
        return;
    }

    var idStudent = $(items[0]).attr("value");
    $('#idModifyStud').val(idStudent);
    $('#formStudentModify').submit();
}

function progStudent(){
    var items =$("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Please select a student");
        return;
    }
    if (items.length >1) {
        alert("Please select just one student");
        return;
    }

    var idStudent = $(items[0]).attr("value");
    $('#idProgStud').val(idStudent);
    $('#formProgModify').submit();
}

function deleteDisciplina() {
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Please select at least one discipline");
        return;
    }
   var ids;
    for(var i = 0; i < items.length; i++){
        if(ids == null){
            ids = "'" + $(items[i]).attr("value");
        }else{
            ids = ids + "','" + $(items[i]).attr("value");
        }
        if(i == items.length - 1){
            ids = ids + "'";
        }
    }




    $('#idsDeleteDisc').val(ids);
    $('#formDeleteDisciplina').submit();

}

function deleteStudent(){
    var items = $("input[type=checkbox]:checked");
    if (items.length == 0) {
        alert("Please select at least one student");
        return;
    }
    var ids;
    for(var i = 0; i < items.length; i++){
        if(ids == null){
            ids = "'" + $(items[i]).attr("value");
        }else{
            ids = ids + "','" + $(items[i]).attr("value");
        }
        if(i == items.length - 1){
            ids = ids + "'";
        }
    }




    $('#idsDeleteStud').val(ids);
    $('#formDeleteStudent').submit();
}
function CreateTerm() {
    var len= document.getElementById("formControlSelect").options.length;

    var ids;
    for (var n = 0; n < len; n++)
    {
        if (document.getElementById("formControlSelect").options[n].selected==true)
        {

            if(ids == null){
                ids = "'" + document.getElementById("formControlSelect").options[n].value;
            }else{
                ids = ids + "','" + document.getElementById("formControlSelect").options[n].value;
            }

        }

    }
    if (ids !=null){
        ids = ids + "'";
    }

    $('#idsCreatingTerm').val(ids);
    $('#formCreatingTerm').submit();

}

function SelectLanguage() {
    var  ids =  document.getElementById("language_page").value;
    $('#duble_language_page').val(ids);
    $('#formSelectLanguage').submit();
    document.location.reload();
}


