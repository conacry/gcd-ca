package com.conacry.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "open-api")
public class OpenApiProperties {

    private String title;
    private String description;
    private String maintainerName;
    private String maintainerEmail;
}
