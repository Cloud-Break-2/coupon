package com.example.couponcore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 모든 경로에 대해 CORS 허용
                        .allowedOrigins("*") // 허용할 도메인 설정
                        .allowedMethods("GET", "POST") // 허용할 HTTP 메서드
                        .allowedHeaders("*") // 모든 헤더 허용
                        .allowCredentials(true) // 인증 정보(Cookies 등) 허용
                        .maxAge(3600); // 요청 캐싱 시간 (초)
            }
        };
    }
}
