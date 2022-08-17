<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
<!DOCTYPE html>
<html>
<head>

<link
href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
rel="stylesheet"
integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
crossorigin="anonymous">
<script
src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Dojo Page</title>
</head>
<body>

	<h1><c:out value="${dojoName }"></c:out> Location Ninjas</h1><br><br>
	
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age</th>
			</tr>
		</thead>
		<tbody>
		
		<c:forEach items="${ninjasInIdDojo }" var="ninja">
			<tr>
				<td scope="row"><c:out value="${ninja.getFirstName() }"></c:out></td>
				<td><c:out value="${ninja.getLastName() }"></c:out></td>
				<td><c:out value="${ninja.getAge() }"></c:out></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>


</body>
</html>