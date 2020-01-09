package com.ri.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ri.exception.RemoteServiceNotAvalableException;
import com.ri.response.DepartmentResponse;

@Service("retryService")
public class RetryServiceImpl implements RetryService {

	/*
	 * @Override public String getResponce(boolean simulateretry, boolean
	 * simulateretryfallback) {
	 * 
	 * if (simulateretry) { System.out.
	 * println("Simulateretry is true, so try to simulate exception scenario.");
	 * 
	 * if (simulateretryfallback) { throw new RemoteServiceNotAvalableException(
	 * "Don't worry!! Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!"
	 * ); } int random = new Random().nextInt(4);
	 * 
	 * System.out.println("Random Number : " + random); if (random % 2 == 0) { throw
	 * new
	 * RemoteServiceNotAvalableException("Don't worry!! Just Simulated for Spring-retry.."
	 * ); } }
	 * 
	 * return "Hello from Remote Backend!!!"; }
	 */
	@Override
	public String getResponceFallback() {
		System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";

	}

	@Override
	public String getResponce(Integer id) {
		if(id!=15) {
			URI uri;
			String msg;
			try {
				uri = new URI("http://localhost:4020/dept/fechdeparmentresponce/"+id);
				RestTemplate templet=new RestTemplate();
				ResponseEntity<DepartmentResponse> response=templet.getForEntity(uri, DepartmentResponse.class);
				int statuscode=response.getStatusCodeValue();
				if(statuscode== 200) {
					return "Department is exist";			
				}
				else
					return "Department is not exist";
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}else {
			throw new RemoteServiceNotAvalableException("Custom exception for spring retyr");
			
		}
		return null;
	}

}
