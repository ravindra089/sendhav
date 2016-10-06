<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>


<div class="col-sm-offset-2">

	<sf:form method="POST" commandName="form" class="form-horizontal">
		<sf:hidden path="id" />
		<sf:hidden path="createdBy"></sf:hidden>
		<%-- <sf:hidden path="modifiedBy"></sf:hidden> --%>
		<sf:hidden path="createdDatetime"></sf:hidden>
		<sf:hidden path="modifiedDatetime"></sf:hidden>
		<h1 class="col-sm-offset-2">
			<span class="label label-primary">Add Student</span>
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
			<label class="col-sm-2"><s:message code="label.firstName" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="firstName" />
				&nbsp;
				<sf:errors path="firstName" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2"><s:message code="label.lastName" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="lastName" />
				&nbsp;
				<sf:errors path="lastName" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2"><s:message code="label.dob" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="dob" id="dob"
					readonly="readonly" />
				<a href="javascript:getCalendar(document.forms[0].dob);"> <img
					src="../../img/cal.jpg" width="16" height="15" border="0"
					alt="Calender">
				</a>&nbsp;
				<sf:errors path="dob" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2"><s:message code="label.mobileNo" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="mobileNo" />
				&nbsp;
				<sf:errors path="mobileNo" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2"><s:message code="label.emailId" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="emailId" />
				&nbsp;
				<sf:errors path="emailId" cssClass="error" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2"> <s:message code="label.collegeName" />*
			</label>
			<div class="col-sm-4">
				<sf:select STYLE="width: 150px" size="0" class="form-control"
					path="collegeId">
					<sf:option value="0" label="Select" />
					<sf:options items="${collegeList }" itemLabel="name" itemValue="id" />

				</sf:select>
				&nbsp;
				<sf:errors path="collegeId" cssClass="error" />
			</div>
		</div>
		<div class="col-sm-offset-3">
			<button type="submit" name="operation" value="Save"
				class="btn btn-primary">Submit</button>
			&nbsp;&nbsp;
			<button type="submit" name="operation" value="Cancel"
				class="btn btn-danger">Cancel</button>

		</div>

	</sf:form>
</div>

