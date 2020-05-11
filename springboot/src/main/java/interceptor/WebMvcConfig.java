package interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired
	WebInterCeptor InterCeptor;
			
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub		
		//WebMvcConfigurer.super.addInterceptors(registry);
		//registry.addInterceptor(InterCeptor).addPathPatterns("/**");
		registry.addInterceptor(WebInterCeptor()).addPathPatterns("/**");
	}
	
	@Bean
	public WebInterCeptor WebInterCeptor() {
		return new WebInterCeptor();
	}

}