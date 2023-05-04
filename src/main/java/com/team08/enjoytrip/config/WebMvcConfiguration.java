package com.team08.enjoytrip.config;

import com.team08.enjoytrip.common.interceptor.AuthWithSessionAjaxInterceptor;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    private final List<String> PATTERNS = Arrays.asList("/users/**","/articles/**");
    /*
    private AuthWithSessionAjaxInterceptor authWithSessionAjaxInterceptor;

    public WebMvcConfiguration(AuthWithSessionAjaxInterceptor authWithSessionAjaxInterceptor) {
        this.authWithSessionAjaxInterceptor = authWithSessionAjaxInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authWithSessionAjaxInterceptor).addPathPatterns(PATTERNS);
        // TODO: Auth(Token), then change to below
        // registry.addInterceptor(authWithTokenInterceptor).addPathPatterns(PATTERNS);
    }
    */
    //TODO: JWTFilter
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO: setting pattern CORS
        registry.addMapping("http://localhost:3000/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
}
