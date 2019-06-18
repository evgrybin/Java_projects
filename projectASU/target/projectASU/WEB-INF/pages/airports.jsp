<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Airports Page</title>

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

<h1>Airports List</h1>

<c:if test="${!empty listAirports}">
    <table class="tg">
        <tr>
            <th width="80">idAirports</th>
            <th width="120">Airportname</th>
            <th width="120">Сountry</th>
            <th width="120">Sity</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listAirports}" var="airports">
            <tr>
                <td>${airports.idAirports}</td>
                <td>${airports.airportname}</td>
                <td>${airports.country}</td>
                <td>${airports.sity}</td>
                <td><a href="<c:url value='/editairports/${airports.idAirports}'/>">Edit</a></td>
                <td><a href="<c:url value='/removeairports/${airports.idAirports}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Airport</h1>

<c:url var="addAction" value="/airports/addairports"/>

<form:form action="${addAction}" commandName="airports">
    <table>
        <c:if test="${!empty airports.airportname}">
            <tr>
                <td>
                    <form:label path="idAirports">
                        <spring:message text="IDAirports"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idAirports" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="IdAirports"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="airportname">
                    <spring:message text="AirportName"/>
                </form:label>
            </td>
            <td>
                <form:input path="airportname"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="country">
                    <spring:message text="Country"/>
                </form:label>
            </td>
            <td>
                <form:input path="country"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="sity">
                    <spring:message text="Sity"/>
                </form:label>
            </td>
            <td>
                <form:input path="sity"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty airports.airportname}">
                    <input type="submit"
                           value="<spring:message text="Edit Airport"/>"/>
                </c:if>
                <c:if test="${empty airports.airportname}">
                    <input type="submit"
                           value="<spring:message text="Add Airport"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
