package com.article.articlewebservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.article.articlewebservice.web.ArticleJAXRS;


@Configuration
public class Config {
    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(ArticleJAXRS.class);
        return jerseyServlet;

    }
}
