<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>

	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<input type="hidden" name="_method" value="put" />
		<label for="name">Dojo:</label>
		<select name="dojoId" id="dojoId">  <!-- necesito el id del dojo -->
	  		<c:forEach items="${listDojos }" var="dojo">  
	  		<!-- el value que paso en el value de option sera el id por el cual reconocere el Person al que agregarle la License (para poder asociar) -->
		 <option value="${dojo.id }" ><c:out value="${dojo.name } "></c:out></option>
	  
	  </c:forEach>
	</select>
	
	<label for="firstName">First Name</label>
	<input id="firstName" name="firstName" type="text">
	<label for="lastName">Last Name</label>
	<input id="lastName" name="lastName" type="text">
	<label for="age">Age</label>
	<input id="age" name="age" type="number">
	<button type="submit">Create Ninja</button>
	</form:form>


</body>
</html>