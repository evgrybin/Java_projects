<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Timetables Page</title>

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

<h1>Timetables List</h1>

<c:if test="${!empty listTimetables}">
    <table class="tg">
        <tr>
            <th width="80">idTimetables</th>
            <th width="120">Dateofdeparture</th>
            <th width="120">Dateofarrival</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listTimetables}" var="timetables">
            <tr>
                <td>${timetables.idTimetables}</td>
                <td>${timetables.dateofdeparture}</td>
                <td>${timetables.dateofarrival}</td>
                <td><a href="<c:url value='/edittimetables/${timetables.idTimetables}'/>">Edit</a></td>
                <td><a href="<c:url value='/removetimetables/${timetables.idTimetables}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Timetable</h1>

<c:url var="addAction" value="/timetables/addtimetables"/>

<form:form action="${addAction}" commandName="timetables">
    <table>
        <c:if test="${!empty timetables.dateofdeparture}">
            <tr>
                <td>
                    <form:label path="idTimetables">
                        <spring:message text="IDTimetables"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idTimetables" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="IdTimetables"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="dateofdeparture">
                    <spring:message text="DateOfDeparture"/>
                </form:label>
            </td>
            <td>
                <form:input path="dateofdeparture"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="dateofarrival">
                    <spring:message text="DateOfArrival"/>
                </form:label>
            </td>
            <td>
                <form:input path="dateofarrival"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty timetables.dateofdeparture}">
                    <input type="submit"
                           value="<spring:message text="Edit Timetable"/>"/>
                </c:if>
                <c:if test="${empty timetables.dateofdeparture}">
                    <input type="submit"
                           value="<spring:message text="Add Timetable"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
