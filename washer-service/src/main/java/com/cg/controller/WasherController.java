package com.cg.controller;

import java.util.Arrays;
//import java.util.Arrays;
import java.util.List;

//import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestTemplate;

import com.cg.models.OrderDetails;
import com.cg.models.UserRating;
//import com.cg.models.OrderDetails;
//import com.cg.models.UserRating;
import com.cg.models.Washers;
import com.cg.services.WasherService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("origins = \"http://localhost:3000\"")
@RestController
@RequestMapping("/washer")
public class WasherController
{
   
    
    /* Name:Kum Gangyad Roopali
     * EmpId: 46195758
     * Creation Date:22/07/22
     * Modification Date:23/07/22
     * 
     */
	 @Autowired
		private WasherService service;
	 
	 @Autowired
		private RestTemplate restTemplate;
    
    @PostMapping("/addwasher")
    @ApiOperation(value = "To Add washer Details")
    public String saveUser(@RequestBody Washers washer) {
    	 service.save(washer);
    	 return "you Are working With A1A Carwash";
    }

    @PutMapping("/account/update")
    @ApiOperation(value = "To Update washer Details")
    public String updateRegistrationDetails(@RequestBody Washers user, @RequestParam int id) {
    	 service.save(user);
    	 return "update of details Successfull";

    }

    @GetMapping("/allwasher")
    @ApiOperation(value = "To Get all washer Details")
    public List<Washers> findAll(){
    	return service.getWashers();
    }

    @DeleteMapping("/account/delete")
    @ApiOperation(value = "To delete washer ")
    public String deletewasher( @RequestParam int id ) {
    	 this.service.deleteWasher(id);
    	 return "Account Delete Happy to work With you";
    }
    /*------------------ Resttemplates---------------------------- */
    
	@GetMapping("/allratings")
	@ApiOperation(value = "Gets all ")
	public List<UserRating> getwashpacks() {
		String baseurl = "http://localhost:8084/admin/allratings";
		UserRating[] washpack = restTemplate.getForObject(baseurl,UserRating[].class);
		return Arrays.asList(washpack);
	}
	
        
		@GetMapping("/allbooking")
		@ApiOperation(value = "Gets all orders")
		public List<OrderDetails> getallbookings(){
			String baseurl="http://localhost:8081/order/allorders";
			OrderDetails[] allorders=restTemplate.getForObject(baseurl, OrderDetails[].class);
			
			return Arrays.asList(allorders);
   
}
}
