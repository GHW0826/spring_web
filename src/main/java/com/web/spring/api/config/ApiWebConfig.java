package com.web.spring.api.config;

import com.web.spring.api.interceptor.LoginAuthApiInterceptor;
import com.web.spring.web.argumentresolver.LoginAuthArgumentResolver;
import com.web.spring.web.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class ApiWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error");

        /*
        registry.addInterceptor(new LoginAuthInterceptor())
                .order(2)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error")
                .excludePathPatterns("/", "/users/join", "/login", "/logout");

         */

        /*
        registry.addInterceptor(new LoginAuthApiInterceptor())
                .order(2)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error")
                .excludePathPatterns("/api", "/api/users/join", "/api/login", "/api/logout");

         */
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginAuthArgumentResolver());
    }
}

