<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer</title>
</head>
<body>
<h1>Customer</h1>

<c:url var="addUrl" value="/customer/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#68ff9d">
		<tr>
			<th>name</th>
			<th>surname</th>
			<th>phone number</th>
			<th colspan="3"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${customers}" var="customer">
			<c:url var="editUrl" value="/customer/edit?id=${customer.id}" />
			<c:url var="deleteUrl" value="/customer/delete?id=${customer.id}" />
		<tr>
			<td><c:out value="${customer.name}" /></td>
			<td><c:out value="${customer.surname}" /></td>
			<td><c:out value="${customer.phoneNumber}" /></td>
			<td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
			<td><a href="${addUrl}">Add</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty customers}">
	There are currently no customers in the list. <a href="${addUrl}">Add</a> a customer.
</c:if>

</body>
</html>