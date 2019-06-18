<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>CrewsData</title>

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
<h1>Crews Details</h1>

<table class="tg">
    <tr>
        <th width="80">idCrews</th>
        <th width="120">FullName</th>
        <th width="120">Age</th>
        <th width="120">Country</th>
        <th width="120">Sity</th>
        <th width="120">Position</th>
    </tr>
    <tr>
        <td>${crews.idCrews}</td>
        <td>${crews.fullName}</td>
        <td>${crews.age}</td>
        <td>${crews.country}</td>
        <td>${crews.sity}</td>
        <td>${crews.position}</td>
    </tr>
</table>
</body>
</html>
