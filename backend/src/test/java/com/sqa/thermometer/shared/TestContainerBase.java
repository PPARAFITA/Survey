package com.sqa.thermometer.shared;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public class TestContainerBase implements ParameterResolver {
    private static final String APP_USER = "user";
    private static final String APP_USER_PASSWORD = "pwd";
    private static final String DATABASE = "thermometer";
    private static final String MYSQL_IMAGE = "mysql:8.0.36";

    private static final MySQLContainer<?> mysql = new MySQLContainer<>(DockerImageName.parse(MYSQL_IMAGE))
            .withDatabaseName(DATABASE)
            .withUsername(APP_USER)
            .withPassword(APP_USER_PASSWORD);

    static {
        mysql.start();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("driver-class-name", mysql::getDriverClassName);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType().equals(MySQLContainer.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
        return mysql;
    }
}
