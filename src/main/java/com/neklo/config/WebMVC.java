package com.neklo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by vladosby on 19.01.15.
 */

@Configuration
@EnableWebMvc
@Import(value = JavaConfig.class)
public class WebMVC extends WebMvcConfigurerAdapter {
}
