package com.prakash.todolist.controller;

import com.prakash.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public ModelAndView showTodos(ModelMap model){
		String name = (String) model.get("name");

		ModelAndView m = new ModelAndView();
		m.setViewName("list-todos");
		m.addObject("todos", todoService.retrieveTodos(name));
		return m;
	}
}
