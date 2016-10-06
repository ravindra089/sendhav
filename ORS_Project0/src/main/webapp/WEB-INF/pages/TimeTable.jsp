<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>
<div class="col-sm-offset-2">
	<sf:form method="POST" commandName="form" class="form-horizontal">

		<h1 class="col-sm-offset-2">
			<span class="label label-success">Add TimeTable</span>
		</h1>
		<br>
		<c:choose>
			<c:when test="${empty error }">
				<div style="width: 50%; height: 10%;" class="alert alert-danger"
					hidden="">
					<strong>Error !..</strong> ${error }
				</div>
			</c:when>
			<c:otherwise>
				<div style="width: 50%; height: 10%;" class="alert alert-danger">
					<strong>Error !..</strong> ${error }
				</div>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${empty success }">
				<div style="width: 50%; height: 10%;" class="alert alert-success"
					hidden="">
					<strong>Data Saved !..</strong> ${success }
				</div>


			</c:when>
			<c:otherwise>
				<div style="width: 50%; height: 10%;" class="alert alert-success">
					<strong>Data Saved !..</strong> ${success }
				</div>

			</c:otherwise>

		</c:choose>
		<div class="form-group">
			<label class="col-sm-2"> <s:message code="label.userId" />*
			</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="userId" />
				&nbsp;
				<sf:errors path="userId" cssClass="error"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2"><s:message code="label.facultyName" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="facultyName" />
				<sf:errors path="facultyName" cssClass="error"></sf:errors>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2"> <s:message code="label.courseId" />*
			</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="courseId" />
				<sf:errors path="courseId" cssClass="error"></sf:errors>
			</div>
		</div>
<div class="col-sm-offset-3">
			<button type="submit" name="operation" value="Save"
				class="btn btn-primary">Submit</button>
			&nbsp;&nbsp;
			<button type="reset" name="operation" value="Cancel"
				class="btn btn-info">Reset</button>

		</div>
	</sf:form>
</div>