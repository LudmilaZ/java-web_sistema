<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<fmt:bundle basename="locale">
<nav>
    <div id="divNav" class="row">
        <a id="home" href="/" class="nav">
            <button type="button" class="btn btn-outline-secondary btn-sm"><fmt:message key="button_back_homepage"/></button>
        </a>
    </div>
</nav>
<div id="container">
    <c:if test="${role eq 1}">
        <section>
            <div id="divStudentsList1" class="row">
                <div class="col-sm-6">
                    <a onclick="progStudent()">
                        <button id="button1" type="button" class="btn btn-outline-secondary btn-lg btn-block"><fmt:message key="view_progress_strudent"/>
                        </button>
                    </a>
                </div>
                <div class="col-sm-6">
                    <a href="/students-create">
                        <button type="button" class="btn btn-outline-secondary btn-lg btn-block"><fmt:message key="create_student"/>
                        </button>
                    </a>
                </div>
            </div>
            <div id="divStudentsList2" class="row">
                <div class="col-sm-6">
                    <a onclick="modifyStudent()">
                        <button id="button3" type="button" class="btn btn-outline-secondary btn-lg btn-block">
                            <fmt:message key="modify_student"/>
                        </button>
                    </a>
                </div>
                <div class="col-sm-6">
                    <a onclick="deleteStudent()">
                        <button type="button" class="btn btn-outline-secondary btn-lg btn-block">   <fmt:message key="delete_student"/>
                        </button>
                    </a>
                </div>
            </div>
        </section>
    </c:if>
    <section id="sectionTable">
        <%--                <th scope="col">Список студентов</th>--%>
        <table id="table" class="table table-bordered table table-hover">
            <thead>
            <tr>
                <c:if test="${role eq 1}">
                    <th scope="col">#</th>
                </c:if>

                <th scope="col"><fmt:message key="surname"/></th>
                <th scope="col"><fmt:message key="name"/></th>
                <th scope="col"><fmt:message key="group"/></th>
                <th scope="col"><fmt:message key="date_recipt"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${student}" var="s" varStatus="i">
                <c:if test="${s.surname.length() > 0}">
                    <tr>
                        <c:if test="${role eq 1}">
                            <th scope="row">
                                <div class="custom-control custom-checkbox">
                                    <input type="checkbox" value="${s.id}" class="custom-control-input"
                                           id="cbx${i.count}">
                                    <label class="custom-control-label" for="cbx${i.count}"></label>
                                </div>
                            </th>
                        </c:if>

                            <%--                        <th scope="row">1</th>--%>
                        <td>${s.surname}</td>
                        <td>${s.name}</td>
                        <td>${s.nomber_grup}</td>
                        <td><fmt:formatDate value="${s.date_aprobarse}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                    </tr>
                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </section>
</div>
</fmt:bundle>

<form id="formStudentModify" method="get" action="/studentsModifying">
    <input type="hidden" id="idModifyStud" name="idModifyStud">
</form>
<form id="formProgModify" method="get" action="/studentsProgress">
    <input type="hidden" id="idProgStud" name="idProgStud">
</form>

<form id="formDeleteStudent" method="post" action="/studentsList">
    <input type="hidden" id="idsDeleteStud" name="idsDeleteStud" value="">
</form>