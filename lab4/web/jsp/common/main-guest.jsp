<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="page" value="/jsp/common/main-guest.jsp" scope="request"/>
<fmt:setLocale value="${not empty sessionScope.locale ? sessionScope.locale : pageContext.request.locale}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <!-- Login -->
    <form action="<c:url value="/controller"/>" method="get">
        <input type="hidden" name="command" value="to-login">
        <input type="submit" name="submit" value="<fmt:message key="button.login"/>  ">
    </form>
</div>
<div>
    <!-- Registration -->
    <form action="<c:url value="/controller"/>" method="get">
        <input type="hidden" name="command" value="to-registration">
        <input type="submit" name="submit" value="<fmt:message key="button.register"/> ">
    </form>
</div>
</body>
</html>
