<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<fmt:bundle basename="locale">
<div id="divNav" class="row">
    <a id="home" href="/" class="nav">
        <button type="button" class="btn btn-outline-secondary btn-sm"><fmt:message key="button_back_homepage"/></button>
    </a>
    <a id="studentsList" href="/studentsList" class="nav">
        <button type="button" class="btn btn-outline-secondary btn-sm"><fmt:message key="button_back"/></button>
    </a>
</div>
</nav>
<div id="container">
    <section>
        <div id="titleStudentProgress" class="row">
            <h4><fmt:message key="progrecces_student"/></h4>
        </div>
    </section>
    <section id="sectionTable">
        <h5><fmt:message key="list_students"/></h5>
        <table id="table" class="table table-bordered table table-hover">
            <thead>
            <tr>
                <th scope="col"><fmt:message key="surname"/></th>
                <th scope="col"><fmt:message key="name"/></th>
                <th scope="col"><fmt:message key="group"/></th>
                <th scope="col"><fmt:message key="date_recipt"/></th>
            </tr>
            </thead>
            <tbody>


            <tr>
                <td>${selestedTerm.surname}</td>
                <td>${selestedTerm.name}</td>
                <td>${selestedTerm.nomber_grup}</td>
                <td><fmt:formatDate value="${selestedTerm.date_aprobarse}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
            </tr>
            </tbody>
        </table>
    </section>
    <section id="sectionBody">
        <form action="/studentsProgress" method="get">
            <input type="hidden" name="idProgStud" value="${selestedTerm.idStud}">
            <div class="row">
                <div class="col-sm-6">
                    <table id="table1" class="table table-bordered table table-hover">
                        <thead>
                        <tr id="tr">
                            <th scope="col"><fmt:message key="name_discipline"/></th>
                            <th scope="col"><fmt:message key="marc"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${selestedTerm.getDisciplinaEvalucions()}" var="d" varStatus="i">
                            <tr>
                                <td>${d.getDiscipline().getDiscipline()}</td>
                                <td class="tdTable2">${d.getEvalucion()}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <div class="col-sm-6">
                    <div class="form">
                        <div class="form-row">
                            <div class="form-group col-sm-5">
                                <h6><b><fmt:message key="choose_term"/></b></h6>
                            </div>
                            <div class="form-group col-sm-4">
                                <select type="text" id="select" class="form-control" name="term_name">
                                    <c:forEach items="${terms}" var="t" varStatus="i">
                                        <c:choose>
                                            <c:when test="${t.id eq selestedTerm.id}">
<%--                                                <option selected value="${terms.indexOf(t)}">${t.name_term}</option>--%>
                                                <option selected value="${terms.indexOf(t)}">${term_name_part} ${t.getId()}</option>
                                            </c:when>
                                            <c:otherwise>
<%--                                                <option value="${terms.indexOf(t)}">${t.name_term}</option>--%>
                                                <option value="${terms.indexOf(t)}">${term_name_part} ${t.getId()}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="form-group col-sm-2">
                                <button type="submit" id="btn" class="btn btn-outline-secondary"><fmt:message key="button_choose"/></button>
                            </div>
                        </div>
                        <div class="row">
                            <h5>
                                <div class="col-sm-12"><fmt:message key="marc_middle"/> <b><fmt:formatNumber
                                        maxFractionDigits="2" minFractionDigits="2"
                                        value="${selestedTerm.valoracionMedia/selestedTerm.getDisciplinaEvalucions().size()}"></fmt:formatNumber> </b>
                                    <fmt:message key="points"/>
                                </div>
                            </h5>
                        </div>
                    </div>
                </div>

            </div>
        </form>
    </section>
</div>
</fmt:bundle>
