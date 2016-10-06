<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<div>

	<div class="col-sm-offset-3">
		<h1 align="left">
			<font size="10px" color="green">Welcome to ORS </font>
		</h1>
		&nbsp; &nbsp;
		<marquee style="width: 60%; height: 5%; background-color: white-space: ;">
			<a style="color: black;">$ Online Result System $</a>
		</marquee>
		<br>



		<c:if test="${not empty sessionScope.user }">
			<c:if test="${sessionScope.user.roleId==2 }">
				<h2 align="left" class="text-center">
					<a style="color: black;" href="">Click here to see your
						Marksheet </a>
				</h2>

			</c:if>
		</c:if>

	</div>
	<br>
	

<img alt="" src="resources/img/RaysTecLogo400x400%20copy.jpg">	
</div>
