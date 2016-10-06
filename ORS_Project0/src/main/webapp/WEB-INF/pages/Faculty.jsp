<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="col-sm-offset-2">
		<sf:form commandName="form" method="POST" class="form-horizontal">

			<sf:hidden path="id" />
			<sf:hidden path="createdBy" />
			<%-- <sf:hidden path="modifiedBy" /> --%>
			<sf:hidden path="createdDatetime"></sf:hidden>
			<sf:hidden path="modifiedDatetime"></sf:hidden>

			<h1 class="col-sm-offset-2">
				<span class="label label-primary">Add Faculty</span>
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
				<label class="col-sm-2"> <s:message code="label.facultyName" />*
				</label>
				<div class="col-sm-4">
					<sf:select path="userId" class="form-control">
						<sf:option value="0" label="Select">Select</sf:option>
						<sf:options items="${userList }" itemValue="id"
							itemLabel="" />
					</sf:select>
					&nbsp;
					<sf:errors cssClass="error" path="userId"></sf:errors>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2"> <s:message code="label.collegeName" />*
				</label>

				<div class="col-sm-4">
					<sf:select path="collegeId" class="form-control">
						<sf:option value="0" label="Select">Select</sf:option>
						<sf:options items="${colList }" itemValue="id" itemLabel="name" />
					</sf:select>
					&nbsp;
					<sf:errors path="collegeId" cssClass="error"></sf:errors>
				</div>
			</div>

			<div class="col-sm-offset-3">
				<button class="btn btn-primary" name="operation" value="Save"
					type="submit">Submit</button>
				&nbsp;&nbsp;
				<button class="btn btn-primary" name="operation" value="Cancel"
					type="submit">Cancel</button>
			</div>

		</sf:form>

	</div>
</body>
</html>