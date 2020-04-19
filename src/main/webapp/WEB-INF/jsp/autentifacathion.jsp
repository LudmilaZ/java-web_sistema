<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<div id="container" class="container-fluid">
    <div class="row">

        <div class="col-md-8">
            <section>
                <div id="containerForm" class="row">
                    <form class="needs-validation was-validated" action="/autentificathion" method="post">
<%--                        <fmt:setLocale value="es_ES" scope="session"/>--%>
<%--                        <fmt:setLocale value="${language_ch}" scope="session"/>--%>
                        <fmt:bundle basename="locale">


                            <div id="titleForm" class="form-group row">
                                <fmt:message key="titleForm"/>

                            </div>
                            <div class="form-group row">
                                <label for="loginID" class="col-sm-2 col-form-label"><fmt:message key="login"/></label>
                                <div class="col-sm-6">
                                    <input type="text" class="form-control" id="loginID" name="login"
                                           placeholder="Логин"
                                           required>
                                </div>
                                <div class="valid-tooltip"><fmt:message key="valid"/></div>
                                <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                            </div>
                            <div class="form-group row">
                                <label for="passId" class="col-sm-2 col-form-label"><fmt:message key="password"/></label>
                                <div class="col-sm-6">
                                    <input type="password" class="form-control" id="passId" name="pass"
                                           placeholder="****"
                                           required>
                                </div>
                                <div class="valid-tooltip"><fmt:message key="valid"/></div>
                                <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                            </div>
                            <div class="form-group row">
                                <label for="roleID" class="col-sm-2 col-form-label"><fmt:message key="role"/></label>
                                <div class="col-sm-6">
                                    <select class="form-control" id="roleID" name="role">
                                        <option value="1">administrator</option>
                                        <option value="2">teacher</option>
                                        <option value="3">student</option>
                                    </select>


                                </div>
                                <div class="valid-tooltip"><fmt:message key="valid"/></div>
                                <div class="invalid-tooltip"><fmt:message key="invalid"/></div>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-2"></div>
                                <div class="col-sm-3">
                                    <button type="submit" class="btn btn-outline-secondary btn btn-block"><fmt:message key="button_entr"/></button>

                                </div>
<%--                                <div class="col-sm-3">--%>
<%--                                <select class="btn btn-outline-secondary btn btn-block" name="language_page" id= "language_page" onchange="SelectLanguage()">--%>
<%--                                    <c:forEach items="${language_list}" var="t" varStatus="i">--%>
<%--                                        <c:choose>--%>
<%--                                        <c:when test="${t.getShot_name() eq language_ch}">--%>
<%--                                           <option selected value="${t.getShot_name()}">${t.getLanguage()}</option>--%>
<%--                                        </c:when>--%>
<%--                                        <c:otherwise>--%>
<%--                                            <option  value="${t.getShot_name()}">${t.getLanguage()}</option>--%>
<%--                                        </c:otherwise>--%>
<%--                                        </c:choose>--%>
<%--                                    </c:forEach>--%>
<%--                                </select>--%>
<%--                                </div>--%>

                            </div>

                            <c:if test="${errorMassage eq 1}">
                                <div><fmt:message key="invalid_login_password"/></div>
                            </c:if>

                        </fmt:bundle>
                    </form>
                </div>
            </section>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>

