<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Customer</title>
</head>
<body>
	<h1>Customer create/update</h1>
	<hr>

	<form action="find" method="post">

		Find Customer by id : 
		<input id="customerId" name="customerId" maxlength="20"> 
		<input type="submit" value="Search">
	</form>

	<br>

	<div class="form">
		<form action="create" method="post">
			<table>
				
				<tr>
					<td>First Name:</td>
					<td><input id="firstName" name="firstName" maxlength="20"
						value="${customer.firstName}"></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><input id="lastName" name="lastName" maxlength="20" value="${customer.lastName}"></td>
				</tr>
				<tr>
					<td>Customer Id:</td>
					<td><input id="customerId" name="customerId" maxlength="20" value="${customer.customerId}"></td>
				</tr>

			</table>

			<input type="submit" value="Submit">

		</form>
	</div>


	<h1>Customer list</h1>
	<hr>

	<form action="delete" method="post">

		<table border="1">
			<tr>
			    <th></th>
				<th>id</th>
				<th>Name</th>
			</tr>
			<c:forEach items="${customerList}" var="item">
               <tr>
                 <td> <input type="radio" name="selectedValue" value="${item.customerId}" />   </td>
			     <td>	${item.customerId}  </td>
			     <td>
			        ${item.lastName}  ,  ${item.firstName}
                 </td>
               </tr>
			</c:forEach>

		</table>





		<input type="submit" value="Delete" />


	</form>

</body>
</html>