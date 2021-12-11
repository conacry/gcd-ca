package com.conacry;

import org.junit.jupiter.api.extension.Extension;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresExtension implements Extension {

    static {
        PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:12.5-alpine")
                .withExposedPorts(5432)
                .withDatabaseName("gcd_db");
        postgresContainer.start();

        System.setProperty("spring.datasource.dataSourceProperties.serverName", postgresContainer.getContainerIpAddress());
        System.setProperty("spring.datasource.dataSourceProperties.portNumber", String.valueOf(postgresContainer.getFirstMappedPort()));
        System.setProperty("spring.datasource.username", postgresContainer.getUsername());
        System.setProperty("spring.datasource.password", postgresContainer.getPassword());
    }
}
