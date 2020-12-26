<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Add Todo List</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		Add  ${name }'s TodoPage 

		<form:form  method="post" modelAttribute="todo">
			<form:hidden path="id"/>
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label> 
				<form:input path="desc" type="text" name="desc" class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning" />
				<form:errors path="desc" cssClass="error" />
				<form:label path="targetDate">targetDate</form:label> 
				<form:input path="targetDate"  name="targetDate" class="form-control" required="required"/>
				<%-- 
				<form:label path="Done">isDone</form:label>
				<select name="Done">
					<option value="true">true</option>
					<option value="false">false</option> 
				</select>
				--%>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>

 <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
 <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
 <script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
 </script>
</body>
</html>