package com.speed.mixer.config;

import com.speed.mixer.converter.RoleToUserProfileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by sambit on 2/10/2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.speed.mixer")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Autowired
    RoleToUserProfileConverter roleToUserProfileConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleToUserProfileConverter);
    }


}
