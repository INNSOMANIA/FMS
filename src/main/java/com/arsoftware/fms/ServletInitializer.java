package com.arsoftware.fms;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {

        "com.arsoftware.fms.customer",
        "com.arsoftware.fms.company",
        "com.arsoftware.fms.operation",
        "com.arsoftware.fms.flight",
        "com.arsoftware.fms.airport",
        "com.arsoftware.fms.plane",

})
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FmsApplication.class);
    }

}
