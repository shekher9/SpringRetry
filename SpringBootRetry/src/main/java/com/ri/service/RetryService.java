package com.ri.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import com.ri.exception.RemoteServiceNotAvalableException;
import com.ri.response.DepartmentResponse;

public interface RetryService {
	
	/*
	 * @Retryable(value = {RemoteServiceNotAvalableException.class},maxAttempts =
	 * 3,backoff = @Backoff(delay = 1000)) public String getResponce(boolean
	 * simulateretry, boolean simulateretryfallback);
	 */
	
	@Retryable(value = {RemoteServiceNotAvalableException.class},maxAttempts = 3,backoff = @Backoff(delay = 1000))
	public String getResponce(Integer id);
	
	@Recover
	public String getResponceFallback();
	

}
