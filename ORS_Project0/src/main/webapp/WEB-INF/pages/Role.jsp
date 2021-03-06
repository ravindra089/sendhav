<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@page isELIgnored="false"%>

<div class="col-sm-offset-2">
	<sf:form method="POST" commandName="form" class="form-horizontal">
		<sf:hidden path="id" />

		<sf:hidden path="createdBy"></sf:hidden>
		<%-- <sf:hidden path="modifiedBy"></sf:hidden> --%>
		<sf:hidden path="createdDatetime"></sf:hidden>
		<sf:hidden path="modifiedDatetime"></sf:hidden>



		<h1 class="col-sm-offset-2">
			<span class="label label-primary">Add Role</span>
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
			<label class="col-sm-2"><s:message code="label.role" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="roleName" />
				&nbsp;
				<sf:errors path="roleName" cssClass="error" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2"><s:message code="label.description" />*</label>
			<div class="col-sm-4">
				<sf:textarea class="form-control" path="roleDescription" rows="3"
					cols="2" />
				<%-- <sf:input class="form-control" path="roleDescription" /> --%>
				&nbsp;
				<sf:errors path="roleDescription" cssClass="error" />
			</div>
		</div>



		<div class="col-sm-offset-4">
			<button type="submit" class="btn btn-primary" name="operation"
				value="Save">Save</button>

			<button type="submit" class="btn btn-primary" name="operation"
				value="Cancel">Cancel</button>


		</div>

	</sf:form>



</div>

