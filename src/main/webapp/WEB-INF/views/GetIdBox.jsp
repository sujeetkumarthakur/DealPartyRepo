<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Surgen For Page</h1>
	</br>
	<form:form action="/getSurgeonById" method="GET" modelAttribute="id">
		Id:<form:input  path=""/>
		</br>
		
		<form:button>Submit</form:button>

	</form:form></br>
	
</body>
</html>