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

        </div>
    </nav>
    <div id="container">
        <section>
            <div id="titleTermsList" class="row">
                <form action="/termsList" method="get">
                    <div class="form">
                        <div class="form-row">
                            <div id="divFormTitle" class="form-group col-sm-4">
                                <h5><fmt:message key="choose_term"/></h5>
                            </div>
                            <div class="form-group col-sm-3">
                                <select type="text" id="select" class="form-control" name="term_name">

                                    <c:forEach items="${terms}" var="t" varStatus="i">

                                        <c:choose>
                                            <c:when test="${t.getId() eq selestedTerm.id}">
<%--                                                <option selected value="${t.getId()}">${t.getName_term()}</option>--%>
                                                <option selected value="${t.getId()}">${term_name_part} ${t.getId()}</option>
                                            </c:when>
                                            <c:otherwise>
<%--                                                <option value="${t.getId()}">${t.getName_term()}</option>--%>
                                                <option value="${t.getId()}">${term_name_part} ${t.getId()}</option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                </select>
                            </div>
                            <div class="form-group col-sm-3">
                                <button type="submit" id="btn" class="btn btn-outline-secondary"><fmt:message key="button_choose"/></button>
                            </div>
                        </div>
                        <div id="divDurationTerm" class="row">
                            <h5>
                                <div class="col-sm-12"><fmt:message key="duration_term"/>
                                    <b> ${selestedTerm.tiempo_term} </b><fmt:message key="week"/>
                                </div>
                            </h5>
                        </div>
                    </div>
                </form>
            </div>
        </section>

        <section id="sectionBody">

            <div class="row">

                <div class="col-sm-7">
                    <h5><fmt:message key="list_disciplinas_term"/></h5>
                    <table id="table" class="table table-bordered table table-hover">
                        <thead>

                        <tr>

                            <th scope="col"><fmt:message key="name_discipline"/></th>
                        </tr>
                        </thead>


                        <tbody>

                        <c:forEach items="${selestedTerm.getDiscipList()}" var="d" varStatus="i">
                            <tr>


                                <td>${d.discipline}</td>
                            </tr>

                        </c:forEach>

                        </tbody>

                    </table>
                </div>
                <div class="col-sm-5">
                    <c:if test="${role eq 1}">
                        <section>
                            <div id="divTermsList1" class="row">
                                <div class="divTermsList col-sm-12">
                                    <a href="/termsCreating">
                                        <button id="button1" type="button"
                                                class="btn btn-outline-secondary btn-lg btn-block">
                                            <fmt:message key="create_term"/>
                                        </button>
                                    </a>
                                </div>
                            </div>
                            <div id="divTermsList2" class="row">
                                <form action="/termModifying" method="get">
                                    <input name="term_name_dublicat" type="hidden" value="${selestedTerm.id}">
                                    <input name="tiempo_term_dublicat" type="hidden"
                                           value="${selestedTerm.tiempo_term}">
                                    <div class="divTermsList col-sm-12">


                                            <%--                            <a onclick="this">--%>
                                        <button id="button2" type="submit"
                                                class="btn btn-outline-secondary btn-lg btn-block">
                                            <fmt:message key="modify_term"/>
                                        </button>

                                            <%--                           </a>--%>
                                    </div>
                                </form>
                            </div>
                            <div id="divTermsList3" class="row">
                                <form action="/termsList" method="post">
                                    <input name="term_name_dublicatDelete" type="hidden" value="${selestedTerm.id}">
                                    <div class="divTermsList3 col-sm-12">
                                            <%--                                <a href="#">--%>
                                        <button id="button3" type="submit"
                                                class="btn btn-outline-secondary btn-lg btn-block">
                                            <fmt:message key="delete_term"/>
                                        </button>
                                            <%--                                </a>--%>
                                    </div>
                                </form>
                            </div>
                        </section>
                    </c:if>
                </div>

            </div>

        </section>

    </div>
</fmt:bundle>
