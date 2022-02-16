package br.com.alura.mudi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.alura.mudi.api.interceptor.InterceptadorDeAcessos;

//@Configuration
//public class WebConfig extends WebMvcConfigurationSupport{
//
//	@Override
//	protected void addInterceptors(InterceptorRegistry registry) {
////		addPathPatterns("/**");  ASSIM DIZ QUE É TODOS os caminhos serao rastreados
//		registry.addInterceptor(new InterceptadorDeAcessos()).addPathPatterns("/**"); 
//	}
//}




//Teve que ser assim porque o outro método era antigo
@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		addPathPatterns("/**");  ASSIM DIZ QUE É TODOS os caminhos serao rastreados
		registry.addInterceptor(new InterceptadorDeAcessos()).addPathPatterns("/**"); 
	
	}	

}