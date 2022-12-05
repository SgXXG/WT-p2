<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="page" value="/jsp/admin/admin-main.jsp" scope="request"/>
<fmt:setLocale value="${not empty sessionScope.locale ? sessionScope.locale : pageContext.request.locale}"
               scope="session"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title></title>
</head>
<body>
<div>
    <h3><fmt:message key="label.welcome"/>${sessionScope.user.firstName}</h3>
</div>
</body>
</html>
