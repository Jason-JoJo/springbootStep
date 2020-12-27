package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodolistController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@Autowired
	TodoService todoService;
	
	
	@RequestMapping(value="/todolist",method = RequestMethod.GET)
	public String showTodo(ModelMap model) {
		String name = getLoggedInUserName(model);
//	
		model.put("todos", todoService.retrieveTodos(name));
		return "todolist";
	}

	@RequestMapping(value="/addTodolist",method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
//		String name = (String)model.get("name");
		model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "Default Desc",
				new Date(), false));
//		model.put("todos", todoService.retrieveTodos(name));
		return "todo";
	}
	@RequestMapping(value="/addTodolist",method = RequestMethod.POST)
	public String addTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
//		String name = (String)model.get("name");	// 因為有 @SessionAttributes("name") 已經加進Session 所以可以取道name
		todoService.addTodo(getLoggedInUserName(model),  todo.getDesc(), todo.getTargetDate(), todo.isDone());
//		model.put("todos", todoService.retrieveTodos(name));
//		return "todolist";   //影片裡用這個返回會使 list 空白，但實際使用卻不會 因為我自己加了上面的。 (forward 不會傳參數)；  兩者有差別  forward  url是  http://localhost:8080/addTodolist
		return "redirect:/todolist";	//   redirect重導後  http://localhost:8080/todolist
	}
	
	/**
	 * redirect 的 HTTP 返回碼是 302，且跳轉的新 URL 會存儲在 HTTP Response Headers 的 Location 字段中。
	 * 客戶端在接收到 Response 後，會發起另一次請求，這次請求的 URL 就是重定向的 URL；
	 * 
	 * forward 的轉發過程只發生在服務端；Servlet 容器會直接把源請求打向目標 URL，而不會經由客戶端發起請求；
	 * 因此客戶端接收到的響應是來自轉發後的目標方法，但是瀏覽器呈現的 URL 卻並不會改變，且 forward 不能將參數轉發出去。
	 *  
	 */
	
	
	
	@RequestMapping(value="/delete-todo",method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		if(id==1)
			throw new RuntimeException("Something went wrong");
		
		todoService.deleteTodo(id);
		
		return "redirect:/todolist";
	}
	
	
//	@RequestMapping(value="/addsTodolist",method = RequestMethod.POST)
//	public String addsTodo(ModelMap model,Todo todo) {
//		todoService.addTodo((String)model.get("name"),  todo.getDesc(), new Date(), true);
//		return "redirect:/todolist";	//   redirect重導後  http://localhost:8080/todolist
//	}
	
	@RequestMapping(value="/update-todo",method = RequestMethod.GET)
	public String showUpdateTodo(@RequestParam int id,ModelMap model) {
		System.out.println(" in GET show update");
		Todo todo = todoService.retrieveTodo(id);
		model.put("todo",todo);
		
		return "todo";
	}
	
	@RequestMapping(value="/update-todo",method = RequestMethod.POST)
	public String updateTodo(ModelMap model,@Validated Todo todo,BindingResult result) {
		System.out.println(" in POST show update");
		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName(model));
		
		todoService.updateTodo(todo);
		
		return "redirect:/todolist";
	}

	private String getLoggedInUserName(ModelMap model) {
		return (String)model.get("name"); 
	}
	

	
}
