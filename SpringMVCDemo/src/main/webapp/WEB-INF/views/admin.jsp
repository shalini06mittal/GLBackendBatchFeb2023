<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.error {
	color: red;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">CMS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
					<%
					String id = (String) session.getAttribute("email");
		
					if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register">Register</a>
					</li>
					<%
					}
					if (id != null) {
					%>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/admin/task">Add
							New Task</a></li>
					<li class="nav-item"><a class="nav-link" href="users">View
							All Users</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Task Title</th>
					<th scope="col">Task Text</th>
					<th scope="col">Task Completed</th>
					<th scope="col">Assigned To</th>
					<th scope="col">EDIT/ DELETE</th>
				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks }" var="task">
					<tr>
						<td>${task.tasktitle }</td>
						<td>${task.tasktext }</td>
						<c:if test="${task.taskcompleted}">
							<td>YES</td>
						</c:if>
							
						<c:if test="${!task.taskcompleted }">
							<td>NO</td>
						</c:if>
							
						<c:if test="${task.email == null}">
							<td>NOT ASSIGNED</td>
						</c:if>
						<td>${task.email }</td>
						<td><a href="${pageContext.servletContext.contextPath }/admin/edit/${task.taskid }">Edit</a>
						<a href="${pageContext.servletContext.contextPath }/admin/delete/${task.taskid }"><i class="fa fa-trash"></i></a></td>
					</tr>
				</c:forEach>


			</tbody>
		</table>
	</div>



</body>
</html>