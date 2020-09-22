package com.example;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

@LogEvent
@Interceptor
public class LogInterceptor {

	private Logger logger = Logger.getLogger("txr-service");

	@AroundInvoke
	public Object aroundLog(InvocationContext invocationContext) {

		logger.info("before "+invocationContext.getMethod().toGenericString());
		Object obj = null;
		try {
			obj = invocationContext.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("after "+invocationContext.getMethod().toGenericString());
		return obj;

	}

}
