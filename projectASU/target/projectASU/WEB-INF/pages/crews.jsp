<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Crews Page</title>

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

<h1>Crews List</h1>

<c:if test="${!empty listCrews}">
    <table class="tg">
        <tr>
            <th width="80">idCrews</th>
            <th width="120">FullName</th>
            <th width="120">Age</th>
            <th width="120">Country</th>
            <th width="120">Sity</th>
            <th width="120">Position</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCrews}" var="crews">
            <tr>
                <td>${crews.idCrews}</td>
                <td>${crews.fullName}</td>
                <td>${crews.age}</td>
                <td>${crews.country}</td>
                <td>${crews.sity}</td>
                <td>${crews.position}</td>
                <td><a href="<c:url value='/editcrews/${crews.idCrews}'/>">Edit</a></td>
                <td><a href="<c:url value='/removecrews/${crews.idCrews}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Crew</h1>

<c:url var="addAction" value="/crews/addcrews"/>

<form:form action="${addAction}" commandName="crews">
    <table>
        <c:if test="${!empty crews.fullName}">
            <tr>
                <td>
                    <form:label path="idCrews">
                        <spring:message text="IDCrews"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="idCrews" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="IdCrews"/>
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
                <form:label path="age">
                    <spring:message text="Age"/>
                </form:label>
            </td>
            <td>
                <form:input path="age"/>
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
            <td>
                <form:label path="position">
                    <spring:message text="Position"/>
                </form:label>
            </td>
            <td>
                <form:input path="position"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty crews.fullName}">
                    <input type="submit"
                           value="<spring:message text="Edit Crew"/>"/>
                </c:if>
                <c:if test="${empty crews.fullName}">
                    <input type="submit"
                           value="<spring:message text="Add Crew"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
