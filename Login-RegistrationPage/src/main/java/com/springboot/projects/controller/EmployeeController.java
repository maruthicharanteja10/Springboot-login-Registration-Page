package com.springboot.projects.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.projects.dto.LoginEmployee;
import com.springboot.projects.entity.Employee;
import com.springboot.projects.service.EmployeeService;



@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/")
    public String showLoginPage(Model model) {
        if (!model.containsAttribute("loginEmployee")) {
            model.addAttribute("loginEmployee", new Employee()); 
        }
        if (!model.containsAttribute("employee")) {
            model.addAttribute("employee", new Employee()); 
        }
        return "index"; 
    }
	
    @PostMapping("/login")
    public String login(@ModelAttribute("loginEmployee") LoginEmployee loginEmployee, RedirectAttributes redirectAttributes) {  
    String	mssge=employeeService.loginEmployee(loginEmployee);
    if(mssge=="success") {
        return "home";
    }
    redirectAttributes.addFlashAttribute("msge", "Invalid Credntials");
    return "redirect:/";
    }

    @PostMapping("/save")
    public String register(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
    	 if (employeeService.existEmailCheck(employee.getEmail())) {
    	        redirectAttributes.addFlashAttribute("msg", "Email already exists");
    	        return "redirect:/";
    	    }
    	    employeeService.registerEmployee(employee);
    	    redirectAttributes.addFlashAttribute("msg", "Registration Successful");
    	    return "redirect:/";
    }
    @GetMapping("/home")
    public String homepage() {
        return "home";
    }
    
}
