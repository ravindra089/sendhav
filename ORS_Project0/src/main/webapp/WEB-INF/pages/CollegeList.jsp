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
		for ( var i = 0; i < col.length; i++) {
			col[i].checked = checked;
		}
	}
</script>

<body>
	<div>
		<h1>College List</h1>
		<c:url var="editUrl" value="/ctl/College?id=" />
		<c:url var="editUrl2" value="/ctl/College/search?pageNo=" />
		<sf:form action="search" method="POST" commandName="form"
			class="form-inline container  text-center">

			<sf:hidden path="pageNo" />
			<sf:hidden path="pageSize" />

			<div align="left" class="forminline">
				<div>
					<label><s:message code="label.name" />*</label>

					<sf:input class="form-control" path="name" />

					&nbsp; <label><s:message code="label.city" />*</label>
					<sf:input path="city" class="form-control" />
					&nbsp;
					<button type="submit" class="btn btn-info" name="operation"
						value="Search ">
						Search ! Here&nbsp;<span class="glyphicon glyphicon-search"></span>
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
						<th class="col-md-2"><s:message code="label.name" /></th>
						<th class="col-md-2"><s:message code="label.address" /></th>
						<th class="col-md-2"><s:message code="label.state" /></th>
						<th class="col-md-2"><s:message code="label.city" /></th>
						<th class="col-md-2"><s:message code="label.phoneNo" /></th>
						<th class="col-md-1">Edit</th>
					</tr>



					<c:forEach items="${list }" var="collegeList" varStatus="ct">
						<tr>
							<td><input type="checkbox" name="ids"
								value="${collegeList.id }"></td>
							<td><c:out
									value="${(form.pageSize*(form.pageNo-1))+ct.index+1}" /></td>
							<td><c:out value="${collegeList.name }" /></td>
							<td><c:out value="${collegeList.address }" /></td>
							<td><c:out value="${collegeList.state }" /></td>
							<td><c:out value="${collegeList.city }" /></td>
							<td><c:out value="${collegeList.phoneNo }" /></td>
							<td><a style="color: black;"
								href="${editUrl }${collegeList.id}"><span
									class="glyphicon glyphicon-pencil"></span>Edit</a>
					</c:forEach>

				</c:if>
			</table>
			<c:forEach begin="1" end="${ noOfPage}" var="i">
				<a style="color: black;" href="${editUrl2 }${i}"><c:out value="${i }" /></a>


			</c:forEach>

		</sf:form>



	</div>