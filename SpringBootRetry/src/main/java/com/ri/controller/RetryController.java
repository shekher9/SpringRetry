package com.ri.controller;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ri.service.RetryService;

@RestController
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
@RequestMapping("retry")
public class RetryController {
	@Autowired(required = true)
	private RetryService retryService;
	
	@GetMapping("/dept/{id}")
	public String getDepartment(@PathParam (value = "id") Integer id) {
		
		return retryService.getResponce(id);
	}
	
	
	

}
