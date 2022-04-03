package com.main.browse.config;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BloomConfig {

    @Bean
    public BloomFilter<Long> bloomFilterConfig() {
        return BloomFilter.create(Funnels.longFunnel(), 1000000, 0.01);
    }
}
