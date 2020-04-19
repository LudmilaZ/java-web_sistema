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
        <a id="disciplinesList" href="/disciplines" class="nav">
            <button type="button" class="btn btn-outline-secondary btn-sm"><fmt:message key="button_back"/></button>
        </a>
    </div>
</nav>
<div id="container">
    <section>
        <div id="containerForm" class="row">
            <form class="needs-validation was-validated" method="post" action="/discipline-create">
                <div id="titleForm" class="form-group row">
                    <fmt:message key="titleFormDisciplinaCreate"/>
                </div>

                <div class="form-group row">
                    <label for="name" class="col-sm-2 col-form-label"><fmt:message key="title"/></label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="name" placeholder="<fmt:message key="new_title"/>"
                               required name="discName">
                    </div>
                    <div class="valid-tooltip"><fmt:message key="valid"/>!</div>
                    <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                </div>
                <div class="form-group row">
                    <div id="divButton" class="col-sm-5">
                        <button type="submit" class="btn btn-outline-secondary btn btn-block"><fmt:message key="button_create"/></button>
                    </div>
                </div>

            </form>
        </div>
    </section>
</div>
</fmt:bundle>