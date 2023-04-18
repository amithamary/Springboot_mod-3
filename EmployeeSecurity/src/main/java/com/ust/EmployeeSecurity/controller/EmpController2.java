package com.ust.EmployeeSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/info2")
public class EmpController2 {
	@GetMapping("/u2")
	public String greeting()
	{
		return"no auth hello";
	}

}
