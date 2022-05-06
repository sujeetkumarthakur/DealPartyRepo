<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
			<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<!DOCTYPE html>
				<html>

				<head>
					<meta charset="ISO-8859-1">
					<title>Insert title here</title>
				</head>

				<body>

					<h1>Login</h1>
					</br>
					<form:form action="/isLogined" method="put" modelAttribute="logindetails">

						UserName:
						<form:input path="username" />
						</br>
						Password:
						<form:input path="password" />
						</br>

						<form:button>Submit</form:button>

					</form:form></br>

				</body>

				</html>