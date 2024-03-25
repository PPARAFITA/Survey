package com.sqa.thermometer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {



        @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/thermometer") // Especifica el path de tu API
                .allowedOrigins("http://localhost:3000") // Permite solicitudes desde el origen de tu aplicación de React
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir los métodos HTTP necesarios
                .allowCredentials(true); // Permitir credenciales
    }
}