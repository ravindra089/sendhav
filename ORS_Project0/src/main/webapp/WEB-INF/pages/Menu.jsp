<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<div align="justify" style="width: 80%; background-color: white;"
	class="col-sm-offset-1">

	<div style="background-color: black; height: 10%;">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
			href="" style="color: white;"><font size="4">English</font></a>
		&nbsp; | &nbsp; <a href="" style="color: white;"><font size="4">Hindi</font></a>
	</div>

	<h3 style="color: white; background-color: black;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quick
		Links:</h3>
	<div style="background-color: black;">
		<ul>
			<li style="color: white;">&nbsp;&nbsp;<a
				href="<c:url value="/AboutUs" />" style="color: white;">&nbsp;&nbsp;<font
					size="4">About Us</font></a></li>
			<li style="color: white;">&nbsp;&nbsp;<a
				href="<c:url value="/ContactUs"/>" style="color: white;">&nbsp;&nbsp;<font
					size="4">Contact Us</font></a></li>
			<li style="color: white;">&nbsp;&nbsp;&nbsp;<a href=""
				style="color: white;"><font size="4">Feedback</font> </a></li>
		</ul>
	</div>

	<div style="background-color: black;">
		<h4 style="color: white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HelpLineNo:</h4>
		<h5 style="color: white;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tel:91731-4249244
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cell:9198273-60504</h5>
	</div>


	<div style="background-color: black;">
		<c:if test="${sessionScope.user!=null }">


			<ul>

				<li style="color: white;"><a style="color: white;"
					href="<c:url value="/ctl/User/profile" />"><font size="3">My
							Profile</font></a></li>
				<li style="color: white;"><a style="color: white;"
					href="<c:url value="/ctl/User/changepassword" />"><font
						size="3">Change Password</font></a></li>
				<li style="color: white;"><a style="color: white;"
					href="<c:url value="/ctl/Marksheet/meritlist"/>"><font size="3">Get
							MeritList</font></a></li>
			</ul>
		</c:if>
	</div>
</div>


