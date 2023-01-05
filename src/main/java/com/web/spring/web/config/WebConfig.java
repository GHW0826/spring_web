package com.web.spring.web.config;

import com.web.spring.api.interceptor.LoginAuthApiInterceptor;
import com.web.spring.web.argumentresolver.LoginAuthArgumentResolver;
import com.web.spring.web.interceptor.LogInterceptor;
import com.web.spring.web.interceptor.LoginAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginAuthInterceptor())
                .order(3)
                .addPathPatterns("/web/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error")
                .excludePathPatterns("/web", "/web/users/join", "/web/login", "/web/logout", "/web/jusoPopup");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginAuthArgumentResolver());
    }
}
