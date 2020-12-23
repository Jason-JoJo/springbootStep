<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
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

		<form  method="post">
			<fieldset class="form-group">
				<label>Description</label> 
				<input type=text name="desc" class="form-control" required="required"/>
			</fieldset>
			<button type="submit" class="btn btn-success">Add</button>
		</form>

	</div>	
 <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
 <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>