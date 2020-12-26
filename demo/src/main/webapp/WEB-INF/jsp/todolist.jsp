<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<table class="table table-striped">
			<caption>${name }, Your todos are</caption>
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
 
<%@ include file="common/foot.jspf" %>