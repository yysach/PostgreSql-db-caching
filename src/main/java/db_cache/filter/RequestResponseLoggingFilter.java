package db_cache.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class RequestResponseLoggingFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long requestTimestamp = System.currentTimeMillis();
		chain.doFilter(request, response);
		long responseTimestamp = System.currentTimeMillis();
		System.out.println("time taken to handle request : " + (responseTimestamp - requestTimestamp) + " milliseconds");
	}

}
