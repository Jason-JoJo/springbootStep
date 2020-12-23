<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Todo's for ${name }</title>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Your todos are</caption>
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is it Done?</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.desc }</td>
						<td>${todo.targetDate }</td>
						<td>${todo.done}</td> 
					</tr>
					</c:forEach>
				</tbody>
		</table>
	
	</div>



 <h1>This is ${name }'s todoList</h1>
 <h1> Add todos </h1>
 <a href=/addTodolist> Addtodos </a>
 
</body>
</html>