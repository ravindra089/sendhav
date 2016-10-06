<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page isELIgnored="false"%>
<script type="text/javascript">
	function checkAll(master) {
		var checked = master.checked;
		var col = document.getElementsByTagName("INPUT");
		for ( var i = 0; i < col.length; i++) {
			col[i].checked = checked;
		}
	}
</script>
<div>
	<h1>Student List</h1>
	<c:url var="editUrl" value="/ctl/Student?id=" />
	<sf:form action="search" method="POST" commandName="form"
		class="form-inline container  text-center">

		<sf:hidden path="pageNo" />
		<sf:hidden path="pageSize" />

		<div align="left" class="forminline">
			<div>
				<label><s:message code="label.firstName" />*</label>

				<sf:input class="form-control" path="firstName" />

				&nbsp; <label><s:message code="label.lastName" />*</label>
				<sf:input path="lastName" class="form-control" />
				&nbsp;
				<button type="submit" class="btn btn-success" name="operation"
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
					<th class="col-md-2"><s:message code="label.firstName" /></th>
					<th class="col-md-2"><s:message code="label.lastName" /></th>
					<th class="col-md-2"><s:message code="label.email" /></th>
					<th class="col-md-2"><s:message code="label.mobileNo" /></th>
					<th class="col-md-2"><s:message code="label.collegeName" /></th>
					<th class="col-md-2"><s:message code="label.dob" /></th>
					<th class="col-md-1">Edit</th>
				</tr>



				<c:forEach items="${list }" var="student" varStatus="ct">
					<tr>
						<td><input type="checkbox" name="ids" value="${student.id }"></td>
						<td><c:out
								value="${(form.pageSize*(form.pageNo-1))+ct.index+1}" /></td>
						<td><c:out value="${student.firstName }" /></td>
						<td><c:out value="${student.lastName }" /></td>

						<td><c:out value="${student.email }" /></td>
						<td><c:out value="${student.mobileNo }" /></td>
						<td><c:out value="${student.collegeName }" /></td>
						<td><c:out value="${student.dob }" /></td>
						<td><a style="color: black;" href="${editUrl }${student.id}"><span
								class="glyphicon glyphicon-pencil"></span>Edit</a>
				</c:forEach>

			</c:if>
		</table>
		<%-- <c:forEach items="${list}" var="studentList" varStatus="ct">
			<tr>
				<td><input type="checkbox" name="ids"
					value="#{studentList.id }"></td>
				<td><c:out
						value="${(form.pazeSize*(form.pazeNo-1))+ctl.index+1}"></c:out></td>
				<td><c:out value="${studentList.firstName}"></c:out></td>
				<td><c:out value="${studentList.lastName}"></c:out></td>
				<td><c:out value="${studentList.dob}"></c:out></td>
				<td><c:out value="${studentList.mobileNo}"></c:out></td>
				<td><c:out value="${studentList.email}"></c:out></td>
				<td><c:out value="${studentList.collegeName}"></c:out></td>
				<td><a style="color: black;"
					href="${editUrl }${studentList.id}"> <span
						class="glyphicon glyphicon-pencil"></span> Edit
				</a></td>
			
		</c:forEach> --%>

		<!-- <div class="col-sm-offset2 col-sm-10">
			<button type="submit" class="btn btn-primary" name="operation"
				value="Save">Save</button>
			<button type="submit" class="btn btn-primary" name="operation"
				value="Cancel">Cancel</button>


			<button type="submit" class="btn btn-primary" name="operation"
				value="Delete">Delete</button>
		</div> -->
		<c:forEach begin="1" end="${ noOfPage}" var="i">
			<a style="color: black;" href="${editUrl2 }${i}"><c:out
					value="${i }" /></a>


		</c:forEach>
	</sf:form>



</div>