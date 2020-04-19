<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:bundle basename="locale">
<nav>
    <div id="divNav" class="row">
        <a id="home" href="/" class="nav">
            <button type="button" class="btn btn-outline-secondary btn-sm"><fmt:message key="button_back_homepage"/></button>
        </a>
        <%-- <a id="studentsList" href="studentsList.jsp" class="nav">
             <button type="button" class="btn btn-outline-secondary btn-sm">Назад</button>
         </a>--%>
    </div>
</nav>
<div id="container">
    <section>
        <div id="titleDisciplinesList" class="row">
            <h5><fmt:message key="titleDisciplinesList"/></h5>
        </div>
    </section>
    <section id="sectionBody">
        <div class="row">
            <div class="col-sm-7">
                <table id="table" class="table table-bordered table table-hover">
                    <thead>
                    <tr>
                        <c:if test="${role eq 1}">
                            <th scope="col">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" class="custom-control-input" id="cbxAll">
                                </div>
                            </th>
                        </c:if>
                        <th scope="col"><fmt:message key="name_discipline"/></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${disces}" var="d" varStatus="i">
                        <c:if test="${d.discipline.length() > 0}">

                            <tr>

                                <c:if test="${role eq 1}">
                                    <th scope="row">
                                        <div class="custom-control custom-checkbox">
                                            <input type="checkbox" value="${d.id}" class="custom-control-input"
                                                   id="cbx${i.count}"
                                                   required>
                                            <label class="custom-control-label" for="cbx${i.count}"></label>
                                        </div>
                                    </th>
                                </c:if>


                                <td>${d.discipline}</td>
                            </tr>
                        </c:if>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
            <c:if test="${role eq 1}">
                <div class="col-sm-5">
                    <section>
                        <div id="divDisciplineList1" class="row">
                            <div class="divDisciplineList col-sm-12">
                                <a href="/discipline-create">
                                    <button id="button1" type="button"
                                            class="btn btn-outline-secondary btn-lg btn-block">
                                        <fmt:message key="create_disciplina"/>
                                    </button>
                                </a>
                            </div>
                        </div>
                        <div id="divDisciplineList2" class="row">
                            <div class="divDisciplineList col-sm-12">
                                <a onclick="modifyDisciplina()">
                                    <button id="button2" type="button"
                                            class="btn btn-outline-secondary btn-lg btn-block">
                                        <fmt:message key="modify_disciplina"/>
                                    </button>
                                </a>
                            </div>
                        </div>
                        <div id="divDisciplineList3" class="row">
                            <div class="divDisciplineList col-sm-12">
                                <a onclick="deleteDisciplina()">
                                    <button id="button3" type="button"
                                            class="btn btn-outline-secondary btn-lg btn-block">
                                        <fmt:message key="delete_disciplia"/>
                                    </button>
                                </a>
                            </div>
                        </div>
                    </section>
                </div>
            </c:if>
        </div>
    </section>
</div>
</fmt:bundle>
<form id="formDisciplinaModify" method="get" action="/disciplineModifying">
    <input type="hidden" id="idModifyDisc" name="idModifyDisc">
</form>

<form id="formDeleteDisciplina" method="post" action="/disciplines">
    <input type="hidden" id="idsDeleteDisc" name="idsDeleteDisc" value="">
</form>