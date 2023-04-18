package com.ust.EmployeeSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emp/sec")
public class EmpController {
	@GetMapping("/info")
	public String greeting()
	{
		return"hello";
	}

}
