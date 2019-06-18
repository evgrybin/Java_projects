<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Seats Page</title>

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

<h1>Seats List</h1>

<c:if test="${!empty listSeats}">
    <table class="tg">
        <tr>
            <th width="80">idSeats</th>
            <th width="120">Row</th>
            <th width="120">Number</th>
            <th width="120">Type</th>
            <th width="80">Airplane id</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listSeats}" var="seats">
            <tr>
                <td>${seats.idSeats}</td>
                <td>${seats.row}</td>
                <td>${seats.number}</td>
                <td>${seats.type}</td>
                <td>${seats.airplane_id}</td>
                <td><a href="<c:url value='/editseats/${seats.idSeats}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeseats/${seats.idSeats}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Seat</h1>

<c:url var="addAction" value="/seats/addseats"/>

<form:form action="${addAction}" commandName="seats">
    <table>
        <c:if test="${!empty seats.type}">
            <tr>
                <td>
                    <form:label path="idSeats">
                        <spring:message text="IDSeats"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idSeats" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="IdSeats"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="row">
                    <spring:message text="Row"/>
                </form:label>
            </td>
            <td>
                <form:input path="row"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="number">
                    <spring:message text="Number"/>
                </form:label>
            </td>
            <td>
                <form:input path="number"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="type">
                    <spring:message text="Type"/>
                </form:label>
            </td>
            <td>
                <form:input path="type"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="airplane_id">
                    <spring:message text="Airplane Id"/>
                </form:label>
            </td>
            <td>
                <form:input path="airplane_id"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty seats.type}">
                    <input type="submit"
                           value="<spring:message text="Edit Seats"/>"/>
                </c:if>
                <c:if test="${empty seats.type}">
                    <input type="submit"
                           value="<spring:message text="Add Seats"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
