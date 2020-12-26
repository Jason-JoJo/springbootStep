<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Todo's for ${name }</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<caption>${name } ， Your todos are</caption>
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is it Done?</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.desc }</td>
						<td><fmt:formatDate value="${todo.targetDate }" pattern="yyyy/MM/dd"/></td>
						<td>${todo.done}</td>
						<td><a type="Button" class="btn btn-success" href="/update-todo?id=${todo.id }">update</a></td> 
						<td><a type="Button" class="btn btn-warning" href="/delete-todo?id=${todo.id }">Delete-${todo.id }</a></td>
					</tr>
					</c:forEach>
				</tbody>
		</table>
	
	</div>



 <h1>This is ${name }'s todoList</h1>
 <h1> Add todos </h1>
 <a href=/addTodolist> Addtodos </a>
 
 <div> <a class="button" href="/addTodolist">Add a Todo</a></div>
 
 <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
</body>
</html>