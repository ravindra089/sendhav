<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>


<title>Project0</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<script type="text/javascript" src="../../css/js/jquery.min.js"></script>
<script type="text/javascript" src="../../css/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../css/js/calendar.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>


<style type="text/css">
.error {
	color: green;
	font-weight: bold;
}

.success {
	color: green;
	font-weight: bold;
}

a:HOVER {
	color: green;
}

.nav>li>a:focus,.nav>li>a:hover {
	background-color: white;
	color: green;
}

a {
	color: white;
}
</style>
<title></title>
</head>
<body>
	<table cellspacing="2" align="center" width="100%">
		<tr>
			<td valign="top" colspan="2" height="100px"><tiles:insertAttribute
					name="header"></tiles:insertAttribute></td>
		</tr>
		<tr>
			<td style="background-color: white;" width="20%" colspan="0"
				height="400px" valign="top"><tiles:insertAttribute name="menu"></tiles:insertAttribute></td>
			<td colspan="2" height="400px" valign="top"><tiles:insertAttribute
					name="body"></tiles:insertAttribute></td>
		</tr>
		<tr>
			<td valign="bottom" colspan="2" align="center"><tiles:insertAttribute
					name="footer"></tiles:insertAttribute></td>
		</tr>
	</table>


</body>
</html>