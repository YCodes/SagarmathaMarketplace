package com.sagarmatha.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.sagarmatha.domain.Admin;
import com.sagarmatha.domain.Customer;
import com.sagarmatha.domain.Vendor;
import com.sagarmatha.util.EmailService;


@Aspect
public class AspectClass {

	@Autowired
	EmailService emailService;
   
	/*Email after admin signup*/
	
	
	@After("execution( * com.sagarmatha.controller.AdminController.addAdmin(..)) && args(admin, result)")
    public void traceMethodForAdmin(Admin admin, BindingResult result){

    	if(result.hasErrors()) {
    		 emailService.sendEmailNotification(admin.getEmail(), "Error","Sorry this email already exist");
    	}
    	else {
    		System.out.println("AOP CALLED###########" +admin.getEmail());
    		String body = "Welcome "+admin.getFirstName()+" "+admin.getLastName()+" to Sagarmatha Marketplace"+"\n"+" Your username is: "+" "+ admin.getEmail();
            emailService.sendEmailNotification(admin.getEmail(), "Welcome from Sagarmatha",body);
    	} 	
       
    } 
	

	/*Email after customer signup*/

    @After("execution( * com.sagarmatha.controller.CustomerController.saveCustomer(..)) && args(customer, result)")
    public void traceMethodForCustomer(Customer customer, BindingResult result){

    	if(result.hasErrors()) {
    		 emailService.sendEmailNotification(customer.getEmail(), "Error","Sorry this email already exist");
    	}
    	else {
    		System.out.println("AOP CALLED###########" +customer.getEmail());
    		String body = "Welcome "+customer.getFirstName()+" "+customer.getLastName()+" to Sagarmatha Marketplace"+"\n"+" Your username is: "+" "+ customer.getEmail();
            emailService.sendEmailNotification(customer.getEmail(), "Welcome from Sagarmatha",body);
    	} 	
       
    } 
    

	/*Email after vendor signup*/
    
    @After("execution( * com.sagarmatha.controller.VendorController.addVendorSignup(..)) && args(vendor, result,model)")
    public void traceMethodForVendor(Vendor vendor, BindingResult result, ModelMap model){

    	if(result.hasErrors()) {
    		 emailService.sendEmailNotification(vendor.getEmail(), "Error","Sorry this email already exist");
    	}
    	else {
    		System.out.println("AOP CALLED###########" +vendor.getEmail());
    		String body = "Welcome "+vendor.getFirst_name()+" "+vendor.getLast_name()+" to Sagarmatha Marketplace"+"\n"+" Your username is: "+" "+ vendor.getEmail();
            emailService.sendEmailNotification(vendor.getEmail(), "Welcome from Sagarmatha",body);
    	} 	
       
    } 
    
}
