package com.ri.service;

import java.util.Random;

import com.ri.exception.RemoteServiceNotAvalableException;

public class RetryServiceImpl implements RetryService {

	@Override
	public String getResponce(boolean simulateretry, boolean simulateretryfallback) {
		
		if (simulateretry) {
            System.out.println("Simulateretry is true, so try to simulate exception scenario.");
 
            if (simulateretryfallback) {
                throw new RemoteServiceNotAvalableException(
                        "Don't worry!! Just Simulated for Spring-retry..Must fallback as all retry will get exception!!!");
            }
            int random = new Random().nextInt(4);
 
            System.out.println("Random Number : " + random);
            if (random % 2 == 0) {
                throw new RemoteServiceNotAvalableException("Don't worry!! Just Simulated for Spring-retry..");
            }
        }
 
        return "Hello from Remote Backend!!!";

		
		
	}

	@Override
	public String getResponceFallback() {
		System.out.println("All retries completed, so Fallback method called!!!");
        return "All retries completed, so Fallback method called!!!";

	}

}
