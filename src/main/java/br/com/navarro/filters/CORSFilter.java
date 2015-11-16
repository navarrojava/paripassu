package br.com.navarro.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;
/**
 * 
 * @author navarro
 *
 */

public class CORSFilter extends OncePerRequestFilter {

	private static final Logger LOG = LoggerFactory.getLogger(CORSFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");

		if (request.getHeader("Access-Control-Request-Method") != null && "OPTIONS".equals(request.getMethod())) {
			LOG.info("Sending Header....");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			// response.addHeader("Access-Control-Allow-Headers", "Authorization");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type");
			response.addHeader("Access-Control-Max-Age", "1");
		}

		filterChain.doFilter(request, response);
	}
}
