<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@page isELIgnored="false"%>

<div class="col-sm-offset-2">

	<sf:form   id="sandbox-container" method="POST" commandName="form" class="form-horizontal">
		<sf:hidden path="id" />
		<sf:hidden path="lastLogin"></sf:hidden>
		<sf:hidden path="registeredIP"></sf:hidden>
		<sf:hidden path="createdBy"></sf:hidden>
		<%-- <sf:hidden path="modifiedBy"></sf:hidden> --%>
		<sf:hidden path="createdDatetime"></sf:hidden>
		<sf:hidden path="modifiedDatetime"></sf:hidden>
		<sf:hidden path="roleId"></sf:hidden>

		<h1 class="col-sm-offset-2">
			<span class="label label-warning">Add User</span>
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
			<label class="col-sm-2"><s:message code="label.login" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="login" />
				&nbsp;
				<sf:errors path="login" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2"><s:message code="label.password" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="password" type="password"
					id="password" />
				&nbsp;
				<sf:errors path="password" cssClass="error" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2"><s:message code="label.password" />*</label>
			<div class="col-sm-4">
				<sf:input class="form-control" path="password" type="password"
					id="password" />
				&nbsp;
				<sf:errors path="password" cssClass="error" />
			</div>
		</div>
		
		
		
		
		
		 <div class="form-group">
            <sf:label path="dob" class="col-sm-2 control-label">
                    <s:message code="label.dob"></s:message>
                </sf:label>
                <div class="col-sm-5">
            <sf:input  path="dob" class="form-control" id="dob" />
           
        </div>
         <sf:errors path="dob"  cssClass="error" class="control-label text-danger" for="inputError1"  />
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
			<label class="col-sm-2"> <s:message code="label.role" />*
			</label>

			<div class="col-sm-4">
				<sf:select STYLE="width: 150px" size="0" class="form-control"
					path="roleId">


					<%-- <sf:options items="${roleList }" itemValue="id"
						itemLabel="roleName" /> --%>

					<c:forEach items="${roleList }" var="role">
						<sf:option value="${ role.id}" >
							<c:out value=" ${role.roleName }"></c:out>
						</sf:option>
					</c:forEach>
				</sf:select>

				&nbsp;
				<sf:errors path="roleId" cssClass="error" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2"><s:message code="label.gender" />*</label>
			<div class="col-sm-4">
				<sf:radiobutton path="gender" value="Male" />
				Male
				<sf:radiobutton path="gender" value="Female" />
				Female &nbsp;
				<sf:errors path="gender" cssClass="error" />
			</div>
		</div>

		<div class="col-sm-offset-3">
			<button type="submit" name="operation" value="Save"
				class="btn btn-primary">Submit</button>
			&nbsp;&nbsp;
			<button type="reset" name="operation" value="Cancel"
				class="btn btn-primary">Reset</button>

		</div>


	</sf:form>


</div>
<script>
    $(function() {
        $("#dob").datepicker();
    });
</script>
