package com.mmm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmm.model.User;
import com.mmm.service.UserService;

@Controller
@RequestMapping("/userController")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/{id}/showUser")
	public String showUser(@PathVariable String id, HttpServletRequest request) {
		User u = userService.getUserById(id);
		request.setAttribute("user", u);
		return "showUser";
	}
	@RequestMapping("/getAll")
	public String getAll(HttpServletRequest request) {
		request.setAttribute("userList", this.userService.getAll());
		return "showUser";
	}
	@RequestMapping("/{name}/saveUser")
	public String saveUser(@PathVariable String name,HttpServletRequest request) {
		try {
			this.userService.save(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("name", name);
		return "showUser";
	}

}
