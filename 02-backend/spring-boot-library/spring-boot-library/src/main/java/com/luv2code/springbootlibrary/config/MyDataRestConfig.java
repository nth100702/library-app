package com.luv2code.springbootlibrary.config;

import com.luv2code.springbootlibrary.entity.Book;
import com.luv2code.springbootlibrary.entity.Message;
import com.luv2code.springbootlibrary.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String theAllowedOrigins="https://localhost:3000";

//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors){
//
//        HttpMethod[] theUnsupprtedActions={
//                HttpMethod.POST,
//                HttpMethod.PATCH,
//                HttpMethod.DELETE,
//                HttpMethod.PUT};
//
//        config.exposeIdsFor(Book.class);
//        config.exposeIdsFor(Review.class);
//        config.exposeIdsFor(Message.class);
//
//        disableHttpMethods(Book.class, config, theUnsupprtedActions);
//        disableHttpMethods(Review.class, config, theUnsupprtedActions);
//        disableHttpMethods(Message.class, config, theUnsupprtedActions);
//
//        /* Configure CORS Mapping */
//        cors.addMapping(config.getBasePath()+"/**")
//                .allowedOrigins(theAllowedOrigins);
//    }
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupprtedActions = {
            HttpMethod.POST,
            HttpMethod.PATCH,
            HttpMethod.DELETE,
            HttpMethod.PUT
    };

    config.exposeIdsFor(Book.class);
    config.exposeIdsFor(Review.class);
    config.exposeIdsFor(Message.class);

    disableHttpMethods(Book.class, config, theUnsupprtedActions);
    disableHttpMethods(Review.class, config, theUnsupprtedActions);
    disableHttpMethods(Message.class, config, theUnsupprtedActions);

    /* Configure CORS Mapping */
    cors.addMapping(config.getBasePath() + "/**")
            .allowedOrigins(theAllowedOrigins) // Allowing requests from localhost:3000
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed methods
            .allowedHeaders("*") // Allowing all headers
            .allowCredentials(true); // If you need to send cookies or authorization headers
}

    public void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions){
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }
}
