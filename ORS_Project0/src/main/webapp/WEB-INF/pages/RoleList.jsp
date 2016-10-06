<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>

<script type="text/javascript">
	function checkAll(master) {
		var checked = master.checked;
		var col = document.getElementsByTagName("INPUT");
		for (var i = 0; i < col.length; i++) {
			col[i].checked = checked;
		}
	}
</script>
<div>
	<h1>Role List</h1>
	<c:url var="editUrl" value="/ctl/Role?id=" />
	<sf:form method="POST" commandName="form" action="search"
		class="form-inline container  text-center">
		<sf:hidden path="pageNo" />
		<sf:hidden path="pageSize" />

		<div class="forminline">
			<div align="left">
				<label><s:message code="label.role" />*</label>

				<sf:input class="form-control" path="roleName" />
				&nbsp;
				<button type="submit" class="btn btn-primary" name="operation"
					value="Search">
					Search&nbsp;<span class="glyphicon glyphicon-search"></span>
				</button>
			</div>

		</div>


		<br>
		<br>
		<table class="table table-striped table-bordered">

			<c:if test="${!empty list }">
				<tr>
					<th class="col-md-1"><input type="checkbox"
						onclick="checkAll(this)">Select</th>
					<th class="col-md-1">S.No.</th>
					<th class="col-md-2"><s:message code="label.role" /></th>
					<th class="col-md-2"><s:message code="label.description" /></th>
					<th class="col-md-1">Edit</th>
				</tr>



				<c:forEach items="${list }" var="role" varStatus="ct">
					<tr>
						<td><input type="checkbox" name="ids" value="${role.id }"></td>
						<td><c:out
								value="${(form.pageSize*(form.pageNo-1))+ct.index+1}" /></td>
						<td><c:out value="${role.roleName }" /></td>
						<td><c:out value="${role.roleDescription }" /></td>

						<td><a style="color: black;" href="${editUrl }${role.id}"><span
								class="glyphicon glyphicon-pencil"></span>Edit</a>
				</c:forEach>

			</c:if>


		</table>

	</sf:form>


</div>
