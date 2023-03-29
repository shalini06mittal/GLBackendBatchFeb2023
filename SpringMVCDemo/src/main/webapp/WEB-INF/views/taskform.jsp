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
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.servletContext.contextPath }/logout">Logout</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.servletContext.contextPath }/admin">Admin
							Page</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<form action="${pageContext.servletContext.contextPath }/admin/task"
			method="POST">
			<c:if test="${task !=null }">
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Task ID</label>
					<input type="text" class="form-control" name="taskid"
						readonly="readonly" value="${task.taskid }">
				</div>
				<div class="mb-3">
					<label for="exampleInputEmail1" class="form-label">Task ID</label>
					<select class="form-select" name="email">
						<option value="default">Assign To</option>
						<c:forEach items="${emailids }" var="email">
						
							<option value="${email }" ${task.email == email ? 'selected' : ''  }>${email }</option>
						</c:forEach>
					</select>
				</div>
			</c:if>

			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Task
					Title</label> <input type="text" class="form-control" name="tasktitle"
					value="${task.tasktitle }"
					id="exampleInputEmail1" aria-describedby="emailHelp">

			</div>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Task Text</label>
				<input type="text" class="form-control" name="tasktext"
				value="${task.tasktext }"
					id="exampleInputEmail1" aria-describedby="emailHelp">
			</div>


			<button type="submit" class="btn btn-primary">Add Task</button>
		</form>
	</div>

</body>
</html>