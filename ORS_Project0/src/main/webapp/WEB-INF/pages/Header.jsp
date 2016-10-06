
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="/bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			
			<div>
			<a class="navbar-brand" href="#"><img alt="" src="../resources/img/customLogo.png"
				 style="color: red"
				 width="150" height="30"></a></div>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<ul class="nav nav-tabs">


			<c:choose>
				<c:when test="${empty sessionScope.user }">

					<ul class="nav nav-tabs">
						<li><a href="<c:url value="/Welcome" />"> <span
								class="glyphicon glyphicon-home" style="color: brown;"></span> &nbsp;Home
						</a></li>

						
						
						<li><a href="<c:url value="/SignUp" />"><span
								class="glyphicon glyphicon-list"></span> &nbsp;User Registration</a></li>


						<li><a href="<c:url value="/Login"  />"><span
								class="glyphicon glyphicon-user"></span> &nbsp;Login</a></li>


					</ul>



				</c:when>
				<c:otherwise>

					<c:if test="${not empty sessionScope.user }">
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">


								<li class="active"><a href="<c:url value="/Welcome" />">
										<span class="glyphicon glyphicon-home"></span> &nbsp;Home
								</a></li>


								<c:if test="${sessionScope.user.roleId==1 }">

									<ul class="nav navbar-nav">
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-haspopup="true"
											aria-expanded="false">User<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="<c:url value="/ctl/User"/>">Add User </a></li>
												<li><a href="<c:url value="/ctl/User/search" />">User
														List</a></li>
											</ul></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-haspopup="true"
											aria-expanded="false" style="color: orange">Role<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="<c:url value="/ctl/Role" />" style="color: orange">Add Role </a></li>
												<li><a href="<c:url value="/ctl/Role/search"/>" style="color: orange">Role
														List</a></li>
											</ul></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-haspopup="true"
											aria-expanded="false">Student<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="<c:url value="/ctl/Student"/>">Add
														Student</a></li>
												<li><a href="<c:url value="/ctl/Student/search"/>">Student
														List</a></li>
											</ul></li>

										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-haspopup="true"
											aria-expanded="false">College<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="<c:url value="/ctl/College"/>">Add
														College </a></li>
												<li><a href="<c:url value="/ctl/College/search"/>">College
														List</a></li>
											</ul></li>

										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-haspopup="true"
											aria-expanded="false">Course<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="<c:url value="/ctl/Course"/>">Add
														Course </a></li>
												<li><a href="<c:url value="/ctl/Course/search"/>">Course
														List</a></li>
											</ul></li>

										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-haspopup="true"
											aria-expanded="false">Faculty<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="<c:url value="/ctl/Faculty"/>">Add
														Faculty </a></li>
												<li><a href="<c:url value="/ctl/Faculty/search"/>">Faculty
														List</a></li>
											</ul></li>

										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-haspopup="true"
											aria-expanded="false">Marksheet<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="<c:url value="/ctl/Marksheet"/>">Add
														Marksheet </a></li>
												<li><a href="<c:url value="/ctl/Marksheet/search"/>">Marksheet
														List </a></li>
												<li><a href="<c:url value="/ctl/Marksheet/get"/>">Get
														Marksheet </a></li>

											</ul></li>
										<li class="dropdown"><a href="#" class="dropdown-toggle"
											data-toggle="dropdown" role="button" aria-haspopup="true"
											aria-expanded="false " style="color: white;">TimeTable<span class="caret"></span></a>
											<ul class="dropdown-menu">
												<li><a href="<c:url value="/ctl/TimeTable"/>">Add
														TimeTable </a></li>
												<li><a href="<c:url value="/ctl/TimeTable/search"/>">TimeTable
														List</a></li>
											</ul></li>
									</ul>







								</c:if>

								<c:if test="${sessionScope.user.roleId==2 }"></c:if>

								<ul class="dropdown-menu ">

									<li><a href="<c:url value="/Javadoc"  />"><span
											class="glyphicon glyphicon-book"></span> &nbsp;Javadoc </a></li>


									<li><a href="<c:url value="/Login" />"><span
											class="glyphicon glyphicon-log-out" style="color: white;"></span> &nbsp;Logout</a></li>

								</ul>

							</ul>



						</div>
					</c:if>

				</c:otherwise>
			</c:choose>

		</ul>
	</div>
</nav>

