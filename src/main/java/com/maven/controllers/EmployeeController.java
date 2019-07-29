package com.maven.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.maven.models.Employee;
import com.maven.services.EmployeeService;
import com.maven.services.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;
	private Gson gson = new Gson();

//	@RequestMapping(value = "/employees", method = RequestMethod.GET)
//	public String showList(ModelMap model) {
//		List employee_list = employeeService.getAll();
//		model.addAttribute("employees", employee_list);
//		return "employees";
//	}
 /// REST API Functions  
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> employees(){
		JSONObject response=new JSONObject();
		
			List<Employee> employees=employeeService.getAll();
			String empList=gson.toJson(employees);
			return new ResponseEntity<String>(empList, HttpStatus.OK);
		
		
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		JSONObject response=new JSONObject();
		try {
			Employee emp = new Employee(employee.getName(), employee.getLastName(),  employee.getBirthDate(), employee.getRole(), employee.getDepartment(), employee.getEmail());
			
			employeeService.add(emp);
			response.put("inserted",emp);
		} catch(Exception ex) {
			response.put("error", ex.toString());
		}
		
		return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
	}
	@RequestMapping(value = "/view", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<String> view(@RequestParam Double id) {
		
		Employee emp = employeeService.get(id);
		String empJson = gson.toJson(emp);
		
		return new ResponseEntity<String>(empJson, HttpStatus.OK);
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces="application/json")
	public ResponseEntity<String> updateEmployee(@RequestParam Double id, @RequestBody Employee employee) {
		JSONObject response = new JSONObject();
		try {
			
			Employee emp = employeeService.get(id);
			emp.setName(employee.getName());
			emp.setLastName(employee.getLastName());
			emp.setBirthDate(employee.getBirthDate());
			emp.setRole(employee.getRole());
			emp.setDepartment(employee.getDepartment());
			emp.setEmail(employee.getEmail());
			employeeService.update(emp);
			response.put("updated",emp);
		} catch(Exception ex) {
			response.put("error", ex.toString());
		}
		
		return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces="application/json")
	public ResponseEntity<String> delete(@RequestParam("id") Double id) {
		JSONObject response = new JSONObject();
		try {
		
			employeeService.delete(id);
			response.put("deleted", "true");
		}
		catch(Exception ex) {
			response.put("error", ex.toString());
		}
		
		return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
	}
	
	
	
	
	//  REST API Ends 
	
	
	
//	
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String addEmployee(Model model) {
//		System.out.println("Request to open the new user form page");
//		model.addAttribute("employeeAttr", new Employee());
//		return "add";
//	}
//	
//
//	@RequestMapping(value = "save", method = RequestMethod.POST)
//	public String save(@ModelAttribute("employeeAttr") @Valid Employee employee, BindingResult result, ModelMap model) {
//		if (result.hasErrors()) {
//			return "add";
//		}
//		System.out.println("Incoming employee id:" + employee.getId());
//		if (employee.getId() == 0.0d) {
//			System.out.println("Edit");
//		} else {
//			System.out.println("Add....");
//			employeeService.add(employee);
//			System.out.println("Employee added");
//		}
//		return "redirect:employees";
//	}
//
//	@RequestMapping(value = "/view", method = RequestMethod.GET)
//	public String viewEmployee(ModelMap model, @RequestParam Double id) {
//		System.out.println("View the employee individually");
//		Employee employee = employeeService.get(id);
//		model.addAttribute("employee", employee);
//
//		return "view";
//	}
//	
//
//	@RequestMapping(value = "/update", method = RequestMethod.GET)
//	public String updateEmployee(ModelMap model, @RequestParam Double id) {
//		System.out.println("View the employee individually");
//		Employee employee = employeeService.get(id);
//		model.addAttribute("employee", employee);
//		model.addAttribute("id", id);
//		System.out.println("Id going from updateEmployee method in controller: " + employee.getId());
//		System.out.println(employee); // correct
//		return "update";
//	}
//
//	@RequestMapping(value = "/updated", method = RequestMethod.POST)
//	public String updateEmployee(@ModelAttribute("employee") Employee employee, BindingResult result) {
//		if (result.hasErrors()) {
//			return "update";
//		}
//		System.out.println("Id coming to /updated - " + employee.getId());
//		if (employee.getId() == 0.0d) {
//			System.out.println("Edit");
//		} else {
//			System.out.println("Update");
//			employeeService.update(employee);
//			System.out.println("Employee updated");
//		}
//		return "redirect:employees";
//	}
//
//	
//
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String deleteEmployee(@RequestParam Double id) {
//		employeeService.delete(id);
//
//		return "redirect:employees";
//	}

}