<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="page" value="/jsp/user/bookings.jsp" scope="request"/>
<fmt:setLocale value="${not empty sessionScope.locale ? sessionScope.locale : pageContext.request.locale}"
               scope="session"/>
<fmt:setBundle basename="messages"/>

<html>
<head>
    <title><fmt:message key="label.bookings"/></title>
</head>
<body>
<table>
    <c:forEach var="booking" items="${requestScope.bookings}">
        <tr>
            <td>${booking.arrival}</td>
            <td>${booking.departure}</td>
            <td>${booking.room.number}</td>
            <td>${booking.guestsNumber}</td>
            <td>${booking.guestName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
