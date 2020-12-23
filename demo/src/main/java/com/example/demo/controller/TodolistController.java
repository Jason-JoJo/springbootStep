package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Todo;
import com.example.demo.service.LoginService;
import com.example.demo.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodolistController {
	
	@Autowired
	TodoService todoService;
	
	
	@RequestMapping(value="/todolist",method = RequestMethod.GET)
	public String showTodo(ModelMap model) {
		String name = (String)model.get("name");
//	
		model.put("todos", todoService.retrieveTodos(name));
		return "todolist";
	}

	@RequestMapping(value="/addTodolist",method = RequestMethod.GET)
	public String showTodos(ModelMap model) {
//		String name = (String)model.get("name");
		model.addAttribute("todo", new Todo(0, (String) model.get("name"), "Default Desc",
				new Date(), false));
//		model.put("todos", todoService.retrieveTodos(name));
		return "todo";
	}
	@RequestMapping(value="/addTodolist",method = RequestMethod.POST)
	public String addTodo(ModelMap model,Todo todo) {
//		String name = (String)model.get("name");	// 因為有 @SessionAttributes("name") 已經加進Session 所以可以取道name
		todoService.addTodo((String)model.get("name"),  todo.getDesc(), new Date(), false);
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
		todoService.deleteTodo(id);
		
		return "redirect:/todolist";
	}
	
	
}
