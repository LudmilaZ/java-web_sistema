<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<fmt:bundle basename="locale">
    <nav>
        <div id="divNav" class="row">
            <a id="home" href="/" class="nav">
                <button type="button" class="btn btn-outline-secondary btn-sm"><fmt:message
                        key="button_back_homepage"/></button>
            </a>
            <a id="studentsList" href="/studentsList" class="nav">
                <button type="button" class="btn btn-outline-secondary btn-sm"><fmt:message key="button_back"/></button>
            </a>
        </div>
    </nav>
    <div id="container">
        <section>
            <div id="containerForm" class="row">
                <form class="needs-validation was-validated" method="post" action="/students-create">
                    <div id="titleForm" class="form-group row">
                        <fmt:message key="titleFormCreateStudent"/>
                    </div>
                    <div class="form-group row">
                        <label for="surname" class="col-sm-2 col-form-label"><fmt:message key="surname"/></label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="surname"
                                   placeholder="<fmt:message key="surname"/>" required
                                   name="stsurname">
                        </div>
                        <div class="valid-tooltip"><fmt:message key="valid"/></div>
                        <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                    </div>
                    <div class="form-group row">
                        <label for="name" class="col-sm-2 col-form-label"><fmt:message key="name"/></label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="name" placeholder="<fmt:message key="name"/>"
                                   required name="stname">
                        </div>
                        <div class="valid-tooltip"><fmt:message key="valid"/></div>
                        <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                    </div>
                    <div class="form-group row">
                        <label for="surname" class="col-sm-2 col-form-label"><fmt:message key="group"/></label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="group" placeholder="КТ-21" required
                                   name="stgrupa">
                        </div>
                        <div class="valid-tooltip"><fmt:message key="valid"/></div>
                        <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                    </div>
                    <div class="form-group row">
                        <label for="name" class="col-sm-2 col-form-label"><fmt:message key="date_recipt"/></label>
                        <div class="col-sm-6">

                            <input type="text" class="form-control" id="receiptDate" placeholder="30/03/2020" required
                                   name="stdate_aprobarse"/>

                        </div>
                        <div class="valid-tooltip"><fmt:message key="valid"/></div>
                        <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                    </div>


                    <div class="form-group row">
                        <div id="divButton" class="col-sm-5">
                            <button type="submit" class="btn btn-outline-secondary btn btn-block"><fmt:message
                                    key="button_create"/>
                            </button>
                        </div>
                    </div>

                </form>
            </div>
        </section>
    </div>
</fmt:bundle>