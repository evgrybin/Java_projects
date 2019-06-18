<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>TicketsData</title>

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
<h1>Tickets Details</h1>

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
    </tr>
    <tr>
        <td>${tickets.idTickets}</td>
        <td>${tickets.fullName}</td>
        <td>${tickets.document}</td>
        <td>${tickets.passport_series}</td>
        <td>${tickets.passport_number}</td>
        <td>${tickets.flight_number}</td>
        <td>${tickets.seat_id.idSeats}</td>
        <td>${tickets.status}</td>
        <td>${tickets.date}</td>
        <td>${tickets.price}</td>
    </tr>
</table>
</body>
</html>
