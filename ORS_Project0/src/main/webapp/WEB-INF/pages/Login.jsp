<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>
<div class="col-sm-offset-2">
	
	<h1 class="col-sm-offset-2">
		<span class="label label-danger">Login</span>
	</h1>

	<br>
	<sf:form method="post" commandName="form" class="form-horizontal">
		<sf:hidden path="id" />

		<c:choose>
			<c:when test="${empty error }">
				<div style="width: 50%; height: 10%;" class="alert alert-danger"
					hidden="">
					<strong>Error !..</strong> ${error}
				</div>

			</c:when>
			<c:otherwise>
				<div style="width: 50%; height: 10%;" class="alert alert-danger">
					<strong>Error !..</strong> ${error}
				</div>

			</c:otherwise>

		</c:choose>



		<div class="form-group">
			<label class="col-md-1"><s:message code="label.emailId" />*</label>


			<div class="col-sm-4">
				<sf:input class="form-control" path="emailId" />
				&nbsp;
				<sf:errors path="emailId" cssClass="error" />
			</div>

		</div>

		<div class="form-group">
			<label class="col-md-1"><s:message code="label.password" />*</label>
			<div class="col-sm-4">
				<sf:password class="form-control" path="password" />
				&nbsp;
				<sf:errors path="password" cssClass="error" />
			</div>
		</div>
		<div class="col-sm-offset-3">
			<button type="submit" name="operation" value="SignIn"
				class="btn btn-primary">SignIn</button>
			&nbsp;&nbsp;
			<button type="reset" name="operation" value="Cancel"
				class="btn btn-primary">Reset</button>

		</div>
		<br>

		<div class="col-sm-offset-3">
			<span><a class="text-danger"
				href="<c:url value="/ForgetPassword" />">Forget password?&nbsp;<span
					class="glyphicon glyphicon-forward"></span>
			</a></span>
		</div>




	</sf:form>
</div>