package com.allook.frame;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;


@Component
public class AccessFilter extends ZuulFilter{
	private static final Logger logger = Logger.getLogger(AccessFilter.class);
    
	//前置过滤器
	@Override
	public String filterType() {
		return "pre";
	}

	
	@Override
	public boolean shouldFilter() {   
		//是否执行该过滤器，true代表需要过滤
		return true;
	} 

	@Override
	public Object run() {
		 logger.info("Zuul：localhost:8040");
		 RequestContext ctx = RequestContext.getCurrentContext();
	     HttpServletRequest request = ctx.getRequest();
	     request.setAttribute("Zuul","localhost:8040");
		 return null;
	}

	@Override
	public int filterOrder() {
		//优先级，数字越大，优先级越低
		return 0;
	}
}
