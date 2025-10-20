package br.edu.ufrn.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.PathMatchConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class WebConfig implements WebFluxConfigurer {
    
    @Override
    public void configurePathMatching(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(
            "/restapi",
            c -> c.isAnnotationPresent(RestController.class)
        );
    }
    
}
