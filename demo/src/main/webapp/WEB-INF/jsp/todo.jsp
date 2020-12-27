<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		Add  ${name }'s TodoPage 

		<form:form  method="post" modelAttribute="todo">
			<form:hidden path="id"/>
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label> 
				<form:input path="desc" type="text" name="desc" class="form-control" required="required"/>
				<form:errors path="desc" cssClass="text-warning" />
				<form:errors path="desc" cssClass="error" />
				
			</fieldset>
			<fieldset class="form-group">
				<form:label path="targetDate">targetDate</form:label> 
				<form:input path="targetDate"  name="targetDate" class="form-control" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning" />
				<form:errors path="targetDate" cssClass="error" />
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
	
<%@ include file="common/foot.jspf" %>