package com.epam.course.store.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StoreConfiguration {

    private final Property property;

    @Autowired
    public StoreConfiguration(Property property) {
        this.property = property;
    }

    @Bean
    @ConditionalOnWebApplication
    public TestConfiguration testConfigurationOnWebApplication() {
        return new TestConfiguration(property.getProperty().toUpperCase());
    }

    @Bean
    @ConditionalOnNotWebApplication
    public TestConfiguration testConfigurationDefault() {
        return new TestConfiguration("default");
    }
}
