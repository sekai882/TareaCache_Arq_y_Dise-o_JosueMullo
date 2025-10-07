package com.josue.backendcalculadorasueldo;

import java.time.Duration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("salarios");
        cacheManager.setCaffeine(
                Caffeine.newBuilder()
                        .expireAfterWrite(Duration.ofMinutes(10)) // dura 10 minutos
                        .maximumSize(100) // máximo 100 elementos
        );
        return cacheManager;
    }
}
