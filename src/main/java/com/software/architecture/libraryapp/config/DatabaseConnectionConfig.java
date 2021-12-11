package com.software.architecture.libraryapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:databaseConnection.properties")
public class DatabaseConnectionConfig {
}
