<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/recourses/css/templates/header.css">
    <link rel="stylesheet" href="/recourses/css/index.css">
    <title>Title page</title>
</head>
<body>
<fmt:bundle basename="locale">
<%--<fmt:setLocale value="${language_ch}" scope="session"/>--%>
<header>

    <div id="containerHeader" class="container-fluid">
        <div class="container-fluid">
            <div class="row">

                <div class="col-sm-2">
                    <select class="btn btn-link btn btn-sm" name="language_page" id="language_page"
                            onchange="SelectLanguage()">
                        <c:forEach items="${language_list}" var="t" varStatus="i">
                            <c:choose>
                                <c:when test="${t.getShot_name() eq language_ch}">
                                    <option selected value="${t.getShot_name()}">${t.getLanguage()}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${t.getShot_name()}">${t.getLanguage()}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-2">

                </div>
                <div id="titleHeader" class="col-sm-8">
                    <h3><fmt:message key="titleHeader"/></h3>
                </div>
                <div class="col-sm-2">

                    <a id="logout" class="btn btn-link btn btn-sm" href="/logout">
                        <%--<button type="button" class="btn btn-outline-secondary btn-sm">--%><fmt:message key="button_exit"/> ${userName}<%--</button>--%>
                    </a>

                </div>
            </div>
        </div>
    </div>

</header>
<%@ include file="/WEB-INF/jsp/home.jsp" %>
</fmt:bundle>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>