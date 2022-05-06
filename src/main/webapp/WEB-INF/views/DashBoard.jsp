<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
			<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				<!DOCTYPE html>
				<html lang="en">

				<head>
					<title>Bootstrap Example</title>
					<meta charset="utf-8">
					<meta name="viewport" content="width=device-width, initial-scale=1">
					<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
					<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
					<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
				</head>

				<body>

					<div class="container-fluid">
						<h1>Hello World!</h1>
						<div class="row">
							<div class="col-sm-6">
								<H2>Deal</H2>
							</div>
							<div class="col-sm-6">
								<h2>Details</h2>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-3" style="background-color:lavender;"><b>Product</b></div>
							<div class="col-sm-3" style="background-color:lavenderblush;"><b>Account Name</b></div>
							<div class="col-sm-3" style="background-color:lavender;"><b>Agreement Date</b></div>
							<div class="col-sm-3" style="background-color:lavender;"><b>State</b></div>
						</div>
						<div class="row">
							<div class="col-sm-3">${deals.product}</div>
							<div class="col-sm-3">${deals.accountName}</div>
							<div class="col-sm-3">${deals.agreementDate}</div>
							<div class="col-sm-3">${deals.state}</div>
						</div>
						</br>
						<div class="row">
							<div class="col-sm-3" style="background-color:lavender;"><b>Facility Letter Date</b>></div>
							<div class="col-sm-3" style="background-color:lavenderblush;"><b>Account Name</b></div>
							<div class="col-sm-3" style="background-color:lavender;"><b>Agreement Date</b></div>

						</div>
						<div class="row">
							<div class="col-sm-3">${deals.facilityLetterDate}</div>
							<div class="col-sm-3">${deals.accountName}</div>
							<div class="col-sm-3">${deals.agreementDate}</div>

						</div>

						<div class="row">
							<div class="col-sm-6">
								<H2>PARTY</H2>
							</div>
							<div class="col-sm-6">
								<h2>DETAILS</h2>
							</div>
						</div>
						<c:forEach var="party" items="${deals.children}">
							<div class="row">
								<div class="col-sm-2">${party.name}</div>
								<div class="col-sm-2">${party.email}</div>
								<div class="col-sm-2">${party.mobileNumber}</div>
								<div class="col-sm-2">${party.partyType}</div>
								<div class="col-sm-2">${party.partySignatureName}</div>
								<div class="col-sm-1">${party.address}</div>
								<div class="col-sm-1">${party.branch}</div>

							</div>
						</c:forEach>

					</div>
				</body>

				</html>