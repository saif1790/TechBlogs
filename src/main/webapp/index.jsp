<%@page import="com.tech.blogs.helper.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="javax.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Technical Blogs</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.banner-background {
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 100%, 66% 96%, 30% 100%, 0 95%, 0 0
		);
}
</style>
</head>
<body>

	<%@include file="normal_navbar.jsp"%>

	<!--     //banner  -->
	<div class="container-fluid p-0 ">
		<div class="jumbotron primary-background text-white banner-background">
			<div class="container">
				<h3 class="display-3">Welcome,To Technical Blog</h3>
				<p>There’s also the risk of legal trouble if the name that you
					are inspired by is copyrighted. There aren’t many benefits of
					having a similar blog name anyway, so it’s best to avoid the issue
					entirely.</p>
				<button class="btn btn-outline-light btn-lg">
					<span class="fa fa-user-plus"></span> Start here!!
				</button>
				<a href="login.jsp" class="btn btn-outline-light btn-lg">
					<span class="fa fa-user-circle-o fa-spin"></span> Login
				</a>
			</div>
		</div>
		<div>

			<!-- card -->

			<div class="container">
				<div class="row">

					<div class="col-md-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Java Programming</h5>
								<p class="card-text">Java is a widely used object-oriented
									programming language and software platform that runs on
									billions of devices, including notebook computers, mobile
									devices, gaming consoles, medical devices and many others.</p>
								<a href="#" class="btn primary-background text-white">Go
									somewhere</a>
							</div>
						</div>

					</div>

					<div class="col-md-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Python Programming</h5>
								<p class="card-text">Python Programming can be used to
									process text data for the requirements in various textual data
									analysis. A very important area of application of such text
									processing ability of python is for NLP (Natural Language
									Processing).</p>
								<a href="#" class="btn primary-background text-white">Go
									somewhere</a>
							</div>
						</div>

					</div>
					<div class="col-md-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Java Programming</h5>
								<p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p>
								<a href="#" class="btn primary-background text-white">Go
									somewhere</a>
							</div>
						</div>

					</div>
				</div>

				<div class="row mt-2">

					<div class="col-md-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Java Programming</h5>
								<p class="card-text">Java is a widely used object-oriented
									programming language and software platform that runs on
									billions of devices, including notebook computers, mobile
									devices, gaming consoles, medical devices and many others.</p>
								<a href="#" class="btn primary-background text-white">Go
									somewhere</a>
							</div>
						</div>

					</div>

					<div class="col-md-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Python Programming</h5>
								<p class="card-text">Python Programming can be used to
									process text data for the requirements in various textual data
									analysis. A very important area of application of such text
									processing ability of python is for NLP (Natural Language
									Processing).</p>
								<a href="#" class="btn primary-background text-white">Go
									somewhere</a>
							</div>
						</div>

					</div>
					<div class="col-md-4">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Java Programming</h5>
								<p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p>
								<a href="#" class="btn primary-background text-white">Go
									somewhere</a>
							</div>
						</div>

					</div>
				</div>

			</div>

			<script src="https://code.jquery.com/jquery-3.6.0.min.js"
				integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
				integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
				crossorigin="anonymous"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
				integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
				crossorigin="anonymous"></script>
			<script src="js/myjavascript.js" type="text/javascript"></script>
</body>
</html>