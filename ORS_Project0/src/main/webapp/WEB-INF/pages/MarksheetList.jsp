<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@ page isELIgnored="false"%>
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
	<h1>Marksheet List</h1>
	<c:url var="editUrl" value="/ctl/Marksheet?id=" />
	<sf:form action="search" method="POST" commandName="form"
		class="form-inline container  text-center">

		<sf:hidden path="pageNo" />
		<sf:hidden path="pageSize" />

		<div align="left" class="forminline">
			<div>


				<label><s:message code="label.name" />*</label>

				<sf:input class="form-control" path="name" />

				&nbsp; <label><s:message code="label.rollNo" />*</label>
				<sf:input path="rollNo" class="form-control" />
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
					<th class="col-md-2"><s:message code="label.rollNo" /></th>
					<th class="col-md-2"><s:message code="label.name" /></th>
					<th class="col-md-2"><s:message code="label.physics" /></th>
					<th class="col-md-2"><s:message code="label.chemistry" /></th>
					<th class="col-md-2"><s:message code="label.maths" /></th>
					<th class="col-md-1">Edit</th>
				</tr>



				<c:forEach items="${list }" var="marksheet" varStatus="ct">
					<tr>
						<td><input type="checkbox" name="ids"
							value="${marksheet.id }"></td>
						<td><c:out
								value="${(form.pageSize*(form.pageNo-1))+ct.index+1}" /></td>
						<td><c:out value="${marksheet.rollNo }" /></td>
						<td><c:out value="${marksheet.name }" /></td>
						<td><c:out value="${marksheet.physics }" /></td>
						<td><c:out value="${marksheet.chemistry }" /></td>
						<td><c:out value="${marksheet.maths }" /></td>
						<td><a style="color: black;"
							href="${editUrl }${marksheet.id}"><span
								class="glyphicon glyphicon-pencil"></span>Edit</a>
				</c:forEach>

			</c:if>
		</table>


	</sf:form>



</div>
