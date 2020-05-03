package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



@Component
public class WebInterCeptor implements HandlerInterceptor{
	
	public static String access_token = "a";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("시작:"+request.getHeader("token"));
		if(!access_token.equals(request.getHeader("token"))) {
			throw new IllegalArgumentException("토큰정보가 일치하지 않습니다.");
		}
		return true;
		// TODO Auto-generated method stub
		//return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("되냐?");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	

}
