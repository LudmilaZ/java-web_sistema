<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<div id="container">
    <nav>
        <fmt:bundle basename="locale">
            <fmt:setLocale value="${language_ch}" scope="session"/>
        <div id="navHeader" class="row">
            <div class="col-sm-4">
                <a href="/studentsList">
                    <button type="button" class="btn btn-outline-secondary btn-lg btn-block"><fmt:message key="students"/></button>
                </a>
            </div>
            <div class="col-sm-4">
                <a href="/disciplines">
                    <button type="button" class="btn btn-outline-secondary btn-lg btn-block"><fmt:message key="Disciplines"/></button>
                </a>
            </div>
            <div class="col-sm-4">
                <a href="/termsList">
                    <button type="button" class="btn btn-outline-secondary btn-lg btn-block"><fmt:message key="term"/></button>
                </a>
            </div>
        </div>
        </fmt:bundle>
    </nav>
</div>