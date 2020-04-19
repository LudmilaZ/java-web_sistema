<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false" %>
<fmt:bundle basename="locale">
<nav>
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
        <div id="containerForm" class="row">
            <form class="needs-validation was-validated" method="post" action="studentsModifying">
                <input type="hidden" name="idStudentsDiscipline" value="${stud.id}">
                <div id="titleForm" class="form-group row">
                    <fmt:message key="titleFormModifyStudent"/>
                </div>
                <div class="form-group row">
                    <label for="surname" class="col-sm-2 col-form-label"><fmt:message key="surname"/></label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="surname" value="${stud.surname}" required
                               name="studsurname">
                    </div>
                    <div class="valid-tooltip"><fmt:message key="valid"/></div>
                    <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                </div>
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label"><fmt:message key="name"/></label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="name" value="${stud.name}" required name="studname">
                    </div>
                    <div class="valid-tooltip"><fmt:message key="valid"/></div>
                    <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                </div>
                <div class="form-group row">
                    <label for="surname" class="col-sm-2 col-form-label"><fmt:message key="group"/></label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="group" value="${stud.nomber_grup}" required
                               name="studnumbergrup">
                    </div>
                    <div class="valid-tooltip"><fmt:message key="valid"/></div>
                    <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                </div>
                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label"><fmt:message key="date_recipt"/></label>
                    <div class="col-sm-6">
                        <fmt:parseDate value="${stud.date_aprobarse}" var="data" pattern="yyyy-MM-dd"/>
                        <fmt:formatDate value="${data}" var="dateP" pattern="dd/MM/yyyy"/>

                        <input type="text" class="form-control" id="receiptDate" required name="stdate_aprobarse"
                               value="${dateP}"/>


                    </div>
                    <div class="valid-tooltip"><fmt:message key="valid"/></div>
                    <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                </div>
                <div class="form-group row">
                    <div id="divButton" class="col-sm-5">
                        <button type="submit" class="btn btn-outline-secondary btn btn-block"><fmt:message key="button_apply"/></button>
                    </div>
                </div>
            </form>
        </div>
    </section>
</div>
</fmt:bundle>