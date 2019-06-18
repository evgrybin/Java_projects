<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Tickets Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to Main panel</a>

<br/>
<br/>

<h1>Tickets List</h1>

<c:if test="${!empty listTickets}">
    <table class="tg">
        <tr>
            <th width="80">idTickets</th>
            <th width="120">FullName</th>
            <th width="120">document</th>
            <th width="120">Passport series</th>
            <th width="120">Passport number</th>
            <th width="120">Flight number</th>
            <th width="80">Seat id</th>
            <th width="120">status</th>
            <th width="120">date</th>
            <th width="120">Price</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTickets}" var="tickets">
        <tr>
            <td>${tickets.idTickets}</td>
            <td><a href="/ticketsdata/${tickets.idTickets}" target="_blank">${tickets.fullName}</a></td>
            <td>${tickets.document}</td>
            <td>${tickets.passport_series}</td>
            <td>${tickets.passport_number}</td>
            <td>${tickets.flight_number}</td>
            <td>${tickets.seat_id.idSeats}</td>
            <td>${tickets.status}</td>
            <td>${tickets.date}</td>
            <td>${tickets.price}</td>
            <td><a href="<c:url value='/edittickets/${tickets.idTickets}'/>">Edit</a></td>
            <td><a href="<c:url value='/removetickets/${tickets.idTickets}'/>">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Ticket</h1>

<c:url var="addAction" value="/tickets/addtickets"/>

<form:form action="${addAction}" commandName="tickets">
    <table>
        <c:if test="${!empty tickets.fullName}">
            <tr>
                <td>
                    <form:label path="idTickets">
                        <spring:message text="IDTickets"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idTickets" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="IdTickets"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="fullName">
                    <spring:message text="FullName"/>
                </form:label>
            </td>
            <td>
                <form:input path="fullName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="document">
                    <spring:message text="Document"/>
                </form:label>
            </td>
            <td>
                <form:input path="document"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="passport_series">
                    <spring:message text="Passport Series"/>
                </form:label>
            </td>
            <td>
                <form:input path="passport_series"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="passport_number">
                    <spring:message text="Passport Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="passport_number"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="flight_number">
                    <spring:message text="Flight Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="flight_number"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="seat_id.idSeats">
                    <spring:message text="Seat Id"/>
                </form:label>
            </td>
            <td>
                <form:input path="seat_id.idSeats"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="status">
                    <spring:message text="Status"/>
                </form:label>
            </td>
            <td>
                <form:input path="status"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="date">
                    <spring:message text="Date"/>
                </form:label>
            </td>
            <td>
                <form:input path="date"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty tickets.fullName}">
                    <input type="submit"
                           value="<spring:message text="Edit Ticket"/>"/>
                </c:if>
                <c:if test="${empty tickets.fullName}">
                    <input type="submit"
                           value="<spring:message text="Add Ticket"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
