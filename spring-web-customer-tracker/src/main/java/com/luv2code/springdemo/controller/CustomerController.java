package com.luv2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	/////////////////// we delete this lines in video 290
	
	//	// need to inject the customer dao
	//	@Autowired
	//	private CustomerDAO customerDAO;
	
	////////////////////////////////////
	
	
	@InitBinder//דודו ַּֿ
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor= new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
		}
	
	
	// need to inject the customer service 
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/showMyLogin")
	public String loginPage() {
		
		return"fancy-login";
	}
	
	
	@GetMapping("/list")// we add this GetMapping to allow us to use the spring get method
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")// exactly the same name in the list-Customer.jsp
	public String showFormForAdd(Model theModel) {
		
		//create new model attribute for bind from data 
		Customer theCustomer= new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return"customer-form";
	}
	
	@PostMapping("/saveCustomer")//exactly the same name for saveCustomer in the customer-form.jsp (<form:form action="saveCustomer" modelAttribute="customer" method="POST">)
	public String saveCustomer( //here we add all the the validition for the page
			@Valid@ModelAttribute("customer") Customer theCustomer, 
			BindingResult theBindingResult){
				
			if (theBindingResult.hasErrors()) {
				return "customer-form";
			}else {
			
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";// redirect here mean thet will take it to the direct of the main page customer list 
	}
			}
	
	
	@GetMapping("/showFormForUpdate")// exactly the same name in the list-Customer.jsp for update
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
	//get the customer from the service  
		Customer theCustomer=customerService.getCustomer(theId);
		
	//set the customer as a model attribute to per-populate the form 
		theModel.addAttribute("customer",theCustomer);//the customer in theModel.addAttribute("customer",theCustomer) should be exactly like the same in customer-form.jsp :
																			//<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
	// send it to the form	
	return "customer-form";	
		
	}
	
	@GetMapping("/delete")// exactly the same name in the list-Customer.jsp for update
	public String delete(@RequestParam("customerId") int theId) {
	//get the customer from the service  
		customerService.deleteCustomer(theId);
		
	
		
		return "redirect:/customer/list";	
	
}
	
	 @PostMapping("/search")
	 public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
	                      Model theModel) {


		 	// search customers from the service
	 		List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
	
	 		// add the customers to the model
	 		theModel.addAttribute("customers", theCustomers);

	 		return "list-customers";
	}
	
}




