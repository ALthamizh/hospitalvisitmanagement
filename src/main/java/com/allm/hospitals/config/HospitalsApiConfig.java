package com.allm.hospitals.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import jakarta.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/1.0")
public class HospitalsApiConfig extends ResourceConfig {

    public HospitalsApiConfig() {
        packages("com.allm.hospitals.resources");
        packages("com.allm.hospitals.exceptions");
    }

}
