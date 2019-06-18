<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Airplanes Page</title>

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

<h1>Airplanes List</h1>

<c:if test="${!empty listAirplanes}">
    <table class="tg">
        <tr>
            <th width="80">idAirplanes</th>
            <th width="80">Departureairport</th>
            <th width="80">Arrivalairport</th>
            <th width="120">Airplanename</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listAirplanes}" var="airplanes">
            <tr>
                <td>${airplanes.idAirplanes}</td>
                <td>${airplanes.departureairport}</td>
                <td>${airplanes.arrivalairport}</td>
                <td>${airplanes.airplanename}</td>
                <td><a href="<c:url value='/editairplanes/${airplanes.idAirplanes}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeairplanes/${airplanes.idAirplanes}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Airplanes</h1>

<c:url var="addAction" value="/airplanes/addairplanes"/>

<form:form action="${addAction}" commandName="airplanes">
    <table>
        <c:if test="${!empty airplanes.airplanename}">
            <tr>
                <td>
                    <form:label path="idAirplanes">
                        <spring:message text="IDAirplanes"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idAirplanes" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="IdAirplanes"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="departureairport">
                    <spring:message text="DepartureAirport"/>
                </form:label>
            </td>
            <td>
                <form:input path="departureairport"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="arrivalairport">
                    <spring:message text="ArrivalAirport"/>
                </form:label>
            </td>
            <td>
                <form:input path="arrivalairport"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="airplanename">
                    <spring:message text="AirplaneName"/>
                </form:label>
            </td>
            <td>
                <form:input path="airplanename"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty airplanes.airplanename}">
                    <input type="submit"
                           value="<spring:message text="Edit Airplane"/>"/>
                </c:if>
                <c:if test="${empty airplanes.airplanename}">
                    <input type="submit"
                           value="<spring:message text="Add Airplane"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
