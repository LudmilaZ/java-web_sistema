<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<fmt:bundle basename="locale">
    <nav>
        <div id="divNav" class="row">
            <a id="home" href="index.jsp" class="nav">
                <button type="button" class="btn btn-outline-secondary btn-sm"><fmt:message key="button_back_homepage"/></button>
            </a>
            <a id="termsList" href="/termsList" class="nav">
                <button type="button" class="btn btn-outline-secondary btn-sm"><fmt:message key="button_back"/></button>
            </a>
        </div>
    </nav>
    <div id="container">
        <section>
            <div id="containerForm" class="row">
                <form method="post" action="/termsCreating">
                    <div id="titleForm" class="form-group row">
                        <fmt:message key="titleFormCreateTerm"/>
                    </div>
                    <div id="divFormGroupRow" class="form-group row needs-validation was-validated">
                        <label id="lbl1" for="input" class="col-sm-6 col-form-label"><fmt:message key="duration_term_in_week"/></label>
                        <div id="divInput" class=" form-group col-sm-2">
                            <input id="input" type="text" class="form-control" placeholder="24" maxlength="2" required
                                   name="tiempo_term">
                            <div class="valid-tooltip">
                                <fmt:message key="valid"/>
                            </div>
                            <div class="invalid-tooltip">
                                <fmt:message key="invalid"/>
                            </div>
                        </div>

                    </div>
                    <div id="divFormSelect" class="form-group row">
                        <label id="lbl2" for="formControlSelect" class="col-sm-6"><fmt:message key="disciplines_in_term"/></label>
                        <select multiple class="form-control col-sm-6" name="formControlSelect[]" id="formControlSelect"
                                size="7">
                            <c:forEach items="${disces}" var="d" varStatus="i">
                                <c:if test="${d.discipline.length() > 0}">
                                    <option value="${d.id}">${d.discipline}</option>
                                </c:if>
                            </c:forEach>


                        </select>
                    </div>
                    <div class="form-group row">
                        <div id="divButton" class="col-sm-9">

                            <button type="submit" class="btn btn-outline-secondary btn btn-block"><fmt:message key="button_create"/>
                            </button>


                        </div>
                    </div>
                </form>
            </div>
        </section>
    </div>
</fmt:bundle>
<form id="formCreatingTerm" method="post" action="/termsList">
    <input type="hidden" id="idsCreatingTerm" name="idsCreatingTerm" value="">
</form>