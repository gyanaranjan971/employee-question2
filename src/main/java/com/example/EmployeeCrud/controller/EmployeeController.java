package com.example.EmployeeCrud.controller;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.EmployeeCrud.domain.Employee;
import com.example.EmployeeCrud.service.EmployeeService;

@Controller
public class EmployeeController {
@Autowired

private EmployeeService service;
@GetMapping("/")
public String viewHomePage(Model model) {
	List<Employee>listemployee=service.listAll();
	model.addAttribute("listemployee", listemployee);
	System.out.print("Get / ");
	return "index";
}
@GetMapping("/new")
public String add(Model model) {
	model.addAttribute("employee",new  Employee());
	return "new";
}
@RequestMapping(value="/save",method=RequestMethod.POST)
public String saveEmployee(@ModelAttribute("employee")Employee emp) {
	service.save(emp);
	return "redirect:/";
}
@RequestMapping("/edit/{id}")
public ModelAndView showEditEmployeePage(@PathVariable(name="id")long id) {
	ModelAndView mav=new ModelAndView("new");
	Employee emp=service.get(id);
	return mav;
	
}
@RequestMapping("/delete/{id}")
public String deleteemployee(@PathVariable(name="id")int id) {
	service.delete(id);
	return  "redirect:/";
}

}
