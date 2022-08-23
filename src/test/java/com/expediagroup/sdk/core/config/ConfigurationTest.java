package com.expediagroup.sdk.core.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Configuration")
public class ConfigurationTest {

    @Test
    @DisplayName("defaults with overloaded constructor")
    public void testConfigurationOverload() {
        ClientCredentials credentials = new ClientCredentials("id", "secret");
        Configuration config = new Configuration(new ClientConfiguration(credentials));
        assertThat(config.getClientConfiguration().getAuth()).isSameAs(credentials);
        assertThat(config.getLogging().getLevel()).isEqualTo(LoggingConfiguration.LogLevel.WARNING);
    }
}
